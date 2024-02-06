package grarpg.main;

public abstract class Postac {

    //variable, atrybuty wszystkich postaci
    public String imie;
    public int maxHp, hp, xp;

    //konstruktor postaci
    public Postac(String imie, int maxHp, int xp){
        this.imie = imie;
        this.maxHp = maxHp;
        this.xp = xp;
        this.hp = maxHp;
    }

    //metody wszystkich postaci
    public abstract int atak();
    public abstract int obrona();
}
