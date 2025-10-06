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


        //Criando baralho que já vem com todas as cartas
        Baralho baralhoI = new Baralho();
        Jogador jogador1 = new Jogador("Desireê", baralhoI, new Campo());
        Jogador jogador2 = new Jogador("Alice", baralhoI, new Campo());

        //aqui estou usando um array de valor fixo sendo declarado com (LIST.OF)
        //Nada após sua criação pode altará-la.
        Game jogo = new Game(List.of(jogador1, jogador2));
        jogo.distribuirCartasIniciais();
        jogo.iniciarJogo();

      //  //Iniciando turnos:
      //  //chamando dois jogadores
      //  List<Jogador> jogadores = new ArrayList<>();
      //  jogadores.add(jogador1);
      //  jogadores.add(jogador2);
//
      //  //Sinalizando turno do primeiro jogador
      //  Jogador jogadorAtual = jogo.getJogadorAtual();
      //  System.out.println("Turno de: " + jogo.getJogadorAtual().getName() + "\n");
      //  //ações
      //  jogadorAtual.mostrarMao();
      //  jogadorAtual.JogarCard();
//
      //  jogo.proximoTurno();
//
      //  //Sinalizando segundo jogador
      //  jogadorAtual = jogo.getJogadorAtual();
      //  System.out.println("\nTurno de: " + jogo.getJogadorAtual().getName() + "\n");
      //  //ações do jogador
      //  jogadorAtual.mostrarMao();
      //  jogadorAtual.JogarCard();
//
      //  //Criando obj do tipo batalha
      //  Batalha batalha = new Batalha();
//
      //  //aqui já chamo a batalha com tudo que é necessário, só preciso passar os jogadores.
      //  batalha.iniciarBatalha(jogador1, jogador2);
      //}
}
}

