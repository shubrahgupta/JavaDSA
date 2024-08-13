package DSA.dp;

public class countSubsetwithGivenDiff {
    static int[][] t;
    static final int M = 1000000007;
    public static int zeroSubsets(int[] arr, int N) {
        int count = 0;
        for(int i = 0; i < N; i++) {
            if (arr[i] == 0)    count++;
        }
        return (int) (Math.pow(2,count)% (M));
    }
    public static int perfectSum(int[] arr, int N, int sum){
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
                    t[i][j] = (int) (((t[i-1][j]% M) +
                            (t[i - 1][j - arr[i - 1]]% M))% M);
                }

                else {
                    t[i][j] = t[i-1][j];

                }
            }
        }
//        for (int[] ints : t) System.out.println(Arrays.toString(ints));


        return t[N][sum];

        // return (int) (t[N][sum] % (Math.pow(10,9)+7));

    }
    public static int countPartitions(int n, int d, int[] arr) {
        int S = 0;
        for(int i: arr) S += i;
        if ((S + d) % 2 != 0) return 0;

        int y = perfectSum(arr,n,(S+d)/2);
        // int z = a.get((S - d)/2);
        return (int) (y % M);



    }
}
