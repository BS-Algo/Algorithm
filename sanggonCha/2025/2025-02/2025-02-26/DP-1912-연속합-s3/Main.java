import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 배열 입력 받기
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 탐색
        int sum = arr[0], maxSum = arr[0];
        for (int i = 1; i < N; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            maxSum = Math.max(sum, maxSum);
        }

        // 출력
        System.out.println(maxSum);
    }
}