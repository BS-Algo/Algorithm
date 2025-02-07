import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 예산요청 입력 받기
        int[] request = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            request[i] = Integer.parseInt(st.nextToken());
        }

        // 국가예산
        int M = Integer.parseInt(br.readLine());

        int left = 1, right = M;

        // 이분 탐색
        int[] result = new int[N];
        while (left <= right) {
            int maxBudget = (left + right) / 2;
            long totalBudget = 0;

            // 지방 예산 배정
            for (int i = 0; i < N; i++) {
                int budget = Math.min(request[i], maxBudget);
                result[i] = budget;
                totalBudget += budget;
            }

            if (totalBudget > M) { // 총 예산을 초과한 경우
                right = maxBudget - 1;
            } else { // 총 예산을 초과하지 않은 경우
                left = maxBudget + 1;
            }
        }

        // 지방 예산 배정
        for (int i = 0; i < N; i++) {
            int budget = Math.min(request[i], right);
            result[i] = budget;
        }

        int ans = 0;
        for(int i = 0;i<N;i++) {
            ans = Math.max(result[i], ans);
        }
        System.out.println(ans);
    }
}