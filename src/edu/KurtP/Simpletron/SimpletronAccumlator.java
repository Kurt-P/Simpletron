package edu.KurtP.Simpletron;

/**
 * @author Kurt P
 * @version 0.0.11272012
 */
public class SimpletronAccumlator {
    private static int acculator = 0;

    protected static int getAccumlator() {
        return acculator;
    }

    protected static void setAcculator(int i) {
        acculator = i;
    }
}