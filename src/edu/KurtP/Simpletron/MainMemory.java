package edu.KurtP.Simpletron;

/**
 * @author Kurt P
 * @version 0.3.12012012
 */
public class MainMemory {

    protected static int[] memory = new int[100];
    protected static int memoryPointer = 0;

    /**
     * Outputs the values found in the
     * <code>memory</code>
     *
     * @return void
     */
    protected static void memoryDump() {
        int tens, ones;

        System.out.printf("%s:\t%04d\n", "Accumlator", SimpletronAccumlator.acculator);

        System.out.printf("\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\n", 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        for (tens = 0; tens < 100; tens += 10) {
            System.out.printf("%02d", tens / 10);
            for (ones = 0; ones < 10; ones++) {
                System.out.printf("\t%+05d", memory[tens + ones]);
            }
            System.out.println();
        }
    }
}
