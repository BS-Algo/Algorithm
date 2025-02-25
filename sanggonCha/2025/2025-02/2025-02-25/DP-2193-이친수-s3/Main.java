import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        N = Integer.parseInt(br.readLine());

        // dp
        if (N == 1) {
            System.out.println(1);
        } else if (N == 2) {
            System.out.println(1);
        } else {
            dp = new long[N + 1];
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            System.out.println(dp[N]);
        }
    }
}