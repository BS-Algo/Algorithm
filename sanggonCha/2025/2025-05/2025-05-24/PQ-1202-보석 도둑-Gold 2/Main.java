import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 보석의 개수
        int K = Integer.parseInt(st.nextToken()); // 가방의 개수

        // 보석 입력 받기
        int[][] jewelry = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelry[i][0] = Integer.parseInt(st.nextToken()); // 보석의 무게
            jewelry[i][1] = Integer.parseInt(st.nextToken()); // 보석의 가격
        }

        // 가방 입력 받기
        int[] bag = new int[K];
        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        // 보석의 무게 기준 오름차순 정렬
        Arrays.sort(jewelry, Comparator.comparingInt(a -> a[0]));

        // 가방 무게 오름차순 정렬
        Arrays.sort(bag);

        // pq (가격 기준 내림차순 정렬)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long ans = 0;
        int idx = 0;

        for (int i = 0; i < K; i++) { // 모든 가방을 검사
            int bagWeight = bag[i]; // 현재 가방의 최대 무게

            // 현재 가방에 담을 수 있는 보석을 모두 pq에 추가
            while(idx < N && jewelry[idx][0] <= bagWeight) {
                pq.add(jewelry[idx][1]); // 가격만 추가
                idx++;
            }

            if(!pq.isEmpty()) {
                ans += pq.poll(); // 가방 비싼 보석만 하나 추가
            }
        }

        // 출력
        System.out.println(ans);
    }
}
