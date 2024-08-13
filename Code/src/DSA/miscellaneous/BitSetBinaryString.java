package DSA.miscellaneous;

import java.util.BitSet;

public class BitSetBinaryString {
    public static void main(String[] args) {
        // Create a BitSet
        BitSet bitSet = new BitSet();

        // Set some bits for demonstration
        bitSet.set(7);
//        bitSet.set(2);
//        bitSet.set(4);
//        bitSet.set(6);

        // Define the size of the bitset
        int size = 8; // You can adjust this as needed

        // Convert the BitSet to a binary string
        StringBuilder binaryString = new StringBuilder();

        for (int i = 0; i < size; i++) {
            // Check if the bit at index i is set (1) or not (0)
            if (bitSet.get(i)) {
                binaryString.append('1');
            } else {
                binaryString.append('0');
            }
        }

        // Print the binary string representation of the BitSet
        System.out.println("BitSet in 1/0 form: " + binaryString.toString());
    }
}
