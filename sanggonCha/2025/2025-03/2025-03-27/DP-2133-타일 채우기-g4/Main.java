import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // dp 배열 생성 및 초기값 설정
        int[] dp = new int[N + 1];
        dp[0] = 1; // dp[4] = 11 인데, 그것을 위한 설정
        if (N > 1) dp[2] = 3;

        // dp
        for (int i = 4; i <= N; i += 2) {
            // dp[i] = dp[i-2] * 3
            dp[i] = dp[i - 2] * 3;

            // dp[i] = dp[i-4] * 2 + dp[i-6] * 2 + ...
            for (int j = 4; j <= i; j += 2) {
                dp[i] += dp[i - j] * 2;
            }
        }

        // 출력
        System.out.println(dp[N]);
    }
}