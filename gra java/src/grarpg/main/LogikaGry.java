package grarpg.main;
import java.util.Scanner;


public class LogikaGry {
    static Scanner scanner = new Scanner(System.in);

    static Gracz gracz;

    public static boolean isRunning;

    //random encounter
    public static String[] akcje = {"Walka", "Walka", "Walka", "Odpoczynek", "Odpoczynek"};

    public static String[] przeciwnicy = {"Ogre", "Ogre", "Goblin", "Goblin", "Elemental"};

    public static int miejsce = 0, act = 1;
    public static String[] miejsca = {"Gory", "Rowniny", "Morze", "Zamek"};

    //inputy
    public static int readInt(String prompt, int wyboryGracza){
        int input;

        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            }catch(Exception e){
                input = -1;
                System.out.println("Wprowadz integer");
            }
        }while(input < 1 || input > wyboryGracza);
        return input;
    }
    //niby czyszczenie konsoli
    public static void clearConsole(){
        for(int i = 0; i < 100; i++)
            System.out.println();
    }

    //separator o dlugosci n
    public static void printSeparator(int n) {
        for(int i = 0; i < n; i++)
            System.out.println("-");
        System.out.println();
    }
    //print naglowek
    public static void printHeading(String title){
        printSeparator(10);
        System.out.println(title);
        printSeparator(10);
    }
    //kliknij dowolny przycisk by kontynuowac
    public static void anythingToContinue(){
        System.out.println("\nWpisz cokolwiek zeby kontynuowac");
        scanner.next();

    }
    //metoda zeby rozpoczac gre
    public static void startGry() {
        boolean imieSet = false;
        String imie;
        //print ekran glowny
        clearConsole();
        printSeparator(10);
        printSeparator(10);
        System.out.println("Przygody z mrocznej krainy");
        printSeparator(10);
        printSeparator(10);
        anythingToContinue();

        //pobieranie imienia gracza
        do {
            clearConsole();
            printHeading("Jak sie nazywasz?");
            imie = scanner.next();
            //pytanie czy chce poprawic wybor
            clearConsole();
            printHeading("Twoje imie to: " + imie + ".\nCzy to prawda?");
            System.out.println("(1) Tak!");
            System.out.println("(2) Nie, chce zmienic moje imie");
            int input = readInt("-> ", 2);
            if (input == 1)
                imieSet = true;
        } while(!imieSet);

        //print Historia intro
        Historia.printIntro();

        //tworzenie nowego gracza
        gracz = new Gracz(imie);

        //print first Historia act intro
        Historia.printIntro();

        isRunning = true;

        gameLoop();
    }
    //metoda zmienia wartosci w grze bazujac na xp gracza
    public static void checkAct(){
        if(gracz.xp >=5 && act == 1){
            //inkrementacja aktu i miejsca
            act = 2;
            miejsce = 1;
            //Historia
            Historia.printFirstActOutro();
            //lvl up gracza
            gracz.wybierzUmiejetnosc();
            //lvl up gracza
            Historia.printSecondActIntro();
            //przydziel nowe wartosci przeciwnikom
            przeciwnicy[0] = "Czarnoksieznik";
            przeciwnicy[1] = "Goblin";
            przeciwnicy[2] = "Sfora wilkow";
            przeciwnicy[3] = "Pomocnik imperatora";
            przeciwnicy[4] = "Bandyta";
            //przypisz nowe wartosci pojedynkom
            akcje[0] = "Walka";
            akcje[1] = "Walka";
            akcje[2] = "Walka";
            akcje[3] = "Odpoczynek";
            akcje[4] = "Sklep";
        }else if (gracz.xp >= 50 && act == 2) {
            //inkrementacja
            act = 3;
            miejsce = 2;
            Historia.printSecondActOutro();
            //lvl up
            gracz.wybierzUmiejetnosc();
            //Historia
            Historia.printThirdActIntro();
            //przypisz nowe wartosci przeciwnikom
            przeciwnicy[0] = "Czarnoksieznik";
            przeciwnicy[1] = "Goblin";
            przeciwnicy[2] = "Sfora wilkow";
            przeciwnicy[3] = "Pomocnik imperatora";
            przeciwnicy[4] = "Bandyta";
            //przypisz nowe wartosci pojedynkom
            akcje[0] = "Walka";
            akcje[1] = "Walka";
            akcje[2] = "Walka";
            akcje[3] = "Walka";
            akcje[4] = "Sklep";
            //wylecz gracza
            gracz.hp = gracz.maxHp;

        }else if(gracz.xp >= 100 && act == 3){

            act = 4;
            miejsce = 3;
            //Historia
            Historia.printThirdActOutro();
            //lvl up
            gracz.wybierzUmiejetnosc();
            Historia.printFourthActIntro();
            gracz.hp = gracz.maxHp;
            //calling the final battle
            //finalBattle();
        }




    }


    public static void randomEncounter() {
        int encounter = (int) (Math.random() * akcje.length);
        if (akcje[encounter].equals("Walka")) {
            randomBattle();
        }else if(akcje[encounter].equals("Odpoczynek")) {
            takeRest();
        }else{
            shop();
        }



    }

    //metoda wznowienia gry
    public static void  continueJourney(){
        //sprawdzenie czy powinno byc przejscie do nastepnej lokacji
        checkAct();
        //sprawdzenie czy gra nie jest w ostatniej lokacji
        if(act !=4)
            randomEncounter();


    }
    public static void characterInfo(){
        clearConsole();
        printHeading("Info o Bohaterze");
        System.out.println(gracz.imie + "\tHP: " + gracz.hp + "/" + gracz.maxHp);
        printSeparator(10);
        System.out.println("XP: " + gracz.xp + "\tGold: " + gracz.gold);
        printSeparator(10);
        System.out.println("Liczba potionow: "+ gracz.pots);
        printSeparator(10);


        if(gracz.numAtkUpgrades > 0){
            System.out.println("Cecha ofensywna: " + gracz.atkUpgrades[gracz.numAtkUpgrades - 1]);
            printSeparator(10);
        }
        if (gracz.numDefUpgrades > 0) {
            System.out.println("Cecha defensywna: "+ gracz.defUpgrades[gracz.numDefUpgrades - 1]);
        }

        anythingToContinue();
    }

    public static void shop(){
        clearConsole();
        printHeading("Spotykasz tajemniczego nieznajomego.\nDostajesz propozycje:");
        int price = (int) (Math.random()* (10 + gracz.pots*3) + 10 + gracz.pots);
        System.out.println("- Magiczny potion: " + price + " gold.");
        printSeparator(10);
        System.out.println("Chcesz go kupic?\n(1) Tak!\n(2) Nie, dzięki.");
        int input = readInt("-> ", 2);
        if (input == 1){
            clearConsole();
            if(gracz.gold >= price){
                printHeading("Kupiles magiczny potion za " + price + "gold.");
                gracz.pots++;
                gracz.gold -= price;
            }else
                printHeading("Nie masz wystarczajaco pieniedzy zeby dokonac zakupu...");
            anythingToContinue();
        }
    }

    public static void takeRest(){
        clearConsole();
        if(gracz.restsLeft >= 1){
            printHeading("Chcesz odpoczac? (" + gracz.restsLeft + ": taka liczba odpoczynkow pozostala)");
            System.out.println("(1) Tak\n(2) Nie, nie teraz.");
            int input = readInt("=> ", 2);
            if(input == 1){
                clearConsole();
                if(gracz.hp < gracz.maxHp) {
                    int hpRestored = (int) (Math.random() * (gracz.xp + 1) + 10);
                    gracz.hp += hpRestored;
                    if (gracz.hp > gracz.maxHp)
                        gracz.hp = gracz.maxHp;
                    System.out.println("Odpoczales i uleczyles" + hpRestored + " pkt zdrowia.");
                    System.out.println("Masz teraz " + gracz.hp + "/" + gracz.maxHp + " hp.");
                    gracz.restsLeft--;
                }
            }else
                System.out.println("Masz pelny poziom zdrowia. Nie potrzebujesz odpoczynku!");
            anythingToContinue();
        }
    }

    //randomowa walka
    public static void randomBattle() {
        clearConsole();
        printHeading("Spotkales przeciwnika. Walcz!");
        anythingToContinue();

        battle(new Wrog(przeciwnicy[(int) (Math.random() * przeciwnicy.length)], gracz.xp));
    }
    public static void battle(Wrog wrog){
        while (true){
            clearConsole();
            printHeading(wrog.imie + "\nHP: " + wrog.hp+ "/" + wrog.maxHp);
            printHeading(gracz.imie + "\nHP " + gracz.hp + "/" + gracz.maxHp);
            System.out.println("Wybierz akcje:");
            printSeparator(10);
            System.out.println("(1) Walcz\n(2) Uzyj potiona\n(3) Uciekaj");
            int input = readInt("->", 3);
            if(input == 1) {
                int dmg = gracz.atak() - wrog.obrona();
                int dmgTook = wrog.atak() - gracz.obrona();
                if (dmgTook < 0) {
                    dmg -= dmgTook / 2;
                    dmgTook = 0;
                }
                if (dmg < 0)
                    dmg = 0;
                gracz.hp -= dmgTook;
                wrog.hp -= dmg;

                clearConsole();
                printHeading("Walcz");
                System.out.println("Zadales " + dmg + " obrazen dla " + wrog.imie + ".");
                printSeparator(15);
                System.out.println(wrog.imie + " zadal Tobie " + dmgTook + " obrazen");
                anythingToContinue();

                if(gracz.hp <=0){
                    graczDied();//metoda na koniec gry
                    break;
                } else if (wrog.hp <= 0) {
                    clearConsole();
                    printHeading("Pokonales " + wrog.imie + "!");
                    gracz.xp += wrog.xp;
                    System.out.println("Zdobyles "+ wrog.xp + " XP!");
                    //random pojawia sie
                    boolean addRest = (Math.random()*5 +1 <= 2.25);
                    int goldEarned = (int) (Math.random()*wrog.xp);
                    if(addRest){
                        gracz.restsLeft++;
                        System.out.println("Zdobyles szanse na dodatkowy odpoczynek!");
                    }
                    if(goldEarned > 0){
                        gracz.gold += goldEarned;
                        System.out.println("Zebrales " + goldEarned + " golda ze zwlok tego przeciwnika: "  + wrog.imie );
                    }
                    anythingToContinue();
                    break;
                }
            }else if(input == 2){
                //usepotion
                clearConsole();
                if(gracz.pots > 0 && gracz.hp < gracz.maxHp){
                    printHeading("Chcesz wypic potiona? (" + gracz.pots + " pozostalo).");
                    System.out.println("(1) Tak\n(2) Dzieki, moze pozniej");
                    input = readInt(" ->", 2);
                    if(input == 1){
                        gracz.hp = gracz.maxHp;
                        clearConsole();
                        printHeading("Wypiles potiona. Twoje zycie wrocilo do" + gracz.maxHp);
                        anythingToContinue();
                    }
                }
            }else{
                clearConsole();
                if(act !=4){
                    if (Math.random()* 10 + 1 <= 3.5) {
                        printHeading("Uciekles od tego przeciwnika: " + wrog.imie + "!");
                        anythingToContinue();
                        break;
                    }else {
                        printHeading("Nie udalo Ci sie uciec.");
                        int dmgTook = wrog.atak();
                        System.out.println("Przy probie ucieczki otrzymles 0 " + dmgTook + "obrazen!");
                        anythingToContinue();
                        if (gracz.hp <= 0)
                            graczDied();
                    }
                }else {
                    printHeading("NIE OPUSCISZ PIEKLA!!!");
                    anythingToContinue();
                }

            }
        }
    }



    //print main menu
    public static void printMenu(){
        clearConsole();
        printHeading(miejsca[miejsce]);
        System.out.println("Wybierz akcje");
        printSeparator(10);
        System.out.println("(1) Kontynuuj podroz");
        System.out.println("(2) Info o Bohaterze");
        System.out.println("(3) Wyjscie z gry");
    }

    public static void finalBattle(){
        battle(new Wrog("OSTATECZNY PRZECIWNIK", 300));
        Historia.printEnd();
        isRunning = false;

    }

    public static void graczDied(){
        clearConsole();
        printHeading("Polegles...");
        printHeading("Zdobyles " + gracz.xp + "XP w trakcie swojej podrozy. Powodzenia nastepnym razem!");
        System.out.println("Dziekujemy za rozgrywke");
        isRunning= false;
    }

    //main petla gry
    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt(" -> ", 3);
            if(input == 1)
                continueJourney();
            else if(input == 2)
                characterInfo();
            else
                isRunning = false;
        }
    }
}



























































































