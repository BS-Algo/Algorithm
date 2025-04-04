import java.io.*;

public class Main {
    static final int MOD = 1000000; // 정답이 너무 클 수 있으니까 나머지 처리

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // dp
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (isSquare(i)) dp[i] = 1;
            else {
                dp[i] = i;
                for (int j = 1; j <= i / 2; j++) {
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }
            }
        }

        // 출력
        System.out.println(dp[n]);
    }

    private static boolean isSquare(int i) {
        int j = (int) Math.sqrt(i);

        return j * j == i;
    }
}
