import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 빈 배열 만들기
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] array = new int[row + 1][col + 1];
        int[][] dp = new int[row + 1][col + 1];

        // dp 누적 합 계산
        for (int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= col; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = array[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }

        // dp를 이용하여 범위 합 구하기
        int range = Integer.parseInt(br.readLine());

        for (int k = 0; k < range; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = dp[x][y] - dp[i-1][y] - dp[x][j-1] + dp[i-1][j-1];
            System.out.println(result);

        }

    }
}
