import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static int M;

    static int[][] graph;
    static int[][] visited;
    static Queue<int[]> tomatoStart = new LinkedList<>();
    
    // 토마토가 모두 익어있는지 체크할 변수
    static boolean isRipe = true;
    static int result = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        graph = new int[M][N];
        visited = new int[M][N];

        // graph에 값을 넣으면서 벽이나 익은 곳에는 visited 배열에 1을 넣기
        for (int i = 0; i < M; i++) {
            StringTokenizer tomatoes = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tomato = Integer.parseInt(tomatoes.nextToken());
                graph[i][j] = tomato;

                if (tomato == -1 || tomato == 1) {
                    visited[i][j] = 1;

                    if (tomato == 1) {
                        tomatoStart.offer(new int[] {i , j});
                    }
                }

                // 이미 모든 토마토가 익어있는지 체크
                if (tomato == 0) {
                    isRipe = false;
                }
            }
        }

        // 모든 토마토가 익어있으면 0 출력
        if (isRipe) {
            System.out.println(0);
            return;
        }

        bfs();

        // 토마토가 모두 익었는지 체크하면서 최대 일수 체크
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, visited[i][j]);
                
                // 만약 안 익은 부분이 있으면 -1 출력 후 종료
                if (visited[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        // 처음 시작을 1일로 했으므로 결과에서 1을 뺐음.
        System.out.println(result - 1);
    }

    private static void bfs() {

        while (!tomatoStart.isEmpty()) {
            int[] tomato = tomatoStart.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tomato[0] + dx[i];
                int ny = tomato[1] + dy[i];

                if ((0 <= nx && nx < M) && (0 <= ny && ny < N) && visited[nx][ny] == 0 && graph[nx][ny] == 0) {
                    graph[nx][ny] = 1;
                    visited[nx][ny] = visited[tomato[0]][tomato[1]] + 1;
                    tomatoStart.offer(new int[] {nx, ny});
                }
            }
        }
    }
}