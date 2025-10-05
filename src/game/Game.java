package game;
import jogador.Jogador;



import java.util.List;


public class Game {

    private Campo campo;

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

}
