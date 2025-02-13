import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        N = Integer.parseInt(br.readLine());

        // 용액 입력 받기
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 탐색
        int l = 0, r = N - 1, minSum = 1000000000, ans = 0;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                ans = sum;
            }
            if (sum < 0) {
                l++;
            } else if (sum > 0) {
                r--;
            } else {
                ans = 0;
                break;
            }
        }

        System.out.println(ans);
    }
}