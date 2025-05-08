import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 처음에는 60000개가 넘는 n을 가진 배열을 생성하여 상하좌우로 이동하면서 갈 수 있는지 탐색하려고 했는데
// 이렇게 로직을 구현하면 성능이 너무 좋지 않아서 시간 초과나 메모리 초과가 날 수 있다.
// 그래서 좌표 정보들에 대해서 상근이네에서 거리가 1000이내인 좌표이면 갈 수 있다고 판단하여 bfs 로직을 작성하였다.
class Main {
    static int t;

    static int[][] graph;
    static boolean[] visited;

    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 받기
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            graph = new int[n + 2][2];
            visited = new boolean[n + 2];

            for (int j = 0; j < n + 2; j++) {
                StringTokenizer info = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(info.nextToken());
                int y = Integer.parseInt(info.nextToken());

                graph[j][0] = x;
                graph[j][1] = y;
            }


            bfs(graph[0][0], graph[0][1]);

            if (!flag) {
                System.out.println("sad");
            } else {
                System.out.println("happy");
            }

            flag = false;
        }

    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startX, startY});
        visited[0] = true;

        while (!q.isEmpty()) {
            int[] location = q.poll();
            int curX = location[0];
            int curY = location[1];

            if (curX == graph[graph.length - 1][0] && curY == graph[graph.length - 1][1]) {
                flag = true;
                break;
            }

            for (int i = 1; i < graph.length; i++) {
                int nextX = graph[i][0];
                int nextY = graph[i][1];

                if (!visited[i] && Math.abs(curX - nextX) + Math.abs(curY - nextY) <= 1000) {
                    visited[i] = true;
                    q.offer(new int[] {nextX, nextY});
                }
            }
        }
    }
}