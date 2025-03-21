import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력 받기
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // DP
        int[] dp = new int[N + 1];
        dp[0] = 1; // 안 하면 VIP석이 연속으로 있을 때 답이 0 나옴!
        dp[1] = 1;
        if (N >= 2) dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // VIP석 입력 받기
        int ans = 1, before = 0, vip;
        for (int i = 0; i < M; i++) {
            vip = Integer.parseInt(br.readLine());
            ans *= dp[vip - before - 1];
            before = vip;
        }
        ans *= dp[N - before];

        System.out.println(ans);
    }
}
