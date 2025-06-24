import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int N;

    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        dp = new long[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int j = 4; j < 1000001; j++) {
            dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % 1000000009;
        }

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            System.out.println(dp[N]);
        }
    }
}