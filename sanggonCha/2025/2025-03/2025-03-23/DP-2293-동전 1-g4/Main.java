import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // n, k 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 동전 입력 받기
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // dp 배열 및 초기값 세팅
        long[] dp = new long[k + 1];
        dp[0] = 1;

        // dp
        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] += dp[i - coin];
            }
        }

        // 출력
        System.out.println(dp[k]);
    }
}
