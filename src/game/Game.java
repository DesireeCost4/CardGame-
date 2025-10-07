package game;
import jogador.Jogador;



import java.util.List;
import java.util.Scanner;

import cards.Card;


public class Game {



    private Campo campo;


    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        boolean jogoAtivo = true;

        while (jogoAtivo) {



            Jogador jogadorAtual = getJogadorAtual();
            Jogador jogadorOponente = jogadores.get((turnoAtual + 1) % jogadores.size());

            System.out.println("\n============================");
            System.out.println(" INICIANDO TURNO DE " + jogadorAtual.getName().toUpperCase());
            System.out.println("============================\n");

            // Verifica condição de vitória: vida zerada ou baralho vazio
            if (jogadorAtual.getVida() <= 0 || jogadorOponente.getVida() <= 0 ||
                    jogadorAtual.getBaralho().estaVazio() || jogadorOponente.getBaralho().estaVazio()) {

                if (jogadorAtual.getVida() <= 0 || jogadorAtual.getBaralho().estaVazio()) {
                    System.out.println(jogadorOponente.getName() + " venceu!");
                } else {
                    System.out.println(jogadorAtual.getName() + " Venceu!");
                }
                break; // encerra o jogo
            }

            // Mostrar mão do jogador atual
            //jogadorAtual.mostrarMao();


            // Escolher carta
            int indice = -1;
            boolean indiceValido = false;
            while (!indiceValido) {

                System.out.println("\n🟢============================🟢");

                jogadorAtual.mostrarMao();
                System.out.println("🟢============================🟢");

                System.out.print("🎯 Escolha a carta para jogar (digite o índice): ");
                if (scanner.hasNextInt()) {
                    indice = scanner.nextInt();
                    if (indice >= 0 && indice < jogadorAtual.getMao().size()) {
                        indiceValido = true;
                    } else {
                        System.out.println("\n ❌ Índice inválido! Tente novamente.");
                    }
                } else {
                    System.out.println("\n ❌ Digite um número válido!");
                    scanner.next(); // descarta entrada inválida
                }
            }

            // Jogar carta
            //jogadorAtual.JogarCard(indice, jogadorOponente);
            jogadorAtual.jogarCard(indice, jogadorOponente);
            Batalha batalha = new Batalha();
            batalha.iniciarBatalha(jogadorAtual, jogadorOponente);
            // Avança o turno
            proximoTurno();

        }

        System.out.println("\nFim de jogo!");
        scanner.close();
    }


    //Criando uma lista do tipo jogador onde cada indice será um jogador
    private List<Jogador> jogadores;
   private int turnoAtual;

   //construtor
    Game (int turnoAtual) {
        this.turnoAtual = turnoAtual;
    }



    public Game(List<Jogador> jogadores){
        this.jogadores = jogadores;
        this.turnoAtual = 0;
        this.campo = new Campo();
    }

    public Jogador getJogadorAtual() {
        return jogadores.get(turnoAtual % jogadores.size());
    }

    public void proximoTurno() {
        turnoAtual++;
    }

    public void distribuirCartasIniciais(){

        for(Jogador jogador : jogadores){
            int cartasIniciais = 7;
            for(int i = 0; i < cartasIniciais; i++){
                jogador.comprarCard();
            }
        }

    }

}
