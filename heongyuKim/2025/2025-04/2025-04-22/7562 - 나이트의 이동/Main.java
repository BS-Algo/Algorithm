import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시작 지점과 종료 지점이 같을 경우 return으로 종료시켜서 계속 틀렸었음...
class Main {

    static int[] dx = {-1, -2, -1, -2, 1, 2, 1, 2};
    static int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};

    static int startX;
    static int startY;
    static int endX;
    static int endY;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            // 체스판 한변의 길이
            int N = Integer.parseInt(br.readLine());
            int[][] visited = new int[N][N];

            for (int j = 0; j < N; j++) {
                Arrays.fill(visited[j], -1);
            }

            // 시작 지점
            StringTokenizer start = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(start.nextToken());
            startY = Integer.parseInt(start.nextToken());

            // 목표 지점
            StringTokenizer end = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(end.nextToken());
            endY = Integer.parseInt(end.nextToken());

            if (startX == endX && startY == endY) {
                System.out.println(0);
                continue;
            }

            bfs(visited, N);

            System.out.println(visited[endX][endY]);

        }
    }

    private static void bfs(int[][] visited, int N) {

        Queue<int[]> q = new LinkedList<>();

        visited[startX][startY] = 0;
        q.offer(new int[] {startX, startY});

        while (!q.isEmpty()) {
            int[] node = q.poll();

            int x = node[0];
            int y = node[1];
            int count = visited[x][y];

            for (int i = 0; i < 8; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 범위 내에 있는지
                if (0 <= nx && nx < N && 0 <= ny && ny < N && visited[nx][ny] == -1) {

                    if (nx == endX && ny == endY) {
                        visited[nx][ny] = count + 1;
                        return;
                    }

                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = count + 1;
                }
            }

        }
    }
}