import java.io.*;
import java.util.*;

public class Main {
    static int ans, N, M;
    static int[] di = {0, 0, 1}, dj = {1, -1, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 줄은 오른쪽으로만 이동 가능
        for (int j = 1; j < M; j++) {
            map[0][j] += map[0][j - 1];
        }

        //

        for (int i = 1; i < N; i++) {

            // 왼쪽에서 오른쪽으로 이동 vs 위로 이동
            int[] ltr = new int[M]; // 왼 -> 오(left to right)
            ltr[0] = map[i - 1][0] + map[i][0];
            for (int j = 1; j < M; j++) {
                ltr[j] = map[i][j] + Math.max(ltr[j - 1], map[i - 1][j]);
            }

            // 오른쪽에서 왼쪽으로 이동 vs 위로 이동
            int[] rtl = new int[M]; // 오 -> 왼(right to left)
            rtl[M - 1] = map[i - 1][M - 1] + map[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                rtl[j] = map[i][j] + Math.max(rtl[j + 1], map[i - 1][j]);
            }

            for (int j = 0; j < M; j++) {
                map[i][j] = Math.max(ltr[j], rtl[j]);
            }
        }

        // 출력
        System.out.println(map[N - 1][M - 1]);
    }
}