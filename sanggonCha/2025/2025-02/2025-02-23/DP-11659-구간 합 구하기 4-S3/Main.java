import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 배열 입력: dp 배열에 누적합으로 바로 저장
        st = new StringTokenizer(br.readLine());
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(st.nextToken());
            dp[i] = dp[i - 1] + input;
        }


        // 출력
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int sum = dp[j] - dp[i - 1];
            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
    }
}