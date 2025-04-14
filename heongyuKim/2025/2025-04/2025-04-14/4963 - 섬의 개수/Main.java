import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    // 상하좌우 왼쪽위, 왼쪽아래, 오른쪽위, 오른쪽아래 탐색
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};

    // 그래프
    static int[][] graph;

    // 방문 리스트
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            StringTokenizer info = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(info.nextToken());
            int h = Integer.parseInt(info.nextToken());

            int result = 0;

            if (w == 0 && h == 0) {
                break;
            }

            graph = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                StringTokenizer nums = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(nums.nextToken());
                }
            }

            // dfs
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && graph[i][j] == 1) {
                        result++;
                        dfs(i, j, w, h);
                    }
                }
            }

            System.out.println(result);

        }

    }

    private static void dfs(int x, int y, int w, int h) {

        visited[x][y] = true;

        // 8방향 탐색 후 이어져 있는 곳 있으면 이어서 탐색
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (-1 < nx && nx < h && -1 < ny && ny < w) {
                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    dfs(nx, ny, w, h);
                }
            }

        }
    }

}