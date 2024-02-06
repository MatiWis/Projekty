package grarpg.main;

public class Gracz extends Postac{
    //integery do przechowania numerow awansow i umiejetnosci przy roznych sciezkach rozgrywki
    public int numAtkUpgrades, numDefUpgrades;

    int gold, restsLeft, pots;


    //tablice do przechowania nazw umiejetnosci
    public String[] atkUpgrades = {"Sila", "Moc", "Magia", "Boska sila"};
    public String[] defUpgrades = {"Twarde kosci", "Skora ze skaly", "Niebywaly pancerz", "Swieta ochrona"};

    //konstruktor gracza
    public Gracz(String name) {
        //konstruktor superklasy
        super(name, 100, 0);
        //ustawienie numerow na 0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;

        this.gold = 5;
        this.restsLeft = 1;
        this.pots = 0;
        //pozwol graczowi wybrac cechy przy tworzeniu nowej postaci
        wybierzUmiejetnosc();

    }

    //metody dla konkretnych postaci
    @Override
    public int atak(){
        return (int) (Math.random()*(xp/4 + numAtkUpgrades*3 + 3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades + 1);
    }

    @Override
    public int obrona(){
        return (int) (Math.random()*(xp/4 + numDefUpgrades*3 + 3) + xp/10 + numDefUpgrades*2 + numAtkUpgrades + 1);
    }

    //pozwolenie dla gracza na wybranie sciezki rozgrywki
    public void wybierzUmiejetnosc(){
        LogikaGry.clearConsole();
        LogikaGry.printHeading("Wybierz umiejetnosc:");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);
        //wybor gracza:
        int input = LogikaGry.readInt("-> ", 2);
        LogikaGry.clearConsole();

        if(input == 1) {
            LogikaGry.printHeading("Wybrales umiejetnosc " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        }else{
            LogikaGry.printHeading("Wybrales umiejetnosc " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        LogikaGry.anythingToContinue();
    }


}
































