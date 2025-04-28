import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;

    // 그래프와 방문 리스트
    static char[][] graph;
    static boolean[][] visited;

    // 적록색약 아닌 사람 결과
    static int notBlindness = 0;
    // 적록색약인 사람 결과
    static int blindness = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 그래프와 방문 리스트 생성
        graph = new char[N][N];
        visited= new boolean[N][N];
        
        // 그래프에 값 넣기
        for (int i = 0; i < N; i++) {
            String colors = br.readLine();
            for (int j = 0; j < colors.length(); j++) {
                graph[i][j] = colors.charAt(j);
            }
        }
        
        // 적록색약 X dfs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    notBlindness++;
                    dfs(i, j, graph[i][j]);
                }
            }
        }
        
        // 방문리스트 초기화 
        visited = new boolean[N][N];

        // 적록색약 O dfs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    blindness++;
                    if (graph[i][j] == 'B') {
                        dfs(i, j, graph[i][j]);
                    } else {
                        dfs2(i, j);
                    }
                }
            }
        }
        
        // 결과 출력
        StringBuilder result = new StringBuilder();
        result.append(notBlindness).append(" ").append(blindness);
        System.out.println(result);
    }

    private static void dfs(int x, int y, char color) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0 <= nx && nx < N) && (0 <= ny && ny < N) && (!visited[nx][ny]) && (graph[nx][ny] == color)) {
                dfs(nx, ny, color);
            }
        }
    }

    private static void dfs2(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0 <= nx && nx < N) && (0 <= ny && ny < N) && (!visited[nx][ny]) && (graph[nx][ny] != 'B')) {
                dfs2(nx, ny);
            }
        }
    }

}