package grarpg.main;

public class Historia {

    public static void printIntro() {
        LogikaGry.clearConsole();
        LogikaGry.printSeparator(30);
        System.out.println("HISTORIA");
        LogikaGry.printSeparator(30);
        System.out.println("Jestes graczem ktory przybyl do tej krainy nie wiedzac co go czeka... Sprobuj przezyc...");
        LogikaGry.anythingToContinue();
    }

    public static void printFirstActIntro() {
        LogikaGry.clearConsole();
        LogikaGry.printSeparator(30);
        System.out.println("AKT I - INTRO");
        LogikaGry.printSeparator(30);
        System.out.println("POCZATKI...");
        LogikaGry.anythingToContinue();
    }

    public static void printFirstActOutro() {
        LogikaGry.clearConsole();
        LogikaGry.printSeparator(30);
        System.out.println("AKT I - OUTRO");
        LogikaGry.printSeparator(30);
        System.out.println("UDALO CI SIE - PRZEZYLES");
        LogikaGry.anythingToContinue();

    }

    public static void printSecondActIntro() {
        LogikaGry.clearConsole();
        LogikaGry.printSeparator(30);
        System.out.println("AKT II - INTRO");
        LogikaGry.printSeparator(30);
        System.out.println("KONTYNUACJA PODROZY, TERAZ NIE BEDZIE TAK LATWO");
        LogikaGry.anythingToContinue();
    }

    public static void printSecondActOutro() {
        LogikaGry.clearConsole();
        LogikaGry.printSeparator(30);
        System.out.println("AKT II - OUTRO");
        LogikaGry.printSeparator(30);
        System.out.println("UDALO CI SIE... WCIAZ JESTES PRZY ZYCIU");
        LogikaGry.anythingToContinue();
    }

    public static void printThirdActIntro() {
        LogikaGry.clearConsole();
        LogikaGry.printSeparator(30);
        System.out.println("AKT III - INTRO");
        LogikaGry.printSeparator(30);
        System.out.println("POZIOM TRZECI. ZOBACZMY JAK TERAZ DASZ SOBIE RADE");
        LogikaGry.anythingToContinue();
    }

    public static void printThirdActOutro() {
        LogikaGry.clearConsole();
        LogikaGry.printSeparator(30);
        System.out.println("AKT III - OUTRO");
        LogikaGry.printSeparator(30);
        System.out.println("ZNOW TO ZROBILES...");
        LogikaGry.anythingToContinue();
    }

    public static void printFourthActIntro() {
        LogikaGry.clearConsole();
        LogikaGry.printSeparator(30);
        System.out.println("AKT IV - INTRO");
        LogikaGry.printSeparator(30);
        System.out.println("POZIOM CZWARTY. KONIEC ZARTOW");
        LogikaGry.anythingToContinue();
    }

    public static void printFourthActOutro() {
        LogikaGry.clearConsole();
        LogikaGry.printSeparator(30);
        System.out.println("AKT IV - OUTRO");
        LogikaGry.printSeparator(30);
        System.out.println("COS NIESLYCHANEGO... POWODZENIA...");
        LogikaGry.anythingToContinue();
    }

    public static void printFifthActIntro() {
        LogikaGry.clearConsole();
        LogikaGry.printSeparator(30);
        System.out.println("AKT V - INTRO");
        LogikaGry.printSeparator(30);
        System.out.println("TERAZ ZOBACZYMY NA CO NAPRAWDE CIE STAC!");
        LogikaGry.anythingToContinue();
    }

    public static void printFifthActOutro() {
        LogikaGry.clearConsole();
        LogikaGry.printSeparator(30);
        System.out.println("AKT V - OUTRO");
        LogikaGry.printSeparator(30);
        System.out.println("JAK... JAK TO W OGOLE MOZLIWE? WYGRALES PIATY POZIOM");
        LogikaGry.anythingToContinue();
    }

    public static void printEnd() {
        LogikaGry.clearConsole();
        LogikaGry.printSeparator(30);
        System.out.println("TO JUZ KONIEC");
        LogikaGry.printSeparator(30);
        System.out.println("ZWYCIEZYLES. CHCESZ ZAGRAC PONOWNIE?");
        LogikaGry.anythingToContinue();

    }
}