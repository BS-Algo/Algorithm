import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 처음에 풀었던 방식인데 방문 체크를 하지 않아서 계속 메모리 초과가 발생하였음...
// 또한 현재 위치에 대한 범위를 제대로 설정해주지 못하였음.
class Main {

    // 방문 리스트
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
        Queue<int[]> q = new LinkedList<>();
        int[] start = {N, 0};
        q.offer(start);

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int n = node[0];
            int time = node[1];

            visited[n] = true;

            if (n == goal) {
                result = Math.min(result, time);
            }

            if (0 <= n - 1 && !visited[n - 1]) {
                q.offer(new int[] {n - 1, time + 1});
            }

            if (n + 1 <= 100000 && !visited[n + 1]) {
                q.offer(new int[] {n + 1, time + 1});
            }

            if (n * 2 <= 100000 && !visited[n * 2]) {
                q.offer(new int[] {n * 2, time});
            }
        }
    }
}