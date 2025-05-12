import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static int L;
    static int R;

    static int[][] graph;
    static boolean[][] visited;
    static ArrayList<int[]> list;

    static boolean isMove = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        L = Integer.parseInt(info.nextToken());
        R = Integer.parseInt(info.nextToken());

        // 그래프와 방문 리스트 생성
        graph = new int[N][N];
        visited = new boolean[N][N];

        // 그래프에 값넣기
        for (int i = 0; i < N; i++) {
            StringTokenizer nums = new StringTokenizer(br.readLine());
            for (int j = 0; j< N; j++) {
                graph[i][j] = Integer.parseInt(nums.nextToken());
            }
        }

        for (int i = 0; i < 2001; i++) {
            isMove = false;
            visited = new boolean[N][N];

            // 이중 for문으로 bfs
            for (int j = 0; j < N; j++) {
                for (int e = 0; e < N; e++) {
                    if (!visited[j][e]) {
                        bfs(j, e);
                    }
                }
            }

            if (!isMove) {
                System.out.println(i);
                break;
            }

        }

    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        list = new ArrayList<>();

        int total = graph[x][y];
        int count = 1;
        q.offer(new int[] {x, y});
        list.add(new int[] {x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int nodeX = node[0];
            int nodeY = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = nodeX + dx[i];
                int ny = nodeY + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < N) && !visited[nx][ny] && (L <= Math.abs(graph[nodeX][nodeY] - graph[nx][ny]) && Math.abs(graph[nodeX][nodeY] - graph[nx][ny]) <= R)) {
                    count++;
                    total += graph[nx][ny];
                    q.offer(new int[] {nx, ny});
                    list.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        if (list.size() > 1) {
            isMove = true;
        }

        move(total / count);
    }

    private static void move(int average) {

        for (int i = 0; i < list.size(); i++) {
             int[] node = list.get(i);
             int x = node[0];
             int y = node[1];
             graph[x][y] = average;
        }
    }
}