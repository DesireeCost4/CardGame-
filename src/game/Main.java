package game;

import cards.Criatura;
import cards.Magia;
import cards.Card;
import baralho.Baralho;
import jogador.Jogador;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        //Criando os objetos manualmente
       //Criatura cururuAzul = new Criatura("Cururu Azul", "Dizem que ficou azul porque lavou o pé!", 1, 2);
       Magia escudoDeTartaruga = new Magia("Escudo de Tartaruga", "Essa tartaruga empresta seu escudo a criatura selecionada durante dois turnos, a criatura recebe DEF +5.", 0, 5);

        //01. Testando Objetos e métodos:
        //chineladaDeMae.aplicarMagia(cururuAzul);
        //cryoSaurus.mostrarCard();


        //02. Criando um novo arrayList baralho:
        Baralho baralhoI = new Baralho();

        //Adcionando cartas ao array através do metodo addCriatura, implementado na classe baralho.Baralho
        baralhoI.addMagia(escudoDeTartaruga);

        //Mostrando a lista de cartas adcionadas no array baralho percorrendo através de um for.
        //baralhoI.mostrarCards();

        //cartaSorteada.mostrarCard();

        //Criei aqui um array de dados genericos de criatura para usar um iterador que irá criar as cartas com essas informações e adcionar ao meu baralho.

        List<String[]> dadosCriaturas= new ArrayList<>();
        //adcionando itens através do metodo .add
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
        dadosCriaturas.add(new String[]{"Velociraptor Ignis",  "Um predador ágil que corre entre as chamas...", "5", "5"});


        List<String[]> dadosMagias = new ArrayList<>();
        //adcionando itens através do metodo .add
        dadosMagias.add(new String[]{"Bola de Fogo", "Lança uma esfera flamejante que explode em impacto", "4", "0"});
        dadosMagias.add(new String[]{"Relâmpago", "Um raio que atinge instantaneamente o inimigo", "5", "0"});
        dadosMagias.add(new String[]{"Cura", "Restaura parte da vida de uma criatura aliada", "0", "4"});
        dadosMagias.add(new String[]{"Escudo Arcano", "Cria uma barreira mágica temporária", "0", "5"});
        dadosMagias.add(new String[]{"Nevasca", "Congela os inimigos, reduzindo sua velocidade", "3", "2"});
        dadosMagias.add(new String[]{"Veneno Sombrio", "Enfraquece o inimigo lentamente", "2", "1"});
        dadosMagias.add(new String[]{"Luz Divina", "Purifica e fortalece as defesas do aliado", "0", "6"});
        dadosMagias.add(new String[]{"Explosão Sísmica", "Causa um tremor que atinge todos os inimigos", "6", "0"});
        dadosMagias.add(new String[]{"Ilusão", "Confunde o adversário, reduzindo sua defesa", "1", "3"});
        dadosMagias.add(new String[]{"Benção dos Ancestrais", "Aumenta o ataque e defesa de todos os aliados", "2", "2"});
        dadosMagias.add(new String []{" Chinelada de mãe! ","IMPOSSIVEL BLOQUEAR. Não pode se defender do ataque dessa criatura.", "3", "0" });

        //Usando a função de chamar um cards.Card aléatório através do indice do array e a função Random do java util.


        //aqui estou criando o array vazio [] e iterando a lista, adcionando cada dado em sua variavel através dp indice.
        // criando novas cartas atraves loop e já adcionando ao baralho.
        for (String[] dadosCriatura : dadosCriaturas) {
            String nome = dadosCriatura [0];
            String descricao = dadosCriatura[1];
            int atk = Integer.parseInt(dadosCriatura[2]);
            int def = Integer.parseInt(dadosCriatura[3]);



            Criatura criatura = CartaFactory.criarCriatura(nome, descricao, atk, def);
            baralhoI.addCriatura(criatura);
        }

        for (String [] dadosMagia : dadosMagias){
            String nome = dadosMagia[0];
            String descricao = dadosMagia[1];
            int atk = Integer.parseInt(dadosMagia[2]);
            int def = Integer.parseInt(dadosMagia[3]);

            Magia magia = CartaFactory.criarMagia(nome, descricao, atk, def);
            baralhoI.addMagia(magia);
        }

        Card cartaSorteada = baralhoI.randomCard();


        //baralhoI.mostrarCards();
        //System.out.println("Total de cartas no baralho: " + baralhoI.quantidadeCartas());

    //cartaSorteada.mostrarCard();


        //Agora vou criar um obj jogador passar os atributos:
        Jogador jogador = new Jogador("Desireê", baralhoI);

        //utilizando o metodo da classe jogador:
        //AO INICIAR  PARTIDA COMEÇAR COM X CARDS
        jogador.comprarCard();
        jogador.comprarCard();
        jogador.comprarCard();
        jogador.comprarCard();
        jogador.comprarCard();
        jogador.comprarCard();
        jogador.comprarCard();
        jogador.mostrarMao();
        jogador.JogarCard(5);


    }
}