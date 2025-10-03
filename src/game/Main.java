package game;

import cards.Criatura;
import cards.Magia;
import cards.Card;
import baralho.Baralho;

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
        System.out.println("Total de cartas no baralho: " + baralhoI.quantidadeCartas());

        //Usando a função de chamar um cards.Card aléatório através do indice do array e a função Random do java util.
        Card cartaSorteada = baralhoI.randomCard();
        cartaSorteada.mostrarCard();

        //Criei aqui um array de dados genericos para usar um iterador que irá criar as cartas com essas informações e adcionar ao meu baralho.

        List<String[]> dadosCartas = new ArrayList<>();
        dadosCartas.add(new String[]{"Coelho Veloz", "Branquinho e bravinho, sou o coelhinho!", "8", "4"});
        dadosCartas.add(new String[]{"Dragão Lunar", "Um dragão que brilha à noite", "10", "6"});
        dadosCartas.add(new String[]{"Rato Ninja", "Silencioso e mortal", "6", "3"});
        dadosCartas.add(new String[]{"Fênix Flamejante", "Renascida das chamas", "9", "5"});
        dadosCartas.add(new String[]{"Tigre das Sombras", "Ataques rápidos e silenciosos", "7", "4"});
        dadosCartas.add(new String[]{"Troll da Montanha", "Lento, mas resistente", "5", "10"});
        dadosCartas.add(new String[]{"Serpente Elétrica", "Choques paralisantes", "6", "3"});
        dadosCartas.add(new String[]{"Grifo Celeste", "Voa alto e ataca com garras afiadas", "8", "7"});
        dadosCartas.add(new String[]{"Lobo Fantasma", "Desaparece nas sombras", "7", "5"});
        dadosCartas.add(new String[]{"Urso de Ferro", "Defesa quase impenetrável", "6", "9"});
        dadosCartas.add(new String[]{"Velociraptor Ignis",  "Um predador ágil que corre entre as chamas...", "5", "5"});
        dadosCartas.add(new String []{" Chinelada de mãe! ","IMPOSSIVEL BLOQUEAR. Não pode se defender do ataque dessa criatura.", "3", "0" });



        //aqui estou criando o array vazio [] e iterando a lista, adcionando cada dado em sua variavel acessando o indice.
        // criando novas cartas atraves do loop e já adcionando ao baralho.
        for (String[] dadosCarta : dadosCartas) {
            String nome = dadosCarta [0];
            String descricao = dadosCarta[1];
            int atk = Integer.parseInt(dadosCarta[2]);
            int def = Integer.parseInt(dadosCarta[3]);

            Criatura criatura = CartaFactory.criarCriatura(nome, descricao, atk, def);
            baralhoI.addCriatura(criatura);
        }

        baralhoI.mostrarCards();




    }
}