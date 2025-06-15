import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T 입력
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            // N 입력
            int N = Integer.parseInt(br.readLine());

            // 장 수 입력
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pq.offer((long) Integer.parseInt(st.nextToken()));
            }

            // Greedy
            long ans = 0;
            while (pq.size() >= 2) {
                long a = pq.poll();
                long b = pq.poll();

                long sum = a + b; // 합치기

                ans += sum;
                pq.offer(sum);
            }

            // 출력
            System.out.println(ans);
        }
    }
}