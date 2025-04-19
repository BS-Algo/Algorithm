import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer info = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(info.nextToken());
        int B = Integer.parseInt(info.nextToken());

        long result = bfs(A, B);

        System.out.println(result);
    }


    private static long bfs(int s, int target) {

        Queue<long[]> q = new LinkedList<>();
        q.offer(new long[] {s, 1});

        while (!q.isEmpty()) {
            long[] cur = q.poll();
            long val = cur[0];
            long cnt = cur[1];

            if (val == target) {
                return cnt;
            }

            if (val * 2 <= target) {
                q.offer(new long[] {val * 2, cnt + 1});
            }

            if (val * 10 + 1 <= target) {
                q.offer(new long[] {val * 10 + 1, cnt + 1});
            }

        }
        return -1;
    }

}