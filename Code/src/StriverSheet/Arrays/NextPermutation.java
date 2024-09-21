package StriverSheet.Arrays;

import java.util.Arrays;

//https://leetcode.com/problems/next-permutation
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation q = new NextPermutation();
        int[] nums = {1,2,3};
        q.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void swap(int[] nums, int k, int l) {
        int temp = nums[k];
        nums[k] = nums[l];
        nums[l] = temp;
    }
    public void reverse(int[] nums, int i, int j) {
        for(int k = 0; k <= ((i+j)/2)-i; k++) {
            swap(nums, i+k, j-k);
        }
    }
    public void nextPermutation(int[] nums) {
        int k = -1;
        for(int i = 0; i < nums.length-1; i++) {
            if (nums[i] < nums[i+1]) {
                k = i;
            }
        }
        if (k == -1) {
            reverse(nums, 0, nums.length-1);
        }
        int l = k+1;
        for(int i = k+1; i < nums.length; i++) {
            if (nums[i] > nums[k]) {
                l = i;
            }
        }
//        System.out.println(k + " " + l);
        swap(nums, k, l);
//        System.out.println(Arrays.toString(nums));
        reverse(nums, k+1, nums.length-1);

    }
}
