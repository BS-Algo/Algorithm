import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열 입력 받기
        char[] seriesA = br.readLine().toCharArray();
        char[] seriesB = br.readLine().toCharArray();

        // DP?
        int lA = seriesA.length;
        int lB = seriesB.length;
        int[][] dp = new int[lA + 1][lB + 1]; // 길이만 구하면 되기에 값만 저장하면 된다
        for (int i = 1; i <= lA; i++) {
            for (int j = 1; j <= lB; j++) {
                if (seriesA[i-1] == seriesB[j-1]) dp[i][j] = dp[i - 1][j - 1] + 1; // 길이 증가!
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 이전 길이 중 최대 길이로 갱신
            }
        }

        // 출력
        System.out.println(dp[lA][lB]);
    }
}
