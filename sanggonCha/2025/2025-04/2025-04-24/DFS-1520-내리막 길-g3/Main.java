import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0, M, N;
    static int[] di = {0, 0, 1, -1}, dj = {1, -1, 0, 0};
    static int[][] dp, map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // M, N 입력 받기
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dp = new int[M][N];
        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // 방문하지 않는 경로 기록
            }
        }

        // 출력
        System.out.println(dfs(0, 0));
    }

    private static int dfs(int i, int j) {
        // 도착했다면 1을 반환
        if (i == M - 1 && j == N - 1) return 1;

        // 방문한 적 있는 곳이라면 기존 값을 반환
        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = 0;

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (ni >= 0 && ni < M && nj >= 0 && nj < N && map[i][j] > map[ni][nj]) {
                dp[i][j] += dfs(ni, nj);
            }
        }

        return dp[i][j];
    }
}