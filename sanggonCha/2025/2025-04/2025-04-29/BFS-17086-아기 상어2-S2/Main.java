import java.io.*;
import java.util.*;

public class Main {
    static int N, M, maxDis = 0;
    static int[] di = {1, 1, 1, 0, 0, -1, -1, -1}, dj = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] arr, dis;
    static Queue<int[]> q = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 공간을 담을 배열 생성
        arr = new int[N][M];
        dis = new int[N][M];
        visited = new boolean[N][M];

        // 공간 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // bfs
        bfs();

        // 출력
        System.out.println(maxDis);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int ci = cur[0];
            int cj = cur[1];

            for (int d = 0; d < 8; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];

                if (ni >= 0 && ni < N && nj >= 0 && nj < M && !visited[ni][nj]) {
                    if (arr[ni][nj] == 0) {
                        visited[ni][nj] = true;
                        q.offer(new int[]{ni, nj});
                        dis[ni][nj] = Math.max(dis[ni][nj], dis[ci][cj] + 1);
                        maxDis = Math.max(maxDis, dis[ni][nj]);
                    }
                }
            }
        }
    }
}