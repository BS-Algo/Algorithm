import java.io.*;

public class Main {
    static final int MOD = 1000000; // 정답이 너무 클 수 있으니까 나머지 처리

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 예외처리
        if (s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        // DP를 위한 초기값 설정
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // dp[1]을 위해 세팅 - 숫자 한 개로는 항상 생성 가능
        dp[1] = 1; // dp[i-2]를 위해 세팅

        // DP
        for (int i = 2; i <= n; i++) {
            // 1. 파란색의 경우: 숫자 하나로 표현하는 경우(항상 존제)
            int oneDigit = s.charAt(i - 1) - '0';
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] = dp[i - 1] % MOD;
            }

            // 2. 빨간색의 경우: i-1 번째 수와 i번째 수를 계산했을 떄 10 ~ 26
            int twoDigit = (s.charAt(i - 2) - '0') * 10 + oneDigit;
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
        }

        // 출력
        System.out.println(dp[n]);
    }
}