import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 수열 입력 받기
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        // 초기값 설정
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = arr[i];
        }

        // DP 수행 (앞에서부터 진행)
        int maxSum = dp[0];
        for (int now = 1; now < N; now++) { // 현재 위치
            for (int before = 0; before < now; before++) { // 이전 위치
                if (arr[before] < arr[now]) { // 증가하는 부분 수열 조건
                    dp[now] = Math.max(dp[now], dp[before] + arr[now]);
                }
            }
            maxSum = Math.max(maxSum, dp[now]); // 최대값 갱신
        }


        // 출력
        System.out.println(maxSum);
    }
}
