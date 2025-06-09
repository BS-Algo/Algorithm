import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 수 입력
        int zero = 0;
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if (input < 0) {
                negative.offer(input);
            } else if (input > 0) {
                positive.offer(input);
            } else {
                zero++;
            }
        }


        // 1. 양수
        int ans = 0;

        // 1-1. 큰 수부터 두 개씩 묶어서 처리
        while (positive.size() >= 2) {
            int a = positive.poll();
            int b = positive.poll();
            if (a == 1 || b == 1) { // 1이 있으면
                ans += (a + b); // 곱하지 않고 더하는 게 이득
            } else {
                ans += a * b;
            }
        }

        // 1-2. 나머지 양수 처리
        if (!positive.isEmpty()) {
            ans += positive.poll(); // 나머지 한 개는 그냥 더하기
        }

        // 2. 음수

        // 2-1. 음수끼리 곱 처리
        while (negative.size() >= 2) {
            int a = negative.poll();
            int b = negative.poll();
            ans += a * b; // 절댓값이 큰 음수끼리 곱연산(-1이 있어도)
        }

        // 2-2. 0 처리
        while (zero-- > 0 && !negative.isEmpty()) { // 0이 존재하고, 아직 음수가 남았다면
            negative.poll(); // 소거
        }

        // 2-3. (0으로 소거하지 못 했다면)나머지 음수 처리
        if(!negative.isEmpty()) {
            ans += negative.poll();
        }

        // 출력
        System.out.println(ans);
    }
}