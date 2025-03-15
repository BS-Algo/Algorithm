import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // Pi 입력 받기
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        // dp
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j + i <= N; j++) {
                dp[j + i] = Math.max(dp[j + i], dp[i] + dp[j]);
            }
            for (int j = 1; i * j < N + 1; j++) {
                dp[j * i] = Math.max(dp[j * i], dp[i] * j);
            }

        }

        // 출력
        System.out.println(dp[N]);
    }
}