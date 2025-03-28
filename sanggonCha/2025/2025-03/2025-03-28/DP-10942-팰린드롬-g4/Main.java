import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 수열 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp 배열 생성 및 초기값 설정
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i < N; i++) {
            dp[i][i] = 1; // 1: 길이 1은 모두 팰린드롬
            if (arr[i] == arr[i + 1]) dp[i][i + 1] = 1; // 길이 2는 같은지 체크
        }
        dp[N][N] = 1; // 1: 길이 1은 모두 팰린드롬

        // dp: 길이 3 이상 처리
        for (int diagonal = 1; diagonal < N; diagonal++) { // 대각선 채우기는 N - 1개의 줄 만큼 실행
            for (int i = 1; i <= N - diagonal; i++) { // 시작은 row 1 부터 N - diagonal까지
                int j = i + diagonal;
                if (dp[i + 1][j - 1] == 1 && arr[i] == arr[j]) dp[i][j] = 1;
            }
        }

        // 출력(최적화 필요!)
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(dp[S][E]).append('\n');
        }
        System.out.print(sb);

    }
}