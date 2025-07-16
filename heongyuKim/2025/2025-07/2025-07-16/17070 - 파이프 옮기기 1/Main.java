import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static int[][] arr;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer info = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(info.nextToken());
            }
        }

        dp = new int[N][N][3];
        dp[0][1][0] = 1;

        // 핵심은 현재의 값은 이전의 합이라고 생각하면 될듯하다.
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {

                if (arr[i][j] == 0) {
                    // 가로
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                    
                    if (i - 1 >= 0) {
                        // 세로
                        dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                        if (arr[i - 1][j] == 0 && arr[i][j - 1] == 0) {
                            // 대각선
                            dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                        }
                    }
                }
            }
        }

        System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
    }
}
