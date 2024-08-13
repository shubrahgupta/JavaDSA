package DSA.slidingWindow;

public class maxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1};
        int k = 1;
        maxConsecutiveOnes mco = new maxConsecutiveOnes();
        int ans = mco.longestOnes(nums, k);
        System.out.println(ans);
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
