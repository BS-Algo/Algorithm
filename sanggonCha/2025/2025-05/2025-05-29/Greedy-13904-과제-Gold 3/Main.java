import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        int[][] tasks = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tasks[i][0] = Integer.parseInt(st.nextToken()); // d(과제 점수)
            tasks[i][1] = Integer.parseInt(st.nextToken()); // w(과제 마감일)
        }

        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));

//        for (int i = 0; i < N; i++) {
//            System.out.println(tasks[i][0] + " " + tasks[i][1]);
//        }

        // Greedy
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // pq에 과제 점수를 저장(오름차순)
        while (idx < N) {
            if (pq.size() < tasks[idx][1]) { // 현재 과제 마감일보다 pq의 크기가 작다면
                pq.add(tasks[idx][0]); // 추가
            } else if (pq.peek() < tasks[idx][0]) { // 기존 과제 점수보다 현재 과제 점수가 더 크몀ㄴ
                pq.poll(); // 교체
                pq.add(tasks[idx][0]); // 교체
            }

            idx++;
        }

        // 출력
        int ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        System.out.println(ans);
    }
}