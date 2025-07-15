import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static int[][] arr;
    static int[] dp;

    static int line = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        arr = new int[N][2];
        dp = new int[N];
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            StringTokenizer info = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(info.nextToken());
            arr[i][1] = Integer.parseInt(info.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 1; i < N ; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j][1] < arr[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
            line = Math.max(line, dp[i]);
        }

        System.out.println(N - line);
    }
}
