package grarpg.main;

public class Wrog extends Postac{


    int graczXp;


    public Wrog(String name, int graczXp){
        super(name, (int) (Math.random()*graczXp + graczXp/3 + 5), (int) (Math.random()*(graczXp/4 + 2) + 1));
        this.graczXp = graczXp;

    }

    @Override
    public int atak() {
        return (int) (Math.random()*(graczXp/4 + 1) + xp/4 + 3);
    }

    @Override
    public int obrona() {
        return (int) (Math.random()* (graczXp/4 +1) + xp/4 + 3);
    }
}
