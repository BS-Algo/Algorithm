import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N*N 배열 입력 받기
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp(누적합)
        // 1. 가로 누적합
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j + 1] += dp[i][j];
            }
        }

        // 2. 세로 테두리 누적합
        for (int j = 1; j < N + 1; j++) {
            for (int i = 1; i < N; i++) {
                dp[i + 1][j] += dp[i][j];
            }
        }

        // 좌표 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(dp[x2][y2] - dp[x2][y1] - dp[x1][y2] + dp[x1][y1]);
        }
    }
}