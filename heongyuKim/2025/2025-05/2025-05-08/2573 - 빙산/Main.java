import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// bfs 과정 중에 녹이는 것을 먼저 진행해버리면 다음 빙산을 탐색할 때 영향을 주기 때문에
// 현재 연도의 빙산을 먼저 탐색한 후 녹이는 것이 깔끔하다.
class Main {
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static int M;

    static int[][] graph;
    static boolean[][] visited;
    static int[][] melt;

    static int year = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N과 M
        StringTokenizer info = new StringTokenizer(br.readLine());
        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        // 그래프, 방문 리스트, 녹는 배열 생성
        graph = new int[N][M];
        visited = new boolean[N][M];
        melt = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer ice = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int iceberg = Integer.parseInt(ice.nextToken());
                graph[i][j] = iceberg;
            }
        }

        while (true) {
            visited = new boolean[N][M];
            melt = new int[N][M];
            int count = 0;

            // bfs
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && graph[i][j] > 0) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            if (count == 0) {
                System.out.println(0);
                return;
            }

            if (count > 1) {
                System.out.println(year);
                return;
            }

            // 녹이는 과정
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (melt[i][j] > 0) {
                        graph[i][j] = Math.max(0, graph[i][j] - melt[i][j]);
                    }
                }
            }
            year++;
        }

    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] iceberg = q.poll();
            int curX = iceberg[0];
            int curY = iceberg[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M ) {
                    // 방문 처리
                    if (!visited[nx][ny] && graph[nx][ny] > 0) {
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                    }

                    // 녹는 양 계산
                    if (graph[nx][ny] == 0 && graph[curX][curY] > 0) {
                        melt[curX][curY]++;
                    }
                }
            }
        }
    }
}