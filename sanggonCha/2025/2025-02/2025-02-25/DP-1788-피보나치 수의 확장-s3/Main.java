import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        if (N > 0) {
            int[] dp = new int[N + 1];
            dp[1] = 1;
            for (int i = 2; i <= N; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
            }
            if (dp[N] > 0) {
                System.out.println(1);
            } else if (dp[N] < 0) {
                System.out.println(-1);
            } else {
                System.out.println(0);
            }
            System.out.println(Math.abs(dp[N]));
        } else if (N < 0) {
            int[] dp = new int[-N + 1];
            dp[1] = 1;
            for (int i = 2; i <= -N; i++) {
                dp[i] = (dp[i - 2] - dp[i - 1]) % 1000000000;
            }
            if (dp[-N] > 0) {
                System.out.println(1);
            } else if (dp[-N] < 0) {
                System.out.println(-1);
            } else {
                System.out.println(0);
            }
            System.out.println(Math.abs(dp[-N]));
        } else {
            System.out.println(0);
            System.out.println(0);
        }
    }
}