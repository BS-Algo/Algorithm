import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int h = 0;
    static int w = 0;

    static int startRow = 0;
    static int startCol = 0;
    
    // 그래프와 방문리스트
    static char[][] graph;
    static boolean[][] visited;

    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer length = new StringTokenizer(br.readLine());

        h = Integer.parseInt(length.nextToken());
        w = Integer.parseInt(length.nextToken());

        graph = new char[h][w];
        visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            String info = br.readLine();

            for (int j = 0; j < w; j++) {
                char word = info.charAt(j);
                graph[i][j] = word;

                if (word == 'I') {
                    startRow = j;
                    startCol = i;
                }

                if (word == 'X') {
                    visited[i][j] = true;
                }

            }
        }

        dfs(startCol, startRow);

        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }

    private static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (-1 < nx && nx < h && -1 < ny && ny < w) {
                if (!visited[nx][ny]) {
                    if (graph[nx][ny] == 'P') {
                        result++;
                    }

                    dfs(nx, ny);
                }
            }
        }
    }
}