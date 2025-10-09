package model.baralho;

import kong.unirest.json.JSONObject;
import model.cards.Criatura;
import model.cards.Magia;
import model.cards.Card;
import model.cards.TipoMagia;
import game.CartaFactory;
import service.MTGService;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;


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

        System.out.println("Cartas criadas: " + quantidadeCartas());
        System.out.println("Criaturas: " + criaturas.size() + ", Magias: " + magias.size());

    }

    //aqui estou inserindo dois tipos de model.cards, porém, todos string, então vou utilizar para popular meu model.baralho.

    //REFATORAÇÃO: Remover dados fixos [mocados] e adcionar dados dinamicos da api MTG.

    private MTGService MTG = new MTGService();

    private void inicializarDados(){
       // dadosCriaturas.add(new String[]{"Coelho Veloz", "Branquinho e bravinho, sou o coelhinho!", "8", "4"});
       // dadosCriaturas.add(new String[]{"Dragão Lunar", "Um dragão que brilha à noite", "10", "6"});
       // dadosCriaturas.add(new String[]{"Rato Ninja", "Silencioso e mortal", "6", "3"});
       // dadosCriaturas.add(new String[]{"Fênix Flamejante", "Renascida das chamas", "9", "5"});
       // dadosCriaturas.add(new String[]{"Tigre das Sombras", "Ataques rápidos e silenciosos", "7", "4"});
       // dadosCriaturas.add(new String[]{"Troll da Montanha", "Lento, mas resistente", "5", "10"});
       // dadosCriaturas.add(new String[]{"Serpente Elétrica", "Choques paralisantes", "6", "3"});
       // dadosCriaturas.add(new String[]{"Grifo Celeste", "Voa alto e ataca com garras afiadas", "8", "7"});
       // dadosCriaturas.add(new String[]{"Lobo Fantasma", "Desaparece nas sombras", "7", "5"});
       // dadosCriaturas.add(new String[]{"Urso de Ferro", "Defesa quase impenetrável", "6", "9"});
       // dadosCriaturas.add(new String[]{"Velociraptor Ignis", "Um predador ágil que corre entre as chamas...", "5", "5"});
       // dadosMagias.add(new String[]{"Bola de Fogo", "Lança uma esfera flamejante que explode em impacto", "4", "0", "INIMIGO"});
       // dadosMagias.add(new String[]{"Relâmpago", "Um raio que atinge instantaneamente o inimigo", "5", "0", "INIMIGO"});
       // dadosMagias.add(new String[]{"Cura", "Restaura parte da vida de uma criatura aliada", "0", "4", "ALIADO"});
       // dadosMagias.add(new String[]{"Escudo Arcano", "Cria uma barreira mágica temporária", "0", "5", "ALIADO"});
       // dadosMagias.add(new String[]{"Nevasca", "Congela os inimigos, reduzindo sua velocidade", "3", "2", "INIMIGO"});
       // dadosMagias.add(new String[]{"Veneno Sombrio", "Enfraquece o inimigo lentamente", "2", "1", "INIMIGO"});
       // dadosMagias.add(new String[]{"Luz Divina", "Purifica e fortalece as defesas do aliado", "0", "6", "ALIADO"});
       // dadosMagias.add(new String[]{"Explosão Sísmica", "Causa um tremor que atinge todos os inimigos", "6", "0", "INIMIGO"});
       // dadosMagias.add(new String[]{"Ilusão", "Confunde o adversário, reduzindo sua defesa", "1", "3", "INIMIGO"});
       // dadosMagias.add(new String[]{"Benção dos Ancestrais", "Aumenta o ataque e defesa de todos os aliados", "2", "2", "ALIADO"});
       // dadosMagias.add(new String[]{"Chinelada de mãe!", "IMPOSSIVEL BLOQUEAR. Não pode se defender do ataque dessa criatura.", "3", "0", "INIMIGO"});


        //Aqui seria a lista de compras, api o mercado.
        //vou buscar tudo que está na lista dentro da api.

        //NO MOMENTO ARRAYFIXO
        //USAR ArrayList FLEXIVEL
        List<String> nomesCards = MTG.listarNomesCartas("ltr");


        //TRAVEI POR TEMPO AQUI..
        //Limitei o baralho a 8 cartas e ocorreu um erro de lógica que me prendeu por quase uma tarde. a importancia de manter o problema em pedaços é claro.
        int limite = Math.min(60, nomesCards.size());
        nomesCards = nomesCards.subList(0, limite);


        //Iterando sobre nomes dos cartas usando forEach.
        //Para cada nome em nomeCards...
        for (String nome : nomesCards) {

            //dadosCriaturas.add(new String[]{"Coelho Veloz", "Branquinho e bravinho!", "8", "4"});
            //dadosMagias.add(new String[]{"Bola de Fogo", "Explosão!", "4", "0", "INIMIGO"});

            JSONObject cardJson = MTG.buscarCard(nome);


            if (cardJson == null) continue;

            String tipo = cardJson.optString("type_line", "").toLowerCase();
            String nomeImpresso = cardJson.optString("printed_name", cardJson.optString("name"));
            String texto = cardJson.optString("printed_text",  cardJson.optString("oracle_text", "Sem descrição"));
            String poder = cardJson.optString("power", "0");
            String resistencia = cardJson.optString("toughness", "0");

            if (tipo.contains("creature") || tipo.contains("human") || tipo.contains("elf")){

                System.out.println("Nome: " + nomeImpresso + " | Tipo: " + tipo + " | Power: " + poder + " | Toughness: " + resistencia);

                Criatura criatura = CartaFactory.criarCriatura(
                        nomeImpresso,
                        texto,
                        Integer.parseInt(poder),
                        Integer.parseInt(resistencia)

                );

                criaturas.add(criatura);



            }  else if (tipo.contains("instant") || tipo.contains("sorcery") || tipo.contains("enchantment")) {

                Magia magia = CartaFactory.criarMagia(
                        nomeImpresso,
                        texto,
                        0,
                        0,
                        TipoMagia.INIMIGO
                );
                addMagia(magia);

            }
        }



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



    //Adciona criatura (param) ao model.baralho

    public void addCriatura(Criatura criatura){
        this.criaturas.add(criatura);
    }
    //Adciona magia (param) ao model.baralho
    public void addMagia(Magia magia){
        this.magias.add(magia);
    }

    //Mostra cartas do model.baralho iterando as duas litas de model.cards

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

    //Função criada para selecionar uma carta aleatória dentro do model.baralho.
    //Utilizando o numero de cartas para determinar a randomização.
    Random random  = new Random();
    public Card randomCard(){
        int total = quantidadeCartas();

        if (total == 0) {
            return null; // verifica se não possui nada para comprar
        }

        int randomCard = random.nextInt(total);

        if (randomCard < criaturas.size() ){
            return criaturas.get(randomCard); //criatura

        } else {
            return magias.get(randomCard - criaturas.size()); //magia
        }
    }

    //Visto que a função comprarcard do model.jogador não estava removendo a carta do model.baralho
    //deleguei as funções, essa chama a carta random e verifica seu tipo, após isso .remove do array model.baralho e retorna o card.
    public Card comprarCard(){
        Card card = randomCard();
        int total = quantidadeCartas();

        if (total == 0) {
            System.out.println("⚠️ O baralho está vazio, nenhuma carta pode ser comprada.");
            return null;
        }
        // Debug
        System.out.println("🔎 Quantidade total de cartas no baralho: " + total);
        System.out.println("🔹 Criaturas: " + criaturas.size() + " | Magias: " + magias.size());


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
