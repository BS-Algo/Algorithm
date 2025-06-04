import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 카드 크기 입력
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        // greedy
        int cnt = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            int sum = a + b;

            cnt += sum;
            pq.offer(sum);
        }

        System.out.println(cnt);
    }
}