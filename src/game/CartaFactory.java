package game;

import cards.Criatura;
import cards.Magia;

public class CartaFactory {

    //esse componente funciona como o construtor básicamente. porém,
    // com ele posso criar uma "fabrica" de criaturas de forma dinamica, como fiz utilizando loop lá no main.

    public static Criatura criarCriatura(String nome, String descricao, int atk, int def) {
        return new Criatura(nome, descricao, atk, def);
    }

    public static Magia criarMagia(String nome, String descricao, int atk, int def) {
        return new Magia(nome, descricao, atk, def);
    }

}
