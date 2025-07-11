import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int K;

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer info = new StringTokenizer(br.readLine());
        N = Integer.parseInt(info.nextToken());
        K = Integer.parseInt(info.nextToken());

        dp = new int[K + 1][N + 1];

        // 숫자 0개로는 어떤 수도 만들 수 없음.
        // 1개로는 모든 수를 만들때 1의 경우의 수로 만들 수 있음.
        Arrays.fill(dp[1], 1);

        for (int i = 1; i <= K; i++) {
            dp[i][0] = 1;
        }

        // 점화식
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j]= (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
            }
        }

        System.out.println(dp[K][N]);
    }
}
