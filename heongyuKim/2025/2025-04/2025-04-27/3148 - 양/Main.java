import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int R;
    static int C;

    static char[][] graph;
    static boolean[][] visited;

    static int sheepCount = 0;
    static int wolfCount = 0;

    static int sheeps = 0;
    static int wolves = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        R = Integer.parseInt(info.nextToken());
        C = Integer.parseInt(info.nextToken());

        // 그래프 생성
        graph = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String soldier = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = soldier.charAt(j);
            }
        }

        // dfs
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && graph[i][j] != '#') {
                    sheepCount = 0;
                    wolfCount = 0;

                    if (graph[i][j] == 'o') {
                        sheepCount++;
                    }

                    if (graph[i][j] == 'v') {
                        wolfCount++;
                    }

                    dfs(i, j);

                    if (sheepCount > wolfCount) {
                        sheeps += sheepCount;
                    } else {
                        wolves += wolfCount;
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(sheeps).append(" ").append(wolves);
        System.out.println(result);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0 <= nx && nx < R) && (0 <= ny && ny < C) && (!visited[nx][ny]) && (graph[nx][ny] != '#')) {
                if (graph[nx][ny] == 'o') {
                    sheepCount++;
                }

                if (graph[nx][ny] == 'v') {
                    wolfCount++;
                }

                dfs(nx, ny);
            }
        }
    }
}