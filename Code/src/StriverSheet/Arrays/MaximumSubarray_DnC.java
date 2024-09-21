package StriverSheet.Arrays;

//https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSubarray_DnC {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {-1,-2};
        MaximumSubarray_DnC q = new MaximumSubarray_DnC();
        System.out.println(q.maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        return process(nums, 0, nums.length-1);
    }
    public int process(int[] nums, int i, int j) {
        if (i == j){
            return nums[i];
        }
        int mid = (i+j)/2;
        int leftMS = process(nums, i, mid);
        int rightMS = process(nums, mid+1, j);
        int crossMid = crossMid(nums, i, j, mid);
        int greaterHalf = Math.max(leftMS, rightMS);
        return Math.max(greaterHalf, crossMid);
    }
    public int crossMid(int[] nums, int i, int j, int mid) {
        int lMS = Integer.MIN_VALUE, rMS = Integer.MIN_VALUE, sum = 0;
        for(int k = mid; k >= i; k--) {
            sum += nums[k];
            lMS = Math.max(sum, lMS);
        }
        sum = 0;
        for(int k = mid+1; k <= j; k++) {
            sum += nums[k];
            rMS = Math.max(sum, rMS);
        }
        return lMS + rMS;
    }


}
