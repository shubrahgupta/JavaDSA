package DSA.twoPointers;

import java.util.Arrays;

public class maxKsumPairs {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 5;
        maxKsumPairs mksp = new maxKsumPairs();
        int ans = mksp.maxOperations(nums, k);
        System.out.println(ans);
    }
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int i = 0, j = nums.length-1, op = 0;
        while(i < j) {
            if ((nums[i] + nums[j]) == k) {
                System.out.println(" i: " + i + " j: " + j);
                op++;
                i++;j--;
            }
            else if ((nums[i] + nums[j]) > k) {
                j--;
            }
            else {
                i++;
            }
        }
        return op;
    }
}
