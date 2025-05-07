import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int N = Integer.parseInt(br.readLine()); // 전체 객차의 수
        StringTokenizer st = new StringTokenizer(br.readLine()); // 손님 수 입력 받기
        int[] arr = new int[N + 1]; // 부분합을 저장할 배열
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열 생성
        int[][] dp = new int[2][N + 1];

        // 초기화
        dp[0][1] = arr[1];
        dp[1][1] = arr[1];

        // dp
        int maxSum = arr[1];
        for (int j = 2; j <= N; j++) {
            dp[0][j] = Math.max(dp[0][j - 1] + arr[j], arr[j]); // 카데인 알고리즘
            dp[1][j] = Math.max(dp[0][j - 1], dp[1][j - 1] + arr[j]); // 수를 하나 제거한 경우

            maxSum = Math.max(maxSum, Math.max(dp[0][j], dp[1][j]));
        }
        System.out.println(maxSum);
    }
}