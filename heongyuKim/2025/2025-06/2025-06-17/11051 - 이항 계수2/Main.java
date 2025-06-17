import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파스칼의 삼각형
public class Main {
    static int N;
    static int K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        K = Integer.parseInt(info.nextToken());

        dp = new int[1001][1001];

        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i][i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
            }
        }

        System.out.println(dp[N][K]);
    }
}