package DSA.slidingWindow;

public class longest1sSubarrayAfter1ElementDeleteQ {
    public static void main(String[] args) {
        longest1sSubarrayAfter1ElementDeleteQ q = new longest1sSubarrayAfter1ElementDeleteQ();
        int[] nums = {0,1,1,1,0,1,1,0,1};
        int ans = q.longestSubarray(nums);
        System.out.println(ans);
    }
    public int longestSubarray(int[] nums) {
        return longestOnes(nums, 1)-1;
    }
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, countzero = 0, maxOnes = 0;
        if (nums[j] == 0)   countzero++;
        while((j < nums.length-1) && (i >= 0)) {
            if (countzero <= k) {

                if (nums[j+1] == 0 && (countzero == k))  {
                    j++; i++;countzero++;
                    if(nums[i-1] == 0)countzero--;
                }
                else if (nums[j+1] == 0) {
                    j++;countzero++;
                    maxOnes = Math.max(maxOnes, j-i+1);
                }
                else if (nums[j+1] == 1){
                    j++;
                    maxOnes = Math.max(maxOnes, j-i+1);

                }

            }
            else {
                i++;
                if (nums[i-1] == 0) countzero--;

            }


        }
        return maxOnes;
    }
}
