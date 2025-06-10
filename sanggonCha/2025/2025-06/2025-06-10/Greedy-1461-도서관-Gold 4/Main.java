import java.io.*;
import java.util.*;

public class Main {
    private static PriorityQueue<Integer> positive, negative;
    private static int dis, ans = 0, N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 책 입력
        positive = new PriorityQueue<>(Collections.reverseOrder());
        negative = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());

        boolean positiveMax = false;
        int maxInput = 0;
        while (N-- > 0) {
            int input = Integer.parseInt(st.nextToken());
            if (input > 0) {
                positive.offer(input);
                if (input > maxInput) {
                    maxInput = input;
                    positiveMax = true;
                }
            } else {
                negative.offer(-input); // 양수로 바꿔서 offer
                if (-input > maxInput) {
                    maxInput = -input;
                    positiveMax = false;
                }
            }
        }

        if (positiveMax) {
            calculate(negative);
            calculate(positive);
        } else {
            calculate(positive);
            calculate(negative);
        }

        // 출력
        System.out.println(ans - maxInput);
    }

    private static void calculate(PriorityQueue<Integer> pq) {
        // 1-1. 큰 수부터 두 개씩 묶어서 처리
        while (pq.size() >= M) {
            dis = pq.poll();
            for (int i = 0; i < M - 1; i++) { // M개 뽑기
                pq.poll();
            }
            ans += dis * 2;
        }

        // 1-2. 나머지 수 처리
        if (!pq.isEmpty()) {
            dis = pq.poll();
            while (!pq.isEmpty()) {
                pq.poll();
            }
            ans += dis * 2;
        }
    }
}