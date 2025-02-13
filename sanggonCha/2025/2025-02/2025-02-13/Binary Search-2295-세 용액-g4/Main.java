import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = N - 1; i >= 1; i--) { // 합으로 만들어볼 k번 째 수
            if (check(arr[i], i)) {
                System.out.println(arr[i]);
                return;
            }
        }
    }

    private static boolean check(int target, int targetI) {
        for (int i = targetI - 1; i >= 0; i--) {
            for (int j = targetI - 1; j >= 0; j--) {

                if (arr[i] + arr[j] < target) { // 두 수의 합이 target 보다 작은 경우에 실행
                    int left = 0, right = j;

                    while (left <= right) { // 세 번째 수 이분 탐색

                        int mid = (left + right) / 2;
                        int sum = arr[i] + arr[j] + arr[mid];

                        if (sum == target) {
                            return true;
                        } else if (sum < target) { // 큰 값을 탐색
                            left = mid + 1;
                        } else { // 작은 값을 탐색
                            right = mid - 1;
                        }
                    }

                }
            }
        }

        return false;
    }
}