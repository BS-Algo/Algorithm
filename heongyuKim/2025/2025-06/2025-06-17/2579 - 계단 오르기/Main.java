import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());

        arr = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];

        if (N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i < N + 1; i++) {
            dp[i] = Math.max(dp[i - 3] + arr[i - 1],  dp[i - 2]) + arr[i];
        }

        System.out.println(dp[N]);
    }
}