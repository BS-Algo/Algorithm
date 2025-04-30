import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int[][] map;
    static int[][][] dp;
    static int[] dx = {-1, 0, 1}; // 왼, 중, 오

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], INF); // dp 초기화
            }
        }

        // 첫 줄 초기화
        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                dp[0][j][d] = map[0][j];
            }
        }

        // DP 계산
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 3; d++) {
                    int prevX = j - dx[d];
                    if (prevX < 0 || prevX >= M) continue;
                    for (int prevD = 0; prevD < 3; prevD++) {
                        if (d == prevD) continue;
                        if (dp[i - 1][prevX][prevD] != INF) {
                            dp[i][j][d] = Math.min(dp[i][j][d],
                                dp[i - 1][prevX][prevD] + map[i][j]);
                        }
                    }
                }
            }
        }

        // 결과 계산
        int result = INF;
        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                result = Math.min(result, dp[N - 1][j][d]);
            }
        }

        System.out.println(result);
    }
}
