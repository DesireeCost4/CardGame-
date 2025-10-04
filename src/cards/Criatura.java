package cards;

public class Criatura  extends Card {

    private int atk;
    private int def;

    public Criatura(String nome,String description  ,int atk, int def){
        super(nome,description);
        this.atk = atk;
        this.def = def;
    }

    public void aplicarBonus(int atkBonus, int defBonus){
        this.atk += atkBonus;
        this.def += defBonus;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

//devido o modificador da superclasse estar privado estou acessando atraves dos metodos.
    @Override
    public void mostrarCard() {
        System.out.println("===================================");
        System.out.println("       🦖 Criatura 🦖");
        System.out.println("Nome: " + getName());
        System.out.println("Descrição: " + getDescription());
        System.out.println("ATK: " + atk + " || DEF: " + def);
        System.out.println("===================================");
    }
}
