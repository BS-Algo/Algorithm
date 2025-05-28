import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine()); // 센서의 개수
        int K = Integer.parseInt(br.readLine()); // 집중국의 개수

        // 집중국 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sensors = new int[N];
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        if (K >= N) System.out.println(0); // 집중국의 개수 >= 센서의 개수(각각 1개씩 배치 -> 최소 거리 0)
        else {
            // 집중국 거리 오름차순 정렬
            Arrays.sort(sensors);

            // 센서 사이의 거리를 내림차순으로 정렬
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 1; i < N; i++) {
                pq.add(sensors[i] - sensors[i - 1]); // 모두 추가
            }

            // 기본값은 최대 거리
            int ans = sensors[N - 1] - sensors[0];

            // 집중국은 K개 -> K-1개의 센서 사이 거리를 제외 시킬 수 있음
            while (K-- > 1) {
                ans -= pq.poll();
            }

            // 출력
            System.out.println(ans);
        }
    }
}
