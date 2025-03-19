import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T, W 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // 자두 입력 받기
        int[] plum = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            plum[i] = Integer.parseInt(br.readLine());
        }

        // DP
        int[][] dp = new int[T + 1][W + 1];
        for (int t = 1; t <= T; t++) {

            for (int w = 0; w <= W; w++) {
                // 시작 위치: 1 / 홀수번 이동 후 위치: 2 / 짝수번 이동 후 위치: 1
                int position = (w % 2 == 0) ? 1 : 2;

                if (plum[t] == position) { // 자두가 현재 위치에 떨어지면
                    dp[t][w] = dp[t - 1][w] + 1; // 이전 시간의 값에서 1 증가
                } else {
                    dp[t][w] = dp[t - 1][w]; // 이전 시간의 값을 유지
                }

                if (w > 0) { // 1번 이상 이동한 경우라면,
                    // 이미 이동한 적 있는 결과의 최댓값 vs 이동하기 직전 시간의 최댓값 + 1(지금 이동하면서 발생하는 자두) 
                    dp[t][w] = Math.max(dp[t][w], dp[t - 1][w - 1] + (plum[t] == position ? 1 : 0));
                }
            }
        }

        // 출력
        int ans = 0;
        for (int w = 0; w <= W; w++) {
            ans = Math.max(ans, dp[T][w]);
        }
        System.out.println(ans);
    }
}