package baralho;

import cards.Criatura;
import cards.Magia;
import cards.Card;
import cards.TipoMagia;
import game.CartaFactory;

import java.util.ArrayList;
import java.util.Random;

public class Baralho {

    private ArrayList<String[]> dadosCriaturas = new ArrayList<>();
    private ArrayList<String[]> dadosMagias = new ArrayList<>();

    //Criei dois arrays para cada tipo de carta
    private ArrayList<Criatura> criaturas = new ArrayList<Criatura>();
    private ArrayList<Magia> magias = new ArrayList<Magia>();


    public Baralho () {
        this.criaturas = new ArrayList<>();
        this.magias = new ArrayList<>();

        inicializarDados();
        inicilizarCartas();

    }

    //aqui estou inserindo dois tipos de cards, porém, todos string, então vou utilizar para popular meu baralho.

    private void inicializarDados(){
        dadosCriaturas.add(new String[]{"Coelho Veloz", "Branquinho e bravinho, sou o coelhinho!", "8", "4"});
        dadosCriaturas.add(new String[]{"Dragão Lunar", "Um dragão que brilha à noite", "10", "6"});
        dadosCriaturas.add(new String[]{"Rato Ninja", "Silencioso e mortal", "6", "3"});
        dadosCriaturas.add(new String[]{"Fênix Flamejante", "Renascida das chamas", "9", "5"});
        dadosCriaturas.add(new String[]{"Tigre das Sombras", "Ataques rápidos e silenciosos", "7", "4"});
        dadosCriaturas.add(new String[]{"Troll da Montanha", "Lento, mas resistente", "5", "10"});
        dadosCriaturas.add(new String[]{"Serpente Elétrica", "Choques paralisantes", "6", "3"});
        dadosCriaturas.add(new String[]{"Grifo Celeste", "Voa alto e ataca com garras afiadas", "8", "7"});
        dadosCriaturas.add(new String[]{"Lobo Fantasma", "Desaparece nas sombras", "7", "5"});
        dadosCriaturas.add(new String[]{"Urso de Ferro", "Defesa quase impenetrável", "6", "9"});
        dadosCriaturas.add(new String[]{"Velociraptor Ignis", "Um predador ágil que corre entre as chamas...", "5", "5"});
        dadosMagias.add(new String[]{"Bola de Fogo", "Lança uma esfera flamejante que explode em impacto", "4", "0", "INIMIGO"});
        dadosMagias.add(new String[]{"Relâmpago", "Um raio que atinge instantaneamente o inimigo", "5", "0", "INIMIGO"});
        dadosMagias.add(new String[]{"Cura", "Restaura parte da vida de uma criatura aliada", "0", "4", "ALIADO"});
        dadosMagias.add(new String[]{"Escudo Arcano", "Cria uma barreira mágica temporária", "0", "5", "ALIADO"});
        dadosMagias.add(new String[]{"Nevasca", "Congela os inimigos, reduzindo sua velocidade", "3", "2", "INIMIGO"});
        dadosMagias.add(new String[]{"Veneno Sombrio", "Enfraquece o inimigo lentamente", "2", "1", "INIMIGO"});
        dadosMagias.add(new String[]{"Luz Divina", "Purifica e fortalece as defesas do aliado", "0", "6", "ALIADO"});
        dadosMagias.add(new String[]{"Explosão Sísmica", "Causa um tremor que atinge todos os inimigos", "6", "0", "INIMIGO"});
        dadosMagias.add(new String[]{"Ilusão", "Confunde o adversário, reduzindo sua defesa", "1", "3", "INIMIGO"});
        dadosMagias.add(new String[]{"Benção dos Ancestrais", "Aumenta o ataque e defesa de todos os aliados", "2", "2", "ALIADO"});
        dadosMagias.add(new String[]{"Chinelada de mãe!", "IMPOSSIVEL BLOQUEAR. Não pode se defender do ataque dessa criatura.", "3", "0", "INIMIGO"});

    }


    private void inicilizarCartas(){
        for (String[] dados: dadosCriaturas){
            Criatura   criatura = CartaFactory.criarCriatura(
                    dados[0],dados[1],
                    Integer.parseInt(dados[2]),
                    Integer.parseInt(dados[3])
            );
            addCriatura(criatura);
        }

        for (String[] dados: dadosMagias){
            TipoMagia tipo = TipoMagia.valueOf(dados[4]);
            Magia magia = CartaFactory.criarMagia(
                    dados[0],dados[1],
                    Integer.parseInt(dados[2]),
                    Integer.parseInt(dados[3]),
                    tipo
            );
            addMagia(magia);
        }
    }



    //Adciona criatura (param) ao baralho

    public void addCriatura(Criatura criatura){
        this.criaturas.add(criatura);
    }
    //Adciona magia (param) ao baralho
    public void addMagia(Magia magia){
        this.magias.add(magia);
    }

    //Mostra cartas do baralho iterando as duas litas de cards

    public void mostrarCards(){
        for (Criatura criatura : criaturas){
            criatura.mostrarCard();
        }

        for (Magia magia : magias){
            magia.mostrarCard();
        }
    }

    //Pega o numero da quantidade de criaturas e magias e retorna
    public int quantidadeCartas(){
        return this.criaturas.size() + this.magias.size();
    }

    //Função criada para selecionar uma carta aleatória dentro do baralho.
    //Utilizando o numero de cartas para determinar a randomização.
    Random random  = new Random();
    public Card randomCard(){
        int total = quantidadeCartas();
        int randomCard = random.nextInt(total);

        if (randomCard < criaturas.size() ){
            return criaturas.get(randomCard); //criatura

        } else {
            return magias.get(randomCard - criaturas.size()); //magia
        }
    }

    //Visto que a função comprarcard do jogador não estava removendo a carta do baralho
    //deleguei as funções, essa chama a carta random e verifica seu tipo, após isso .remove do array baralho e retorna o card.
    public Card comprarCard(){
        Card card = randomCard();

        if(card instanceof  Criatura){
            criaturas.remove(card);
        }else{
            magias.remove(card);
        }

        return card;
    }

    public boolean estaVazio() {
        return criaturas.isEmpty() && magias.isEmpty();
    }

}
