import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static int M;
    static int K;

    static int[][] graph;
    static boolean[][] visited;

    static int count = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());
        K = Integer.parseInt(info.nextToken());

        // 그래프 생성
        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            StringTokenizer index = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(index.nextToken());
            int y = Integer.parseInt(index.nextToken());

            graph[x - 1][y - 1] = 1;
        }

        // dfs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    count = 0;
                    count++;
                    dfs(i, j);
                    max = Math.max(max, count);
                }
            }
        }

        System.out.println(max);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (!visited[nx][ny]) && (graph[nx][ny] == 1)) {
                count++;
                dfs(nx, ny);
            }
        }
    }

}