import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 : 112840KB, 시간 : 656ms
public class Main2 {

    static int T;
    static int[][] arr;
    static int[][] dp;

    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 0;

            arr = new int[2][N];

            // arr 배열에 값 받아서 넣기
            for (int j = 0; j < 2; j++) {
                StringTokenizer info = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(info.nextToken());
                }
            }

            if (N == 1) {
                System.out.println(Math.max(arr[0][0], arr[1][0]));
                continue;
            }

            dp = new int[3][N + 1];

            // dp 배열에 값 계산해서 넣기
            for (int j = 0; j < N; j++) {
                // 이전 줄에서 아무것도 선택하지 않았을 때
                dp[0][j + 1] = Math.max(Math.max(dp[0][j], dp[1][j]), dp[2][j]);
                // 이전 줄에서 위에꺼를 선택했을 때
                dp[1][j + 1] = arr[0][j] + Math.max(dp[0][j], dp[2][j]);
                // 이전 줄에서 아래꺼를 선택했을 때
                dp[2][j + 1] = arr[1][j] + Math.max(dp[0][j], dp[1][j]);
            }

            // 최댓값 계산
            for (int j = 0; j < 3; j++) {
                answer = Math.max(answer, dp[j][N]);
            }

            result.append(answer).append("\n");
        }

        System.out.println(result.toString());
    }
}