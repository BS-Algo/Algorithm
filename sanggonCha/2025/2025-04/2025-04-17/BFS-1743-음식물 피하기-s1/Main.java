import java.io.*;
import java.util.*;

class Main {
    static int N, M, ans = 0;
    static int[] di = {1, -1, 0, 0}, dj = {0, 0, 1, -1};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M, R 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 음식물 입력 받기
        arr = new int[N][M];
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            arr[i][j] = 1;
        }

        // bfs
        bfs();

        // 출력
        System.out.println(ans);
    }

    private static void bfs() {
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});

                    int cnt = 1;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int ni = cur[0] + di[k];
                            int nj = cur[1] + dj[k];
                            if (ni >= 0 && ni < N && nj >= 0 && nj < M && arr[ni][nj] == 1 && !visited[ni][nj]) {
                                q.offer(new int[]{ni, nj});
                                visited[ni][nj] = true;
                                cnt++;
                            }
                        }
                    }

                    ans = Math.max(ans, cnt);
                }
            }
        }
    }
}