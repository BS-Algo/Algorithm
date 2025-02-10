import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 계단 입력 받기
        int[] stair = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        // 예외 처리: 계단이 한 개만 있는 경우
        if (N == 1) {
            System.out.println(stair[1]);
            return;
        }

        // 1. 기본 세팅
        int[] DP = new int[N + 1];
        DP[1] = stair[1];
        if (N >= 2) DP[2] = stair[1] + stair[2];  // DP[1]을 다시 참조할 필요 없음

        // 2. DP
        if (N >= 3) {
            for (int n = 3; n <= N; n++) {
                DP[n] = stair[n] + Math.max(stair[n - 1] + DP[n - 3], DP[n - 2]);
            }
        }

        System.out.println(DP[N]);
    }
}