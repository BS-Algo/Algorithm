import java.io.*;
    
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 배열 입력 받기
        int[][] dp = new int[N][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        // dp
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++)
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007;
            }
        }

        // 출력
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + dp[N - 1][i]) % 10007;
        }
        System.out.println(ans);
    }
}