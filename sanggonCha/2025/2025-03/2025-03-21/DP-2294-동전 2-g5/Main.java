import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 동전 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 동전 입력 받기
        int[] coins = new int[n + 1];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // dp 배열 생성
        int[] dp = new int[k + 1];
        Arrays.fill(dp, k + 1); // 만들 수 없는 경우 판별을 위해 k에서 +1
        dp[0] = 0; // 각 동전으로 자기 자신을 만드는 최소 개수가 1로 초기화

        // dp
        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // 출력
        System.out.println(dp[k] == k + 1 ? -1 : dp[k]);
    }
}