package TestPackage;

import edu.KurtP.Simpletron.Simpletron;

public class SimpletronTest {

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String s : args) {
                if ("-h".equals(s) || "--help".equals(s)) {
                    helpMessage();
                    System.exit(0);
                }
            }
            System.out.println("Invalid options. Use \"-h\" or \"--help\" for help");
            System.exit(0);
        }
        else {
            run();
        }
    }

    public static void run() {
        Simpletron s = new Simpletron();

        s.welcomeMessage();
        s.runSimpletron();
    }

    public static void helpMessage() {
        System.out.println("Test help message");
    }
}