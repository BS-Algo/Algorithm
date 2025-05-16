import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


// 역추적에 대해서 공부할 수 있었던 문제였다. 유익!
class Main {
    static int N;
    static int K;

    static int[] time = new int[100001];
    static int[] trace = new int[100001];

    static List<Integer> path = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        K = Integer.parseInt(info.nextToken());

        // 먼저 동생을 찾는 가장 빠른 시간을 구하기
        bfs();
        System.out.println(time[K] - 1);

        // 구한 결과를 바탕으로 그 경로를 역추적하기
        backTrace();
        int cur = N;
        while (cur != K) {
            path.add(cur);
            cur = trace[cur];
        }
        
        StringBuilder result = new StringBuilder();
        for (int seq : path) {
            result.append(seq).append(" ");
        }
        result.append(K);
        System.out.println(result.toString());
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        time[N] = 1;
        q.offer(N);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == K) {
                break;
            }
            
            for (int next : new int[] {cur - 1, cur + 1, cur * 2}) {
                if ((0 <= next && next <= 100000) && time[next] == 0) {
                    time[next] = time[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }

    private static void backTrace() {
        Queue<Integer> q = new LinkedList<>();
        trace[K] = K;
        q.offer(K);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == N) {
                break;
            }

            for (int prev : new int[] {cur - 1, cur + 1, cur / 2}) {
                if ((0 <= prev && prev <= 100000) && trace[prev] == 0 && time[prev] == time[cur] - 1) {
                    trace[prev] = cur;
                    q.offer(prev);
                }
            }
        }

    }
}
