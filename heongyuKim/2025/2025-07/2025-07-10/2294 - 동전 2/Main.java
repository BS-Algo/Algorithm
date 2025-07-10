import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;

    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer info = new StringTokenizer(br.readLine());
        N = Integer.parseInt(info.nextToken());
        K = Integer.parseInt(info.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = arr[i]; j <= K; j++) {
                if (dp[j - arr[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }

        System.out.println(dp[K] == Integer.MAX_VALUE ? -1 : dp[K]);

    }
}
