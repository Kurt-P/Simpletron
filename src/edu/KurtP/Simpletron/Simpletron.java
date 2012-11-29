/*
 * This is my first draft for the Simpletron program that I need to do for a
 * class project.
 */
package edu.KurtP.Simpletron;

import java.util.Scanner;
import edu.KurtP.Simpletron.SimpletronOperationCodes;
import edu.KurtP.Simpletron.SimpletronAccumlator;
import edu.KurtP.Simpletron.SimpletronInstructionRegulatiors;

/**
 * @author kurtprudhomme
 * @version 0.1.11282012
 */
public class Simpletron {

    private int[] memory = new int[100];
    private String string = "";

    private int instructionCounter, instructionRegister = 0;

    private int operationCode, operand;

    public void welcomeMessage() {
        System.out.println("***            Welcome to Simpletron!           ***");
        System.out.println("*** Please enter your program one instruction   ***");
        System.out.println("*** (or data word) at a time. I will display    ***");
        System.out.println("*** the location number and a question mark (?) ***");
        System.out.println("*** You then type the word for that location.   ***");
        System.out.println("*** Type -99999 to stop entering your program.  ***");
    }

    public void runSimpletron() {
        Scanner codeInputter = new Scanner(System.in);
        int instructionInput = 0;
        int memoryPointer = 0;

//        do {
//            System.out.printf("%02d ? ", SimpletronInstructionRegulatiors.getInstructionCounter());
//            instructionInput = scanner.nextInt();
//            memory[SimpletronInstructionRegulatiors.getInstructionCounter()] = instructionInput;
//            SimpletronInstructionRegulatiors.setInstructionRegister(memory[SimpletronInstructionRegulatiors.getInstructionCounter()]);
//            SimpletronInstructionRegulatiors.incrementInstructionCounter();
//        }
//        while (instructionInput != -99999);

        do {
            //Output the code input prompt
            System.out.printf("%02d ? ", SimpletronInstructionRegulatiors.getInstructionCounter());
            //Take the user input and assign it to the input var.
            instructionInput = codeInputter.nextInt();

            //place the input into the correct memory location
            memory[memoryPointer] = instructionInput;
            memoryPointer++;
        }
        while (instructionInput != -99999);

        for (int code : memory) {
            loadCode();
            operations(operationCode, operand);
        }
    }

    private void loadCode() {
//        operationCode = memory[SimpletronInstructionRegulatiors.getInstructionCounter()] / 100;
//        operand = memory[SimpletronInstructionRegulatiors.getInstructionCounter()] % 100;
        operationCode = memory[instructionCounter] / 100;
        operand = memory[instructionCounter] % 100;
    }

    private void operations(int operationCode, int operand) {

        switch(operationCode) { //Start switch

            //Operations for reading input from the user
            case SimpletronOperationCodes.READ :
                Scanner read = new Scanner(System.in);
                System.out.print("Enter a number: ");
                int number = read.nextInt();
                memory[operand] = number;
                break;

            //Operations for outputting to the user
            case SimpletronOperationCodes.WRITE :
                System.out.println(memory[operand]);
                break;
        } //End switch

//        SimpletronInstructionRegulatiors.incrementInstructionCounter();
        instructionCounter++;
    }
}
