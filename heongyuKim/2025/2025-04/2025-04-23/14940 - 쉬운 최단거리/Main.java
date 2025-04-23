import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // N과 M
    static int N;
    static int M;

    // 그래프
    static int[][] graph;
    // 방문리스트
    static int[][] visited;

    static int goalX = 0;
    static int goalY = 0;

    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer info = new StringTokenizer(br.readLine());
        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());
        
        // 방문 리스트 생성
        visited = new int[N][M];

        // 그래프 생성 및 값 입력
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer land = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(land.nextToken());

                if (num == 2) {
                    goalX = i;
                    goalY = j;
                }

                graph[i][j] = num;
            }
        }

        // bfs
        bfs(goalX, goalY);

        // 결과 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1 && visited[i][j] == 0) {
                    visited[i][j] = -1;
                }

                result.append(visited[i][j]).append(" ");
            }
            result.append("\n");
        }

        System.out.println(result.toString());
    }


    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int nodeX = node[0];
            int nodeY = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = nodeX + dx[i];
                int ny = nodeY + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny  < M) && (visited[nx][ny] == 0) && (graph[nx][ny] == 1)) {
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = visited[nodeX][nodeY] + 1;
                }
            }
        }
    }
}