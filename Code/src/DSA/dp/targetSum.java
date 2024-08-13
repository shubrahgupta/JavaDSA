package DSA.dp;

public class targetSum {
//    int counter = 0;
    static final int M = 1000000007;
    int[][] t;
    public static void main(String[] args) {

        targetSum q = new targetSum();
        int[] nums = {0,4,6,0,3,2,6,9,4,1};
        int target = 3;
        System.out.println(q.findTargetSumWays(nums,target));
    }
    public int findTargetSumWays(int[] arr, int target) {
        int S = 0;
        for(int i: arr) S += i;
        if ((S + target) % 2 != 0) return 0;

        int y = perfectSum(arr,arr.length,(S+target)/2);
        // int z = a.get((S - d)/2);
        return (int) (y % M);

    }
//    public int rec(int[] nums, int target, int n, int S) {
//        if (n == 0 && (target != 0))    return 0;
//        else if (n == 0) {
////            counter++;
//            return 1;
//        }
//        int x = target - nums[n-1];
//        int y = target + nums[n-1];
//
//        return rec(nums, x, n-1, S) + rec(nums, y, n-1, S);
//    }
    public int perfectSum(int[] arr, int N, int sum){
        t = new int[N+1][sum+1];
        for(int i = 0; i < N+1; i++) {
            for(int j = 0; j < sum+1; j++) {
                if (i == 0 && j == 0) t[i][j] = 1;
                else if (i == 0) t[i][j] = 0;
                else if (j == 0) t[i][j] = zeroSubsets(arr,i);

            }
        }
    //        for (int[] ints : t) System.out.println(Arrays.toString(ints));
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i-1] <= j) {
                    t[i][j] = (int) ((t[i-1][j]% (Math.pow(10,9)+7)) + (t[i - 1][j - arr[i - 1]]% (Math.pow(10,9)+7)));
                }

                else {
                    t[i][j] = t[i-1][j];

                }
            }
        }
    //        for (int[] ints : t) System.out.println(Arrays.toString(ints));



        return (int) (t[N][sum] % (Math.pow(10,9)+7));

    }
    public int zeroSubsets(int[] arr, int N) {
        int count = 0;
        for(int i = 0; i < N; i++) {
            if (arr[i] == 0)    count++;
        }
        return (int) (Math.pow(2,count)% (Math.pow(10,9)+7));
    }
}
