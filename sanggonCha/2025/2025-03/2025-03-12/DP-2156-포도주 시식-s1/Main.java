import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 배열 생성
        int[] arr = new int[N];
        int[] dp = new int[N];

        // 배열 입력 받기
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // DP
        if (N == 1) System.out.println(arr[0]);
        else if (N == 2) System.out.println(arr[0] + arr[1]);
        else if (N == 3) System.out.println(Math.max(arr[0] + arr[2], Math.max(arr[0] + arr[1], arr[1] + arr[2])));
        else {
            dp[0] = arr[0];
            dp[1] = arr[0] + arr[1];
            dp[2] = Math.max(arr[0] + arr[2], Math.max(dp[1], arr[1] + arr[2]));

            for (int i = 3; i < N; i++) {
                dp[i] = Math.max(dp[i-1], Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i]);
            }

            System.out.println(dp[N-1]);
        }
    }
}
