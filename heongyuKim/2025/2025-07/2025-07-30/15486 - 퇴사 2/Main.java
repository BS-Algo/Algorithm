import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
    static int N;

    static int[][] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 2][2];
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer info = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(info.nextToken());
            arr[i][1] = Integer.parseInt(info.nextToken());
        }

        int max = -1;
        for (int i = 1; i <= N + 1; i++) {
            // 현재까지의 최대 이익 갱신
            if (max < dp[i]) max = dp[i];

            int next = i + arr[i][0];
            int price = arr[i][1];

            if (next < N + 2) {
                // 다른 상담을 통한 이익과 현재 상담을 선택했을 때의 이익 중에서 큰 것으로 갱신
                dp[next] = Math.max(dp[next], max + price);
            }
        }
        
        System.out.println(dp[N + 1]);
    }
}