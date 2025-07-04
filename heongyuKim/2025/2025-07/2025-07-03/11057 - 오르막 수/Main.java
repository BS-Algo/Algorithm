import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int N;
    static int[][] dp;

    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int q = j; q <= 9; q++) {
                    dp[i][j] += dp[i - 1][q];
                    dp[i][j] %= 10007;
                }
            }
        }

        System.out.println(dp[N][0] % 10007);
    }
}