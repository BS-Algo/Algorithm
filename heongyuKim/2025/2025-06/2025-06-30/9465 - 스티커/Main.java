import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 처음에 풀었던 방법
// 메모리 : 111816KB, 시간 : 660ms
public class Main {

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

            arr = new int[2][N + 1];
            dp = new int[2][N + 1];

            // arr 배열에 값 받아서 넣기
            for (int j = 0; j < 2; j++) {
                StringTokenizer info = new StringTokenizer(br.readLine());
                for (int k = 1; k <= N; k++) {
                    arr[j][k] = Integer.parseInt(info.nextToken());
                }
            }

            if (N == 1) {
                System.out.println(Math.max(arr[0][1], arr[1][1]));
                continue;
            }

            // dp 초기 세팅
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];


            // dp 배열에 값 계산해서 넣기
            for (int j = 2; j <= N; j++) {
                for (int k = 0; k < 2; k++) {
                    if (k == 0) {
                        dp[k][j] = arr[k][j] + Math.max(dp[k + 1][j - 1], dp[k + 1][j - 2]);
                    } else {
                        dp[k][j] = arr[k][j] + Math.max(dp[k - 1][j - 1], dp[k - 1][j - 2]);
                    }

                    answer = Math.max(dp[k][j], answer);
                }
            }

            result.append(answer).append("\n");
        }

        System.out.println(result.toString());
    }
}