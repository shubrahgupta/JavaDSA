package DSA.miscellaneous;
import java.util.BitSet;


public class BitSetExample {
    public static void main(String[] args) {
        // Create a new BitSet
        BitSet bitSet = new BitSet();

        // Set the bit at index 5
        int index = 5;
        bitSet.set(index);
        System.out.println("After setting index " + index + ": " + bitSet);

        // Clear the bit at index 5
        bitSet.clear(index);
        System.out.println("After clearing index " + index + ": " + bitSet);

        // Check the bit at index 5
        boolean isSet = bitSet.get(index);
        System.out.println("Is the bit at index " + index + " set? " + isSet);

        // Flip the bit at index 5
        bitSet.flip(index);
        System.out.println("After flipping index " + index + ": " + bitSet);
    }

}


