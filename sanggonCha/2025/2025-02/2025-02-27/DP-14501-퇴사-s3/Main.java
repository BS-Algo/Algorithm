import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 금액 입력 받기
        int[] time = new int[N + 1];
        int[] fee = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            fee[i] = Integer.parseInt(st.nextToken());
        }

        // dp
        int[] dp = new int[N + 2];
        for (int i = N; i >= 1; i--) {
            if (i + time[i] <= N + 1) { // 마지막 날까지 끝나는 상담 = 접수가 가능한 상담: 최댓값으로 갱신
                // 현재의 최대 이익 =
                // 바로 전 날까지의 최대 이익 vs 현재 상담이 끝나는 날까지의 최대 이익 + 현재 상담을 접수 했을 때의 이익
                dp[i] = Math.max(dp[i + 1], dp[i + time[i]] + fee[i]);
            } else { // 접수가 불가능한 상담: 이전의 최대 이익을 그대로 복사
                dp[i] = dp[i + 1];
            }
        }

        // 출력
        System.out.println(dp[1]);
    }
}