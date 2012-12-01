package edu.KurtP.Simpletron;

/**
 * @author Kurt P
 * @version 0.0.11292012
 */
public class MainMemory {
    protected static int[] memory = new int[100];
    protected static int memoryPointer = 0;

    protected static void memoryDump() {
        int tens, ones;
        
        System.out.printf("\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t\n", "0","1", "2", "3", "4", "5", "6", "7", "8", "9");
        
        for (tens = 0; tens < 100; tens += 10) {
            System.out.printf("%d\t", tens);
            for (ones = 0; ones < 10; ones++) {
                System.out.printf("%04d\t", memory[tens + ones]);
            }
            System.out.println();
        }
    }
}
