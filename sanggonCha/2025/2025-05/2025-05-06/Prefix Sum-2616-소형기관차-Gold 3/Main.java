import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int N = Integer.parseInt(br.readLine()); // 전체 객차의 수
        StringTokenizer st = new StringTokenizer(br.readLine()); // 손님 수 입력 받기
        int[] prefixSum = new int[N + 1]; // 부분합을 저장할 배열
        for (int i = 1; i <= N; i++) {
            int passenger = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + passenger;
        }
        int K = Integer.parseInt(br.readLine()); // 소형 기관차가 끌 수 있는 객차의 수

        // DP 배열 생성
        int[][] dp = new int[4][N + 1];

        // dp
        for (int i = 1; i <= 3; i++) {
            for (int j = i * K; j <= N; j++) {
                int sectionSum = prefixSum[j] - prefixSum[j - K]; // 현재 고려할 연속된 객차(j-K ~ j)

                // 1. i개의 연속된 객차를 선택했을 때의 이전의 최댓값
                // 2. i-1개의 연속된 객차를 선택했을 때의 j-K만큼 이전의 최댓값 + 현재 고려할 연속된 객차의 승객수
                // 둘 중 더 큰 값으로 갱신
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - K] + sectionSum);
            }
        }

        System.out.println(dp[3][N]); // 최종적으로 갱신된 최댓값이 정답
    }
}