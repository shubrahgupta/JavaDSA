package DSA.dp;

public class equalSumPartition {
    static Boolean[][] t;
    public static void main(String[] args) {
        int N = 3;
        int[] arr = {1, 5, 11};

        int ans = equalSumPartition.equalPartition(N,arr);
        System.out.println(ans);
    }
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int i: arr) {
            sum += i;
        }
        if (sum % 2 != 0)   return 0;

        t = new Boolean[N+1][sum+1];
        Boolean x = func_tab(N,arr,sum/2, t);
        return (x) ? 1 : 0;
    }
    static Boolean func_tab(int N, int[] arr, int sum, Boolean[][] t){
        for(int i = 0; i < N+1; i++) {
            for(int j = 0; j < sum+1; j++) {
                if (i == 0) t[i][j] = false;
                else if (j == 0) t[i][j] = true;

            }
        }
        for(int i = 1; i < N+1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i-1] <= j) {
                    t[i][j] = (t[i-1][j] || t[i - 1][j - arr[i - 1]]);
                }

                else {
                    t[i][j] = t[i-1][j];

                }
            }
        }



        return t[N][sum];

    }
}
