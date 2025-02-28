import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T 입력 받기
        int T = Integer.parseInt(br.readLine());

        // dp
        long[] dp = new long[1000000];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < 1000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }

        // 출력
        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            System.out.println(dp[input - 1]);
        }
    }
}