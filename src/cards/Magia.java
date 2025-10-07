package cards;

public class Magia  extends Card {

    private TipoMagia tipoMagia;

    private int atkBonus;
    private int defBonus;

    public Magia(String name, String description, int atkBonus, int defBonus, TipoMagia tipoMagia) {
        super(name, description);
        this.atkBonus = atkBonus;
        this.defBonus = defBonus;
        this.tipoMagia = tipoMagia;
    }


    public void aplicarMagia(Criatura alvo){

        if(tipoMagia == TipoMagia.ALIADO) {
            alvo.aplicarBonus(atkBonus, defBonus);
            System.out.println(getName() + " aplicou +" + atkBonus + " ATK e +" + defBonus + " DEF em " + alvo.getName());
        } else if (tipoMagia == TipoMagia.INIMIGO) {
            alvo.aplicarBonus(-atkBonus, -defBonus);
            System.out.println(getName() + " diminuiu -" + atkBonus + " ATK e -" + defBonus + " DEF de " + alvo.getName());
        } else {
            alvo.aplicarBonus(atkBonus, defBonus);
            System.out.println(getName() + " aplicou efeito em " + alvo.getName());
        }

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

    public int getAtkBonus() {
        return atkBonus;
    }

    public int getDefBonus() {
        return defBonus;
    }

    public TipoMagia getTipoMagia() {
        return tipoMagia;
    }
}
