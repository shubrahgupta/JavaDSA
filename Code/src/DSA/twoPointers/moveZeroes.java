package DSA.twoPointers;

import java.util.Arrays;

public class moveZeroes {
    public static void main(String[] args) {
        int[] nums = {1,0};
        moveZeroes m = new moveZeroes();
        m.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;

    }
    public void moveZeroes(int[] nums) {
        int zp = 0; // Zero pointer
        int nzp = 0; // Non-zero pointer

        while (nzp < nums.length) {
            // Move zp to the next zero element
            while (zp < nums.length && nums[zp] != 0) {
                zp++;
            }
            // Move nzp to the next non-zero element
            while (nzp < nums.length && (nums[nzp] == 0 || nzp <= zp)) {
                nzp++;
            }

            // If both pointers are within bounds, swap the elements
            if (zp < nums.length && nzp < nums.length) {
                swap(nums, zp, nzp);
            }

            // If either pointer reaches the end, break out of the loop
            if (zp == nums.length || nzp == nums.length) {
                break;
            }
        }
    }
}
