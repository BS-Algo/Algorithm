import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// Top-Down 방식의 DP
class Main {
    static int T;

    static Integer[][] memo = new Integer[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        memo[0][0] = 1;
        memo[0][1] = 0;
        memo[1][0] = 0;
        memo[1][1] = 1;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            fibonacci(n);
            System.out.println(memo[n][0] + " " + memo[n][1]);
        }
    }

    private static Integer[] fibonacci(int n) {
        if (memo[n][0] == null || memo[n][1] == null) {
            memo[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            memo[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }

        return memo[n];
    }
}