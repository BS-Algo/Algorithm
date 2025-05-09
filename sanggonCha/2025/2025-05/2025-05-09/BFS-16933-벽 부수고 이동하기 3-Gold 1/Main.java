import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class Main {
    static int N, M, K;
    static int[][][] arr;
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 손님 수 입력 받기

        // N M K 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 배열 생성
        arr = new int[K + 1][N][M];

        // 맵 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                for (int k = 0; k <= K; k++) {
                    arr[k][i][j] = line.charAt(j) - '0';
                }
            }
        }

        // bfs
        bfs();
    }

    private static void bfs() {
        boolean[][][] visited = new boolean[K + 1][N][M];
        visited[0][0][0] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0, 1, 1}); // 좌표, 이동한 칸의 수, 낮과 밤 정보(낮: 1)

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int k = cur[0];
            int i = cur[1];
            int j = cur[2];
            int cnt = cur[3];
            int dayOrNight = cur[4];
            int nextDayOrNight = dayOrNight == 1 ? 0 : 1;

            if (i == N - 1 && j == M - 1) {
                System.out.println(cnt);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];

                if (ni >= 0 && ni < N && nj >= 0 && nj < M && !visited[k][ni][nj]) {
                    if (arr[k][ni][nj] == 0) {
                        visited[k][ni][nj] = true;
                        q.offer(new int[]{k, ni, nj, cnt + 1, nextDayOrNight});
                    } else if (dayOrNight == 0) {
                        q.offer(new int[]{k, i, j, cnt + 1, nextDayOrNight}); // 제자리 대기
                    } else if (k < K && !visited[k + 1][ni][nj]) { // 낮이면 벽을 부술 수 있음
                        arr[k + 1][ni][nj] = 0;
                        visited[k + 1][ni][nj] = true;
                        q.offer(new int[]{k + 1, ni, nj, cnt + 1, nextDayOrNight});
                    }
                }
            }
        }

        System.out.println(-1);
    }
}