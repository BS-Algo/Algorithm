import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        N = Integer.parseInt(br.readLine());

        // 용액 입력 받기
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        // 탐색
        search();
    }

    private static void search() {
        long minSum = Long.MAX_VALUE; // 최대값으로 초기화
        long[] ans = new long[3]; // 최적값을 저장할 배열

        for (int first = 0; first < N - 2; first++) { // 1. 첫 번째 용액을 고정

            // 2. 나머지 두 용액을 이중 포인터 탐색
            int second = first + 1, third = N - 1;

            while (second < third) {
                long sum = arr[first] + arr[second] + arr[third];

                // 최소값 갱신
                if (Math.abs(sum) < minSum) {
                    minSum = Math.abs(sum);
                    ans[0] = arr[first];
                    ans[1] = arr[second];
                    ans[2] = arr[third];
                }

                if (sum > 0) {
                    third--;
                } else if (sum < 0) {
                    second++;
                } else {
                    System.out.println(arr[first] + " " + arr[second] + " " + arr[third]);
                    return;
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}