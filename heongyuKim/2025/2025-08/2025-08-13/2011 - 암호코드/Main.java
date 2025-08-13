import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
    static int[] dp;
    static int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int len = str.length();

        dp = new int[len + 1];
        dp[0] = dp[1] = 1;

        if (str.charAt(0) == '0') {
            System.out.println(0);
            return;
        } else {
            for (int i = 2; i <= len; i++) {
                // 이전
                int preC = Character.getNumericValue(str.charAt(i - 2));
                // 현재
                int curC = Character.getNumericValue(str.charAt(i - 1));

                if (curC == 0) {
                    if (preC == 1 || preC == 2) {
                        dp[i] = dp[i - 2];
                    }
                } else {
                    if (preC == 1 || (preC == 2 && curC <= 6)) {
                        dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
                    } else {
                        dp[i] = dp[i - 1];
                    }
                }

            }

            System.out.println(dp[len]);
        }
    }
}