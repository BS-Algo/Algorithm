import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, K 입력
        int N = Integer.parseInt(st.nextToken()); // 원생의 수
        int K = Integer.parseInt(st.nextToken()); // 조의 개수

        // 키 입력(입력 받으면서 차이를 바로 계산)
        st = new StringTokenizer(br.readLine());

        // 키 차이를 저장할 pq
        int now = 0, before = Integer.parseInt(st.nextToken()), start = before;
        PriorityQueue<Integer> diff = new PriorityQueue<>(Collections.reverseOrder());

        // 차이를 바로 계산
        for (int i = 0; i < N - 1; i++) {
            now = Integer.parseInt(st.nextToken());

            diff.offer(now - before);

            before = now;
        }

        // 최소 비용을 계산
        int ans = before - start; // 전체 구간
        while(K -- > 1) {
            ans -= diff.poll(); // 전체 구간에서 키 차이가 가장 큰 (K-1)개의 구간을 빼기
        }

        // 출력
        System.out.println(ans);
    }
}