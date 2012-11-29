package edu.KurtP.Simpletron;

/**
 * @author Kurt P
 * @version 0.0.11282012
 */
public class MainMemory {
    private static int[] memory;

    /**
     * @return the memory
     */
    protected static int[] getMemory() {
        return memory;
    }

    /**
     * @param aMemory the memory to set
     */
    protected static void setMemory(int[] aMemory) {
        memory = aMemory;
    }

    
}
