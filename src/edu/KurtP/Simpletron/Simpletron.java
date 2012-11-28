/*
 * This is my first draft for the Simpletron program that I need to do for a 
 * class project.
 */
package edu.KurtP.Simpletron;

/**
 * @author kurtprudhomme
 * @version 0.0.11282012
 */
public class Simpletron {
    private int[] memory = new int[100];
    
    //Read and write operations
    private final int READ = 10;
    private final int WRITE = 11;
    
    //Load and store operations
    private final int LOAD = 20;
    private final int STORE = 21;
    
    //Arithemetic operations
    private final int ADD = 30;
    private final int SUBTRACT = 31;
    private final int DIVIDE = 32;
    private final int MULITPLY = 33;
    
    //acculaltor should be a class and main memroy should be a class
    
    //Transfer of controle operations
    private final int BRANCH = 40;
    private final int BRANCHING = 41;
    private final int BRANCHZERO = 42;
    private final int HALT = 43;
    
    public void welcomeMessage() {
        System.out.println("*** Welcome to Simpletron! ***");
        System.out.println("*** Please enter your program one instruction   ***");
        System.out.println("*** (or data word) at a time. I will display    ***");
        System.out.println("*** the location number and a question mark (?) ***");
        System.out.println("*** You then type the word for that location.   ***");
        System.out.println("*** Type -99999 to stop entering your program.  ***");
    }
}
