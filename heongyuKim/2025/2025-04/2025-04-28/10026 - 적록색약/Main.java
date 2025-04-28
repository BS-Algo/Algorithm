import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 처음에는 dfs 함수를 2개 만들어서 적록색약인 부분을 체크할때 다른 dfs로 처리하였는데 
// 그것보다 R과 G중에서 하나를 기준으로 통일하여 값을 수정후 dfs를 하는 것이 더 좋아 보인다.
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
        
        // G를 R로 바꾸기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 'G') {
                    graph[i][j] = 'R';
                }
            }
        }

        // 적록색약 O dfs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    blindness++;
                    dfs(i, j, graph[i][j]);
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

}