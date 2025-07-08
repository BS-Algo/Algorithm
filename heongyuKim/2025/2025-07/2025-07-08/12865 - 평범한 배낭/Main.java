import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배낭에 물건을 넣는다 넣지 않는다까지는 생각을 했지만 
// 큰 문제를 작은 문제로 나누는 연습이 더 필요할 듯하다.
// 복습 필요한 문제
public class Main {
    static int N; // 물품의 수
    static int K; // 최대 무게

    static int[] weight; // 물건의 무게 배열
    static int[] value; // 물건의 가치 배열

    static int[][] dp; // dp 테이블
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        K = Integer.parseInt(info.nextToken());

        weight = new int[N + 1];
        value = new int[N + 1];
        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer sack = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(sack.nextToken());
            value[i] = Integer.parseInt(sack.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                // 현재 배낭의 최대 무게보다 무겁다면 - 물건을 넣지 않는다
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
