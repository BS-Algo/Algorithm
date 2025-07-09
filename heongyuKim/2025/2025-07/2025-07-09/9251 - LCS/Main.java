import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 좀 더 디테일한 생각하기
public class Main {
    static char[] first;
    static char[] second;

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        first = br.readLine().toCharArray();
        second = br.readLine().toCharArray();

        int firstLen = first.length;
        int secondLen = second.length;

        dp = new int[firstLen + 1][secondLen + 1];

        for (int i = 1; i <= firstLen; i++) {
            for (int j = 1; j <= secondLen; j++) {
                if (first[i - 1] == second[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[firstLen][secondLen]);
    }
}
