import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            // 동전 입력 받기
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[N];
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            // 목표 금액 입력 받기
            int target = Integer.parseInt(br.readLine());
            int[] dp = new int[target + 1];
            dp[0] = 1; // 자기 자신의 금액을 만드는 케이스

            // DP
            for (int coin : coins) {
                for (int i = coin; i <= target; i++) {
                    dp[i] += dp[i - coin];
                }
            }

            // 출력
            System.out.println(dp[target]);
        }
    }
}