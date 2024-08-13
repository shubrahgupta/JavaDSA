package DSA.prefixSum;

import java.util.Arrays;

public class pivotIndex {
    public static void main(String[] args) {
        int[] nums = {2,1,-1};
        pivotIndex pi = new pivotIndex();
        int ans = pi.pivotIndex(nums);
        System.out.println(ans);
    }
    public int pivotIndex(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = 0;
        int[] post = new int[nums.length];
        post[nums.length-1] = 0;
        for(int i = 0; i < nums.length-1; i++) {
            pre[i+1] = pre[i] + nums[i];
            post[nums.length-2-i] = post[nums.length-1-i] + nums[nums.length-1-i];
        }
        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(post));
        for(int i = 0; i < pre.length; i++) {
            if (pre[i] == post[i]){
                return i;
            }
        }
        return -1;

    }
}
