import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 좌표에서는 M과 N을 반대로 나타내고 있어서 주의하기!
class Main {
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] graph;
    static int count = 0;
    static int M;
    static int N;
    static int K;

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    static int num = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        M = Integer.parseInt(info.nextToken());
        N = Integer.parseInt(info.nextToken());
        K = Integer.parseInt(info.nextToken());

        // 그래프 생성
        graph = new int[M][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer square = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(square.nextToken());
            int startY = Integer.parseInt(square.nextToken());
            int endX = Integer.parseInt(square.nextToken());
            int endY = Integer.parseInt(square.nextToken());

            for (int j = startY; j < endY; j++) {
                for (int e = startX; e < endX; e++) {
                    graph[j][e] = 1;
                }
            }
        }

        // dfs
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 0) {
                    num = 0;
                    dfs(i, j);
                    pq.offer(num);
                    count++;
                }
            }
        }

        while (!pq.isEmpty()) {
            int num = pq.poll();
            sb.append(num).append(" ");
        }

        System.out.println(count);
        System.out.println(sb.toString());
    }

    private static void dfs(int x, int y) {
        graph[x][y] = 1;
        num++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0 <= nx && nx < M) && (0 <= ny && ny < N) && (graph[nx][ny] == 0)) {
                dfs(nx, ny);
            }
        }

    }
}