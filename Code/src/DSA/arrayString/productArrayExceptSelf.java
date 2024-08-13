package DSA.arrayString;

import java.util.Arrays;

public class productArrayExceptSelf {
    public static void main(String[] args) {
        productArrayExceptSelf paes = new productArrayExceptSelf();
        int[] nums = {1,2,3,4};
        int[] answer = paes.productExceptSelf(nums);
        System.out.println(Arrays.toString(answer));
    }
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int curr = 1;
        for(int i = 0; i < nums.length; i++) {
            answer[i] = curr;
            curr *= nums[i];

        }
        System.out.println(Arrays.toString(answer));
        curr = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            answer[i] *= curr;
            curr *= nums[i];

        }
        System.out.println(Arrays.toString(answer));
        return answer;

    }
}
