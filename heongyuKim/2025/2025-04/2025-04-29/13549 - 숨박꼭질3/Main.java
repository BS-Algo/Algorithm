import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {

    // 방문리스트
    static boolean[] visited = new boolean[100001];

    // 동생이 있는 위치
    static int goal;

    // 동생을 찾는 가장 빠른 시간
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(info.nextToken());
        goal = Integer.parseInt(info.nextToken());

        bfs(N);

        System.out.println(result);
    }

    private static void bfs(int N) {
        Queue<Node> q = new LinkedList<>();
        Node start = new Node(N, 0);
        q.offer(start);

        while (!q.isEmpty()) {
            Node node = q.poll();
            int n = node.index;
            int time = node.time;

            visited[n] = true;

            // 더 짧은 시간이 나올수도 있으므로 break를 처리하면 안됨.
            if (n == goal) {
                result = Math.min(result, time);
            }


            if ((0 <= n - 1) && (!visited[n - 1])) {
                q.offer(new Node(n - 1, time + 1));
            }
            if ((n + 1 <= 100000) && (!visited[n + 1])) {
                q.offer(new Node(n + 1, time + 1));
            }
            if ((n * 2 <= 100000) && (!visited[n * 2])) {
                q.offer(new Node(n * 2, time));
            }

        }
    }

    public static class Node {

        private int index;
        private int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}