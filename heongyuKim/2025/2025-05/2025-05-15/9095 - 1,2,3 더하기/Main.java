import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



class Main {
    static int T;

    static int[] memo = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;

        for (int i = 4; i < 11; i++) {
            recursion(i);
        }

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());

            System.out.println(memo[num]);
        }
    }

    private static void recursion(int n) {
        if (n >= 4) {
            if (memo[n - 3] == 0) recursion(n - 3);
            if (memo[n - 2] == 0) recursion(n - 2);
            if (memo[n - 1] == 0) recursion(n - 1);

            memo[n] = memo[n -1] + memo[n - 2] + memo[n - 3];
        } else {
            return;
        }
    }
}