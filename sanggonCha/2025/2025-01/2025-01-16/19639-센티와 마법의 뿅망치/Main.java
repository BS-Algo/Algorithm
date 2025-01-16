import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N(거인의 수), H(센티의 키), T(뿅망치의 횟수 제한) 입력 받기
        String[] NHT = br.readLine().split(" ");
        int N = Integer.parseInt(NHT[0]);
        int H = Integer.parseInt(NHT[1]);
        int T = Integer.parseInt(NHT[2]);

        // 거인의 키 입력 받기(N줄)
        PriorityQueue<Integer> giants = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int giant = Integer.parseInt(br.readLine());
            if (giant >= H) giants.offer(giant); // 큐에 저장
        }

        // 뿅망치의 횟수가 남아 있고
        // 센티보다 크거나 같은 거인이 있을 동안
        // 근데 최대값이 1이라면 더 이상 줄일 수 없으므로 종료
        int cnt = 0;
        while (T > 0 && !giants.isEmpty() && giants.peek() > 1) {
            int giant = giants.poll() / 2;
            T--; // 뿅망치 사용
            cnt++; // 뿅망치 사용 횟수 카운트
            if (giant >= H) {
                giants.offer(giant); // 추가
            }
        }

        if (giants.isEmpty()) {
            System.out.println("YES\n" + cnt);
        } else {
            System.out.println("NO\n" + giants.peek());
        }
    }
}