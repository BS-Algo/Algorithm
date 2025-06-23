import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 처음에 작성한 비효율적인 코드
public class Main2 {
    static int N;
    static int M;

    static int[][] arr;
    static int[][] dp;

    // 오른쪽, 아래, 대각선
    static int[] dx = new int[] {0, 1, 1};
    static int[] dy = new int[] {1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        arr = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer nums = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                arr[i][j] = Integer.parseInt(nums.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int q = 0; q < 3; q++) {
                    int nx = i + dx[q];
                    int ny = j + dy[q];

                    dp[nx][ny] = Math.max(dp[nx][ny], dp[i][j] + arr[nx][ny]);
                }
            }
        }

        // 마지막 세로줄
        for (int i = 1; i < N; i++) {
            dp[i + 1][M] = Math.max(dp[i + 1][M], dp[i][M] + arr[i + 1][M]);
        }

        // 마지막 가로줄
        for (int i = 1; i < M; i++) {
            dp[N][i + 1] = Math.max(dp[N][i + 1], dp[N][i] + arr[N][i + 1]);
        }

        System.out.println(dp[N][M]);
    }
}