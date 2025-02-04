import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n, m 입력 받기
        String[] nm = br.readLine().split(" ");
        // 1 ≤ ai ≤ 1,000,000 이라서 long을 사용
        // 0 ≤ m ≤ 15,000 = 15×n
        // n = 1000 이고,
        // 999,000 <= ai <= 1,000,000 이라면
        // 1,000,000 * 2(합한 결과) * 15,000(합하는 횟수) = 30,000,000,000 = 300억
        // 따라서 합하는 과정에서 int 범위 21억을 초과할 가능성이 있음
        long n = Integer.parseInt(nm[0]);
        long m = Integer.parseInt(nm[1]);

        // 숫자 입력 받기
        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer((long) Integer.parseInt(st.nextToken()));
        }

        // m = 2
        // 1 2 3 4 5 6
        // 3 3 3 4 5 6
        // 3 4 5 6 6 6
        // = 30

        // m = 3
        // 1 2 3 4 5 6
        // 3 3 3 4 5 6
        // 3 4 5 6 6 6
        // 5 6 6 6 7 7
        // = 37 = 30 + 7

        // m = 4
        // 1 2 3 4 5 6
        // 3 3 3 4 5 6
        // 3 4 5 6 6 6
        // 5 6 6 6 7 7
        // 6 6 7 7 11 11
        // = 48 = 37 + 11

        // 제일 작은 두 수를 골라서(우선순위큐에서 추출)
        // 합한 값으로 덮어쓰기(우선순위큐에 삽입)

        // m 번 합
        // 우선 순위 큐의 시간 복잡도는 O(logn)
        for (int i = 0; i < m; i++) {
            long a = pq.poll(); // O(logn)
            long b = pq.poll(); // O(logn)
            long ab = a + b;
            pq.offer(ab); // O(logn)
            pq.offer(ab); // O(logn)
        }

        // 따라서 총 연산의 횟수는 O(mlogn)
        // 최대값인 경우에 (입력 연산은 O(1)이므로 고려하지 않음)
        // n = 1,000
        // m = 15,000
        // 총 15,000 * log(1000) = 15,000 * 10(대략)
        // = 150,000(0.0015초 = 1.5ms) < 100,000,000(1억) = 1초
        // 따라서 충분히 통과 가능하다!

        long ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }

        System.out.println(ans);
    }
}