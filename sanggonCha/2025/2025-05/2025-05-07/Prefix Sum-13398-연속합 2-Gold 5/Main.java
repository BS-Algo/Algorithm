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
        // [0][j]: 수를 제거 하지 않은 경우 / [1][j]: 수를 제거 한 경우
        int[][] dp = new int[2][N + 1];

        // dp
        // 1. 수를 제거 하지 않은 경우의 최댓값
        dp[0][1] = arr[1]; // 처음값으로 초기화
        for (int j = 2; j <= N; j++) {
            dp[0][j] = Math.max(dp[0][j - 1] + arr[j], arr[j]); // 누적합 vs 새로 시작
        }

        // 2. 수를 제거 하는 경우의 최댓값
        int maxSum = arr[1];
        dp[1][1] = arr[1];
        for (int j = 2; j <= N; j++) {
            if (arr[j] < 0) {
                dp[1][j] = Math.max(dp[0][j - 1], dp[1][j - 1] + arr[j]);
            } else {
                dp[1][j] = Math.max(dp[0][j], dp[1][j - 1] + arr[j]); // 누적합 vs 새로 시작
            }
            maxSum = Math.max(maxSum, Math.max(dp[0][j], dp[1][j]));
        }

        // for (int i = 0; i < 2; i++) {
        //     for (int j = 1; j <= N; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(maxSum);
    }
}