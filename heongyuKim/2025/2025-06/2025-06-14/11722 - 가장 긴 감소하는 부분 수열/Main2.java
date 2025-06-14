import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 탑 - 다운
public class Main2 {
    static int N;

    static int[] arr;
    static int[] dp;

    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];

        StringTokenizer info = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(info.nextToken());
            dp[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            result = Math.max(result, memo(i));
        }

        System.out.println(result);
    }

    private static int memo(int idx) {
        if (dp[idx] != -1) return dp[idx];

        dp[idx] = 1;

        for (int next = idx + 1; next < N; next++) {
            if (arr[idx] > arr[next]) {
                dp[idx] = Math.max(dp[idx], memo(next) + 1);
            }
        }

        return dp[idx];
    }
}