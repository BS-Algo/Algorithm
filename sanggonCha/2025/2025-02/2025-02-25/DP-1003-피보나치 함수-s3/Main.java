import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T 입력 받기
        int T = Integer.parseInt(br.readLine());

        // DP 배열 생성
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        // 테스트 케이스 입력 받기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }

        // 출력
        System.out.println(sb);
    }
}