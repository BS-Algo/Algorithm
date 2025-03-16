import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T 입력 받기
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            // N 입력 받기
            int N = Integer.parseInt(br.readLine());

            // 점수 입력 받기
            int[][] dp = new int[2][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dp[0][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dp[1][j] = Integer.parseInt(st.nextToken());
            }

            // 예외 처리
            if (N == 1) {
                System.out.println(Math.max(dp[0][0], dp[1][0]));
            } else {
                // dp
                dp[0][1] += dp[1][0];
                dp[1][1] += dp[0][0];
                for (int j = 2; j < N; j++) {
                    dp[0][j] += Math.max(dp[1][j - 1], Math.max(dp[0][j - 2], dp[1][j - 2]));
                    dp[1][j] += Math.max(dp[0][j - 1], Math.max(dp[0][j - 2], dp[1][j - 2]));
                }

                // 출력
                System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
            }
        }
    }
}