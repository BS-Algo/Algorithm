import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, K 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 수열 입력 받기
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 초기값 설정
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        int maxSum = sum;

        // 투 포인터
        for (int i = K; i < N; i++) {
            sum += (-arr[i - K] + arr[i]);
            maxSum = Math.max(sum, maxSum);
        }

        // 출력
        System.out.print(maxSum);

    }
}