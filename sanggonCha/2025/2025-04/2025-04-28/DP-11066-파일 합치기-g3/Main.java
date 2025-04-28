import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            int K = Integer.parseInt(br.readLine());
            int[] files = new int[K + 1];
            int[] sum = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 파일 크기 입력 받기
            for (int i = 1; i <= K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + files[i];
            }

            // DP
            for (int length = 2; length <= K; length++) {
                for (int start = 1; start <= K - length + 1; start++) {
                    int end = start + length - 1;

                    dp[start][end] = Integer.MAX_VALUE; // 최대값으로 초기화

                    for (int divLine = start; divLine < end; divLine++) {// 자르는 기준 점
                        // length 안에서 가능한 길이로 모두 잘라보고 최대값으로 갱신
                        dp[start][end] = Math.min(dp[start][end], dp[start][divLine] + dp[divLine + 1][end] + sum[end] - sum[start - 1]);
                    }
                }
            }

            // 출력
            System.out.println(dp[1][K]);
        }
    }
}