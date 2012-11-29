package edu.KurtP.Simpletron;

/**
 * @author Kurt P
 * @version 0.0.11272012
 */
public class SimpletronInstructionRegulatiors {
    private static int instructionCounter = 0;
    private static int instructionRegister = 0;


    protected static void incrementInstructionCounter() {
        instructionCounter++;
    }
    /**
     * @return the instructionCounter
     */
    protected static int getInstructionCounter() {
        return instructionCounter;
    }

    /**
     * @param aInstructionCounter the instructionCounter to set
     */
    protected static void setInstructionCounter(int aInstructionCounter) {
        instructionCounter = aInstructionCounter;
    }

    /**
     * @return the instructionRegister
     */
    protected static int getInstructionRegister() {
        return instructionRegister;
    }

    /**
     * @param aInstructionRegister the instructionRegister to set
     */
    protected static void setInstructionRegister(int aInstructionRegister) {
        instructionRegister = aInstructionRegister;
    }
}