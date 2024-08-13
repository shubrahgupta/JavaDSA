package DSA.dp;

public class countSubsetwithGivenSum {
    int[][] t;
    public static void main(String[] args) {
        countSubsetwithGivenSum q = new countSubsetwithGivenSum();
        int N = 2;
        int[] arr = {2, 2};
        int sum = 2;
        System.out.println(q.perfectSum(arr,N,sum));
    }
    public int zeroSubsets(int[] arr, int N) {
        int count = 0;
        for(int i = 0; i < N; i++) {
            if (arr[i] == 0)    count++;
        }
        return (int) (Math.pow(2,count)% (Math.pow(10,9)+7));
    }
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

}
