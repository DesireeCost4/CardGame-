package game;

import cards.Card;
import java.util.ArrayList;
import java.util.List;

public class Campo {

    //Criando uma lista para inserir cartas jogadas, agora sempre que penso no ato de armazenar coisas do mesmo tipo me vem List ou array a mente.
    private List<Card> cartasNoCampo;

    //declarando o construtor, Passando cartasNoCampo como objeto de Card.
    public Campo() {
        this.cartasNoCampo = new ArrayList<>();
    }


    public void adcionarCard(Card card) {
        cartasNoCampo.add(card);
        System.out.println(card.getName() + " entrou no campo!");
    }

    public void RemoverCard(Card card){
        cartasNoCampo.remove(card);
    }

    public void mostrarCampo() {
        System.out.println("Cartas no campo:");
        for (int i = 0; i < cartasNoCampo.size(); i++) {
            System.out.println("[" + i + "] " + cartasNoCampo.get(i).getName());
        }
    }

    public List<Card> getCartasNoCampo() {
        return cartasNoCampo;
    }

}


