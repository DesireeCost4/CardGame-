package game;

import cards.Criatura;
import cards.Magia;

public class CartaFactory {

    public static Criatura criarCriatura(String nome, String descricao, int atk, int def) {
        return new Criatura(nome, descricao, atk, def);
    }

    public static Magia criarMagia(String nome, String descricao, int atk, int def) {
        return new Magia(nome, descricao, atk, def);
    }

}
