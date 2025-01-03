import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수열의 길이
        int sequenceLength = Integer.parseInt(br.readLine());

        // 수열을 담을 배열
        int[][] dp = new int[3][sequenceLength];

        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0][0] = Integer.parseInt(st.nextToken());
        dp[1][0] = 1;
        dp[2][0] = 1;

        for (int j = 1; j < sequenceLength; j++) {
            dp[0][j] = Integer.parseInt(st.nextToken());
            if (dp[0][j] > dp[0][j - 1]) {
                dp[1][j] = dp[1][j - 1] + 1;
                dp[2][j] = 1;
            } else if (dp[0][j] < dp[0][j - 1]) {
                dp[2][j] = dp[2][j - 1] + 1;
                dp[1][j] = 1;
            } else if (dp[0][j] == dp[0][j - 1]) {
                dp[1][j] = dp[1][j - 1] + 1;
                dp[2][j] = dp[2][j - 1] + 1;
            }
        }

        int incrementMax = Arrays.stream(dp[1]).max().getAsInt();
        int decrementMax = Arrays.stream(dp[2]).max().getAsInt();

        System.out.println(Math.max(incrementMax, decrementMax));

    }
}