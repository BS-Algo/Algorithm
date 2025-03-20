import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 0, N;

        while ((N = Integer.parseInt(br.readLine())) != 0) {

            tc++;

            // 배열 입력 받기
            int[][] dp = new int[N][3];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 초기값 설정
            dp[1][0] += dp[0][1];
            dp[1][1] += Math.min(dp[1][0], dp[0][1] + Math.min(0, dp[0][2]));
            dp[1][2] += Math.min(dp[1][1], dp[0][1] + Math.min(0, dp[0][2]));

            // dp
            for (int i = 2; i < N; i++) {
                dp[i][0] += Math.min(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] += Math.min(Math.min(dp[i][0], dp[i - 1][0]), Math.min(dp[i - 1][1], dp[i - 1][2]));
                dp[i][2] += Math.min(Math.min(dp[i][1], dp[i - 1][1]), dp[i - 1][2]);
            }

            System.out.println(tc + ". " + dp[N - 1][1]);
        }
    }
}
