import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static int M;

    static char[][] graph;
    static boolean[][] visited;

    static int white = 0;
    static int black = 0;

    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        graph = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String soldier = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = soldier.charAt(j);
            }
        }

        // dfs
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && graph[i][j] == 'W') {
                    count = 0;
                    count++;
                    dfs(i, j, 'W');
                    white += count * count;
                }

                if (!visited[i][j] && graph[i][j] == 'B') {
                    count = 0;
                    count++;
                    dfs(i, j, 'B');
                    black += count * count;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(white).append(" ").append(black);
        System.out.println(result);
    }

    private static void dfs(int x, int y, char team) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0 <= nx && nx < M) && (0 <= ny && ny < N) && (!visited[nx][ny]) && (graph[nx][ny] == team)) {
                count++;
                dfs(nx, ny, team);
            }
        }
    }

}