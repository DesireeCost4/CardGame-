package jogador;

import baralho.Baralho;
import cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

    //aqui setando os atributos básicos
    //mao não é baralho e sim as cartas que o jogador está em maos, vendo e acessando.
    private String nome;
    private int vida;
    private Baralho baralho;
    private List<Card>mao;

    //Declarando o construtor, pois irá fácilitar na hora de criar o obj
    public Jogador(String nome, Baralho baralho) {
        this.nome = nome;
        this.baralho = baralho;
        this.vida = 20;
        this.mao = new ArrayList<>();
    }

    //Metodo comprar card.
    // primeiro cria uma variavel do tipo CARD e armazena o valor randomico da função random.
    //em seguida se o valor NÃO for nulo ele adciona esse card random a mao. que é um arrayList
    //REFATORAÇÃO: REMOVI A CHAMADA AO RANDON AQUI E CHAMEI O METODO COMPRARCARD CRIADO NO BARALHO
    public void comprarCard(){
        Card  card = baralho.comprarCard();

        if (card != null){
            mao.add(card);
            System.out.println(nome + " comprou a carta: " + card.getName());
        }

    }

    //func. mostrar mão. imprime a quem pertence a mao
    // em seguida o loop for itera sobre cada card em ":" mao (que é um array)
    //chamando o metodo mostrarcard para imprimir a mão.
    public void mostrarMao(){
        System.out.println("Mão de " + nome + ": " );


        // REFATORAÇÃO: ALTEREI PARA UM FOR DIFERENTE, POIS PRECISAVA ACESSAR O INDICE E ALÉM DE VER TODAS AS CARTAS EM LISTA VEJO OS NOMES E INDICE.
        for (int i = 0; i < mao.size(); i++){

            Card card = mao.get(i);
            //mao.get(i).mostrarCard();
            System.out.println("  [" + i + "]  "+ card.getName());
        }


    }

    // implementando o metodo de remoção de carta da mão, aqui encontrei um erro de indice
    //criei o if para validar se existe indice valido para ser acessado.
    public void JogarCard(int i){

        if ( i >= 0 && i < mao.size()){
            Card card = mao.remove(i); // Sendo true o card será removido da mão atraves do remove.
            System.out.println(nome + " jogou a carta: " + card.getName());
        } else {
            System.out.println("indice invalido" + nome + "tem apenas" + mao.size() + "cartas na mão.");
        }

    }


    //get e set básico padron
    public String getName() { return nome; }
    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }
    public Baralho getBaralho() { return baralho; }

}
