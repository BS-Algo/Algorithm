import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연속합을 끊을지 아니면 이어나갈지에 대한 로직이 핵심이다.
public class Main {
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
        }

        dp[0] = arr[0];
        result = Math.max(dp[0], result);

        // dp 배열에 누적합 계산해서 넣기 - 단, 배열의 값과 누적합을 비교하여 더 큰 값을 할당하기
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}