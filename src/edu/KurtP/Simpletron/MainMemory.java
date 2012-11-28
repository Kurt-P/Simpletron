package edu.KurtP.Simpletron;

/**
 * @author Kurt P
 * @version 0.0.11282012
 */
public class MainMemory {
    private int[] memory;
    
    public MainMemory(int size) {
        memory = new int[size];
    }
    
    public int getMemory() {
        return memory.length;
    }
    
    public void addToMemory(int i, int location) {
        memory[location] = i;
    }
    
    public int readFromMemory(int location) {
        int i = memory[location];
        return i;
    }
}
