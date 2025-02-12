import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine()), negativeCount  = 0;
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            if (num < 0) negativeCount ++;
        }

        if (negativeCount == 0) { // 양수만 존재하는 경우
            System.out.println(arr[0] + " " + arr[1]);
        } else if (negativeCount == N) { // 음수만 존재하는 경우
            System.out.println(arr[N - 2] + " " + arr[N - 1]);
        } else { // 양수 음수 모두 존재하는 경우 -> 이분 탐색 필요
            int left = 0, right = N - 1;
            long ans1 = 0, ans2 = 0;
            long minSum = Long.MAX_VALUE, currentSum = Long.MAX_VALUE;

            while (currentSum != 0 && left < right) {
                currentSum = arr[left] + arr[right];
                if(Math.abs(currentSum) < minSum) {
                    minSum = Math.abs(currentSum);
                    ans1 = arr[left];
                    ans2 = arr[right];
                }
                if (currentSum > 0) right--;
                else if (currentSum < 0) left++;
            }
            System.out.println(ans1 + " " + ans2);
        }
    }
}