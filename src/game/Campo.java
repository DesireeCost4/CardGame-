package game;

import cards.Card;
import cards.Criatura;
import jogador.Jogador;

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

        if (cartasNoCampo.contains(card)) {
            cartasNoCampo.remove(card);
        } else {
            System.out.println(card.getName() + " nao encontrado!");
        }

    }

    //remove por index
    public void removerCarta(int posicao) {
        if (posicao >= 0 && posicao < cartasNoCampo.size()) {
            Card card = cartasNoCampo.remove(posicao);
            System.out.println(card.getName() + " foi removida do campo!");
        } else {
            System.out.println("Posição inválida.");
        }
    }

    public void mostrarCampo() {
        System.out.println("Cartas no campo:");

        for (int i = 0; i < cartasNoCampo.size(); i++) {
            Card card = cartasNoCampo.get(i);
            System.out.print("[" + i + "] " + card.getName());

            if (card instanceof Criatura) {
                Criatura criatura = (Criatura) card;  // variável diferente
                System.out.print(" (ATK: " + criatura.getAtk() + " / DEF: " + criatura.getDef() + ")");
            }

            System.out.println();
        }
    }


    public List<Card> getCartasNoCampo() {
        return cartasNoCampo;
    }


    //Removendo todos os métodos de combate do campo e levando para Classe batalha.




}


