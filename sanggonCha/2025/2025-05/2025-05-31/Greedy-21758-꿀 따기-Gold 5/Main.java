import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine()); // 원생의 수

        // 꿀 입력
        int[] honey = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합 계산
        int[] accSum = new int[N];
        accSum[0] = honey[0];
        for (int i = 1; i < N; i++) {
            accSum[i] = honey[i] + accSum[i - 1];
        }

        int maxHoney = 0;

        // 그리디가 아니라 브루트포스 아닌가..?

        // case 1: 꿀통 0번, 벌 (i, N-1)번
        for (int i = 1; i < N - 1; i++) {
            maxHoney = Math.max(maxHoney, accSum[i - 1] + accSum[N - 2] - honey[i]);
        }

        // case 2: 벌 0번, 꿀통 i(1 ~ N-2)번, 벌 N-1번
        for (int i = 1; i < N - 1; i++) {
            maxHoney = Math.max(maxHoney, accSum[i] - honey[0] + accSum[N - 2] - accSum[i - 1]);
        }

        // case 3: 벌 (0, i)번, 꿀통 N-1번
        for (int i = 1; i < N - 1; i++) {
            maxHoney = Math.max(maxHoney, accSum[N - 1] - honey[0] - honey[i] + accSum[N - 1] - accSum[i]);
        }

        // 출력
        System.out.println(maxHoney);
    }
}