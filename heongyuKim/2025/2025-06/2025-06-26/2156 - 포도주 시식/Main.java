import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int N;
    static int[] arr;
    static int[] dp;

    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(arr[1]);
            return;
        }

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        result = dp[2];

        for (int i = 3; i < N + 1; i++) {
            // 안마시거나 연속으로 마시거나 그냥 마시거나
            dp[i] = Math.max(Math.max(dp[i - 1], arr[i] + arr[i - 1] + dp[i - 3]), arr[i] + dp[i - 2]);
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}