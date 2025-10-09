package game;

import model.baralho.Baralho;
import model.jogador.Jogador;
import service.MTGService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {




        Scanner input = new Scanner(System.in);


        MTGService scryfall = new MTGService();

        //System.out.print("Digite o nome da carta: ");
        //String nome = input.nextLine();
//
        //String resultado = scryfall.buscarCard(nome);
        //System.out.println(resultado);

        System.out.println("=== Bem-vindo! ===");
        System.out.println("=== TXT.Game ===");
        System.out.println("1 - Iniciar Jogo");
        System.out.println("2 - Sair");

        System.out.print("Escolha uma opção: ");

        int opcao = input.nextInt();


        if (opcao == 1) {

            //Criando model.baralho que já vem com todas as cartas
            Baralho baralhoI = new Baralho();

            //devo criar outro model.baralho quando houver mais model.cards, apenas montando e testando
            Jogador jogador1 = new Jogador("Desireê", baralhoI, new Campo());
            Jogador jogador2 = new Jogador("Alice", baralhoI, new Campo());


            //aqui estou usando um array de valor fixo sendo declarado com (LIST.OF)
            //Nada após sua criação pode altará-la.
            Game jogo = new Game(List.of(jogador1, jogador2));

            //utilizando o metodo inicial de distribuição de cartas
            jogo.distribuirCartasIniciais();

            //chamando inicializador de jogo > onde acontece todos os turnos e regras da partida.
            jogo.iniciarJogo();



        } else if (opcao == 2) {
            System.out.println("Saindo, até a proxima!");
        }



}
}

