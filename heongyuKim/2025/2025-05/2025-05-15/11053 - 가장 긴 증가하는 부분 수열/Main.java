import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static int N;

    static int[] arr;
    static int[] dp;

    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];

        StringTokenizer nums = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(nums.nextToken());

            arr[i] = num;
        }

        for (int i = 0; i < N; i++) {
            result = Math.max(result, recursion(i));
        }

        System.out.println(result);
    }

    private static int recursion(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < arr[n]) {
                dp[n] = Math.max(dp[n], recursion(i) + 1);
            }
        }

        return dp[n];
    }
}