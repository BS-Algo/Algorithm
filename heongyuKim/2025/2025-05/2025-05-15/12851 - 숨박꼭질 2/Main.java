import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 최소 시간과 최소 시간에 해당하는 경우의 수를 같이 구하는 문제여서 까다로운 문제였다. 복습이 필요할 듯하다.
class Main {
    static int N;
    static int K;
    static int[] time = new int[100001];

    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        K = Integer.parseInt(info.nextToken());

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        bfs();

        System.out.println(time[K] - 1);
        System.out.println(count);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        time[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == K) {
                count++;
                continue;
            }

            for (int next : new int[] {now - 1, now + 1, now * 2}) {
                if (next < 0 || next > 100000) {
                    continue;
                }

                if (time[next] == 0) {
                    time[next] = time[now] + 1;
                    q.offer(next);
                } else {
                    if (time[next] == time[now] + 1) {
                        q.offer(next);
                    }
                }
            }
        }
    }
}
