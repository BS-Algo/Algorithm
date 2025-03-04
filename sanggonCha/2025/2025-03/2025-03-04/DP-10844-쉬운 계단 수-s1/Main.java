import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // dp
        int[][] dp = new int[N][10];
        for (int i = 1; i < 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) dp[i][j] = (dp[i - 1][j + 1]) % 1000000000;
                else if (j == 9) dp[i][j] = (dp[i - 1][j - 1]) % 1000000000;
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }

        }

        // 출력
        long ans = 0;
        for (int j = 0; j < 10; j++) {
            ans = (ans + dp[N - 1][j]) % 1000000000;
        }
        System.out.println(ans);
    }
}
