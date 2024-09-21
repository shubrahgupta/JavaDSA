package StriverSheet.Arrays;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {-1,-2};
        MaximumSubarray q = new MaximumSubarray();
        System.out.println(q.maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
//        List<Integer> maxSubarray = new ArrayList<>();
        int result = Integer.MIN_VALUE, maxSum = 0;
        for(int i = 0; i < nums.length; i++) {
            maxSum += nums[i];
//            maxSubarray.add(nums[i]);
            result = Math.max(result, maxSum);
            if (maxSum < 0) {
//                maxSubarray.clear();
                maxSum = 0;
            }
        }
//        System.out.println(maxSubarray);
        return result;
    }
}
