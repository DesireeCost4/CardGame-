package cards;

public class Magia  extends Card {


    private int atkBonus;
    private int defBonus;

    public Magia(String name, String description, int atkBonus, int defBonus) {
        super(name, description);
        this.atkBonus = atkBonus;
        this.defBonus = defBonus;
    }


    public void aplicarMagia(Criatura alvo){
        alvo.aplicarBonus(atkBonus, defBonus);
        System.out.println(getName() + " aplicou +" + atkBonus + " ATK e +" + defBonus + " DEF em " + alvo.getName());
    }

    @Override
    public void mostrarCard() {
        System.out.println("===================================");
        System.out.println("         🃏 Magia 🃏");
        System.out.println("Nome: " + getName());
        System.out.println("Descrição: " + getDescription());
        System.out.println("Bônus: ATK +" + atkBonus + " || DEF +" + defBonus);
        System.out.println("===================================");
    }
}
