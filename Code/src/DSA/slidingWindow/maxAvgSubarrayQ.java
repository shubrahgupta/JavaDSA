package DSA.slidingWindow;

public class maxAvgSubarrayQ {
    public static void main(String[] args) {
        maxAvgSubarrayQ masq = new maxAvgSubarrayQ();
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double ans = masq.findMaxAverage(nums, k);
        System.out.println(ans);
    }
    public double findMaxAverage(int[] nums, int k) {
        int i = 0; int j = k-1;
        int sum = 0;
        double maxAvg = 0;
        for(int l = i; l <= j; l++) {
            sum += nums[l];
            maxAvg = (double) sum /k;
        }
        while(j < nums.length-1) {
             j++;
             sum += (nums[j] - nums[i]);
             i++;
             maxAvg = Math.max(maxAvg, (double) sum /k);
        }
        return maxAvg;
    }
}
