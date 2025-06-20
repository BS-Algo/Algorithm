import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// top-down 방식을 구현해보는 문제
public class Main {
    static int[][][] dp = new int[21][21][21];
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer info = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(info.nextToken());
            int B = Integer.parseInt(info.nextToken());
            int C = Integer.parseInt(info.nextToken());

            if (A == -1 && B == -1 && C == -1) {
                break;
            }

            int resultNum = topDown(A, B, C);

            result.append("w(").append(A).append(", ").append(B).append(", ").append(C).append(") = ").append(resultNum).append("\n");
        }

        System.out.println(result.toString());
    }

    private static int topDown(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) return 1;

        if (a > 20 || b > 20 || c > 20) return topDown(20, 20, 20);

        if (dp[a][b][c] > 0) {
            return dp[a][b][c];
        }

        if (a < b && b < c) {
            dp[a][b][c] = topDown(a, b, c-1) + topDown(a, b - 1, c - 1) - topDown(a, b - 1, c);
            return dp[a][b][c];
        }

        dp[a][b][c] = topDown(a - 1, b, c) + topDown(a - 1, b - 1, c) + topDown(a - 1, b, c - 1) - topDown(a - 1, b - 1, c - 1);

        return dp[a][b][c];
    }
}