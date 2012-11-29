package edu.KurtP.Simpletron;

/**
 * @author Kurt P
 * @version 0.0.11282012
 */
public class MainMemory {
    private static int[] memory = new int[100];
    private static int memoryPointer = 0;
    
//    protected MainMemory() {
//        memory = new int[100];
//    }

    protected static void incrementMemoryPointer() {
        memoryPointer++;
    }
    
    /**
     * @return the memory
     */
    protected static int getMemoryFromLocation(int location) {
        return memory[location];
    }

    /**
     * @param aMemory the memory to set
     */
    protected static void setMemoryAtLocation(int location, int value) {
        memory[location] = value;
    }

    /**
     * @return the memoryPointer
     */
    protected static int getMemoryPointer() {
        return memoryPointer;
    }
    
    protected static int getMemorySize() {
        return memory.length;
    }
    
    protected static int[] getMemory() {
        return memory;
    }
}
