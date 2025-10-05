package baralho;

import cards.Criatura;
import cards.Magia;
import cards.Card;

import java.util.ArrayList;
import java.util.Random;

public class Baralho {

    //Criei dois arrays para cada tipo de carta
    private ArrayList<Criatura> criaturas = new ArrayList<Criatura>();
    private ArrayList<Magia> magias = new ArrayList<Magia>();


    public Baralho () {
        this.criaturas = new ArrayList<>();
        this.magias = new ArrayList<>();
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

}
