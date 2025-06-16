import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 처음에는 단순히 아래 코드처럼 최대 제곱수로 뺀 다음 나머지 값을 이전 dp 배열의 값을 더해서 결과를 구하려고 했지만
// 12와 같은 반례에 걸려서 틀렸음.
public class Main2 {

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
            arr[i] = i;
        }

        if (N < 4) {
            System.out.println(arr[N]);
            return;
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i < N + 1; i++) {
            int num = arr[i];

            if ((int) Math.sqrt(num) * (int) Math.sqrt(num) == num) {
                dp[i]= 1;
                continue;
            }

            num -= (int) Math.sqrt(num) * (int) Math.sqrt(num);

            dp[i]++;
            dp[i] += dp[num];
        }

        System.out.println(dp[N]);
    }
}