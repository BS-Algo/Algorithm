import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 우선순위 큐를 사용한 그리디 문제
class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            // 우선순위 큐
            PriorityQueue<Long> pq = new PriorityQueue<>();

            // 결과
            long result = 0;

            // N
            int N = Integer.parseInt(br.readLine());

            StringTokenizer nums = new StringTokenizer(br.readLine());
            
            // 우선순위 큐에 숫자 넣기
            for (int j = 0; j < N; j++) {
                pq.offer(Long.parseLong(nums.nextToken()));
            }

            
            // 넣은 숫자를 기반으로 합 구하기
            while (pq.size() > 1) {
                long num1 = pq.poll();
                long num2 = pq.poll();

                long sum = (long) num1 + num2;
                result += sum;

                pq.offer(sum);
            }

            // 결과 출력
            System.out.println(result);
        }

    }
}