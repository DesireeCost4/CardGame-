package model.cards;
//Utilizando abstração de classe para aplicar herança.

public abstract class Card {

    private String name;
    private String description;
    private int custoMana;

//O construtor irá ajudar na criação do obj lá no main

    //Definindo construtor:
    Card(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //Aplicando encapsulanemento atraves dos modificadores e acessando atraves de metodos.
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //Esse metodo abstrato é definido como um contrato onde irei implementar na classe que extender de model.cards.Card.
    public abstract void mostrarCard();

    public int getCustoMana() {
        return custoMana;
    }



}


