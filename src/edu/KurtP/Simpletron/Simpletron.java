package edu.KurtP.Simpletron;

import java.util.Scanner;

/**
 * @author kurtprudhomme
 * @version 0.2.1.12012012
 */
public class Simpletron {

    /*
     * I'm keeping these variables, so that later when this assignment is done 
     * I can come back, remove the unneeded classes and still have a working 
     * project.
     */
//    private int[] memory = new int[100];
//    private int accumulator;
    private int instructionCounter;
    private int instructionRegister;
    private int operationCode;
    private int operand;
    private boolean run = true;

    /**
     * The
     * <code>run</code> method will start Simpletron, display the welcome
     * message and then go strait into SML execution.
     *
     * @return void
     */
    public void run() {
        welcomeMessage();
        execute();
    }

    /**
     * The welcome message when Simpletron is first started.
     *
     * @return void
     */
    private void welcomeMessage() {
        System.out.println("***            Welcome to Simpletron!           ***");
        System.out.println("*** Please enter your program, one instruction  ***");
        System.out.println("*** (or data word) at a time. I will display    ***");
        System.out.println("*** the location number and a question mark (?) ***");
        System.out.println("*** You then type the word for that location.   ***");
        System.out.println("*** Type -99999 to stop entering your program.  ***");
    }

    /*
     * Same with the variables uptop, I'm not going to remove this one ether. 
     * I just want to have to uncomment it, and the project will still work.
     */
//    private void execute() {
//        Scanner codeInputter = new Scanner(System.in);
//        int instructionInput = 0;
//        int memoryPointer = 0;
//
//        do {
//            //Output the code input prompt
//            System.out.printf("%02d ? ", memoryPointer);
//            //Take the user input and assign it to the input var.
//            instructionInput = codeInputter.nextInt();
//            //place the input into the correct memory location
//            memory[memoryPointer] = instructionInput;
//            //Increment the pointer by one
//            memoryPointer++;
//        }
//        while (instructionInput != -99999);
//
//        System.out.printf("\n%s\n%s\n\n", "***  Program loading complete ***",
//                "*** Program excution begins ***");
//
//        while (run) {
//            loadCode();
//            operations(operationCode, operand);
//        }
//
//        System.exit(0);
//    }
    
    /**
     * The execute method will ask for
     * <code>SML</code> and execute it word by word.
     *
     * @return void
     */
    private void execute() {
        Scanner codeInput = new Scanner(System.in);
        int instructionInput;
        //int memoryPointer = 0;

        do {
            System.out.printf("%02d ? ", MainMemory.memoryPointer);
            instructionInput = codeInput.nextInt();
            MainMemory.memory[MainMemory.memoryPointer] = instructionInput;
            MainMemory.memoryPointer++;
        }
        while (instructionInput != -99999);

        System.out.printf("\n%s\n%s\n\n", "***  Program loading complete ***",
                "*** Program excution begins ***");

        while (run) {
            loadCode();
            operations(operationCode, operand);
        }

        System.exit(0);
    }

    /**
     * Using the
     * <code>instructionRegister</code> var,
     * <code>loadCode()</code> will determine what operation will be executed
     * and which memory location it will need to access to complete that
     * operation.
     *
     * @return void
     */
    private void loadCode() {
//        instructionRegister = memory[instructionCounter];
        instructionRegister = MainMemory.memory[instructionCounter];

        operationCode = instructionRegister / 100;
        operand = instructionRegister % 100;
    }

    /**
     * Once the operation and operand are determined by
     * <code>loadCode()</code> they are executed.
     *
     * @param operationCode
     * @param operand
     * @return void
     */
    private void operations(int operationCode, int operand) {
        boolean branching = false;

        switch (operationCode) { //Start switch

            //Operations for reading input from the user
            case SimpletronOperationCodes.READ:
                Scanner read = new Scanner(System.in);
                System.out.print("Enter a number: ");
                int number = read.nextInt();
//                memory[operand] = number;
                MainMemory.memory[operand] = number;
                break;

            //Operations for outputting to the user
            case SimpletronOperationCodes.WRITE:
//                System.out.println(memory[operand]);
                System.out.println(MainMemory.memory[operand]);
                break;

            //Load the value found in memory into the accumulator
            case SimpletronOperationCodes.LOAD:
//                accumulator = memory[operand];
                SimpletronAccumlator.acculator = MainMemory.memory[operand];
                break;

            //Put the value in the accumlator in to memroy
            case SimpletronOperationCodes.STORE:
//                memory[operand] = accumulator;
                MainMemory.memory[operand] = SimpletronAccumlator.acculator;
                break;

            //Add the value in the accumulator and a value from memroy
            case SimpletronOperationCodes.ADD:
//                accumulator += memory[operand];
                SimpletronAccumlator.acculator += MainMemory.memory[operand];
                break;

            //Subtract the value in the accumulator and a value in memory
            case SimpletronOperationCodes.SUBTRACT:
//                accumulator -= memory[operand];
                SimpletronAccumlator.acculator -= MainMemory.memory[operand];
                break;

            //Divide the value in the accumulator by a value in memory
            case SimpletronOperationCodes.DIVIDE:
                //Can't divide by zero.
//                if (memory[operand] == 0) {
                if (MainMemory.memory[operand] == 0) {
                    System.out.printf("\n%s\n%s\n", "*** CANNOT DIVIDE BY ZERO ***", "*** EXITING NOW ***");
                    System.exit(-1);
                }
                else {
//                    accumulator /= memory[operand];
                    SimpletronAccumlator.acculator /= MainMemory.memory[operand];
                    break;
                }

            //Mulitply the value in the accumulator by a value in memory
            case SimpletronOperationCodes.MULITPLY:
//                accumulator *= memory[operand];
                SimpletronAccumlator.acculator *= MainMemory.memory[operand];
                break;

            //Branc to a specific memory location
            case SimpletronOperationCodes.BRANCH:
                instructionCounter = operand;
                branching = true;
                break;

            //Branch to a memory location if the accumulator is less than zero
            case SimpletronOperationCodes.BRANCHNEG:
//                if (accumulator < 0) {
                if (SimpletronAccumlator.acculator < 0) {
                    instructionCounter = operand;
                    branching = true;
                }
                break;

            //Branch to a memroy location if the accumulator is zero
            case SimpletronOperationCodes.BRANCHZERO:
//                if (accumulator == 0) {
                if (SimpletronAccumlator.acculator == 0) {
                    instructionCounter = operand;
                    branching = true;
                }
                break;

            //Finsh processing
            case SimpletronOperationCodes.HALT:
                System.out.println("Processing complete...");
                run = false;
                MainMemory.memoryDump();
                break;

        } //End switch

        /*
         * While I was testing, I noticed that if I neede to branch to a lower
         * memory location, the instruction counter would will increment. To
         * solvie this issue I added the boolean 'branch' var. Only when the
         * Simpletron is not branching, will the counter increment.
         */
        if (!branching) {
            instructionCounter++;
        }
    } //End of operations method
    
//    /**
//     * Outputs the values found in the
//     * <code>memory</code>
//     *
//     * @return void
//     */
//    private static void memoryDump() {
//        int tens, ones;
//        
//        System.out.printf("%s\t%04d\n", "Accumlator", acculator);
//        
//        System.out.printf("\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\n", 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
//        
//        for (tens = 0; tens < 100; tens += 10) {
//            System.out.printf("%02d\t", tens);
//            for (ones = 0; ones < 10; ones++) {
//                System.out.printf("%04d\t", memory[tens + ones]);
//            }
//            System.out.println();
//        }
//    }
}
