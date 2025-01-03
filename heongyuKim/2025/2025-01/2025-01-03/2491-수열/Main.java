import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수열의 길이
        int sequenceLength = Integer.parseInt(br.readLine());

        // 수열을 담을 배열
        int[] dp = new int[sequenceLength];

        // 연속해서 커지는 구간을 나타낼 배열
        int[] incrementArr = new int[sequenceLength];
        Arrays.fill(incrementArr, 1);

        // 연속해서 작아지는 구간을 나타낼 배열
        int[] decrementArr = new int[sequenceLength];
        Arrays.fill(decrementArr, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sequenceLength; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 1; j < sequenceLength; j++) {
            if (dp[j] > dp[j - 1]) {
                incrementArr[j] = incrementArr[j - 1] + 1;
            } else if (dp[j] < dp[j - 1]) {
                decrementArr[j] = decrementArr[j - 1] + 1;
            } else if (dp[j] == dp[j - 1]) {
                decrementArr[j] = decrementArr[j - 1] + 1;
                incrementArr[j] = incrementArr[j - 1] + 1;
            }
        }

        int incrementMax = Arrays.stream(incrementArr).max().getAsInt();
        int decrementMax = Arrays.stream(decrementArr).max().getAsInt();

        System.out.println(Math.max(incrementMax, decrementMax));

    }
}