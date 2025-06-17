import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 데드라인 오름차순 정렬, 보상 내림차순 정렬
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // 보상 내림차순
            }
            return a[0] - b[0]; // 데드라인 오름차순
        });

        // greedy
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] cur : arr) { // 모든 숙제를 살펴보면서, 보상이 가장 큰 것들만 남기기
            pq.offer(cur[1]); // 보상을 추가
            if(pq.size() > cur[0]) { // 현재 숙제의 마감기한보다 pq가 크다면
                pq.poll(); // 가장 작은 보상을 제거
            }
        }

        // 출력
        int ans = 0;
        for (int compensation : pq) {
            ans += compensation;
        }
        System.out.println(ans);
    }
}