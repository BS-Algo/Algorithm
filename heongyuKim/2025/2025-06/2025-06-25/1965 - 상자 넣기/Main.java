import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 복잡도 : N * (N - 1) / 2
class Main {
    static int N;

    static int[] arr;
    static int[] dp;

    static int result = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        StringTokenizer info = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(info.nextToken());
        }

        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 만약 모든 앞의 상자보다 작다면 1처리 해주기
            if (dp[i] == 0) {
                dp[i] = 1;
            }

            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}