import java.io.*;
import java.util.*;

public class Main {
    private static long cnt = 0;
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        N = Integer.parseInt(br.readLine());

        // 수 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        // 탐색
        for (int i = 0; i < N; i++) {
            if (leftCheck(arr[i], i - 1) ||
                    rightCheck(arr[i], i + 1) ||
                    doubleCheck(arr[i], i - 1, i + 1)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean leftCheck(int num, int r) {
        if (r < 1) return false;

        int l = 0;

        while (l < r) {
            int sum = num - (arr[l] + arr[r]);

            if (sum > 0) { // 두 수가 더 작은 경우
                l++;
            } else if (sum < 0) { // 두 수가 더 큰 경우
                r--;
            } else { // 일치하는 경우
                return true;
            }
        }
        return false;
    }

    private static boolean rightCheck(int num, int l) {
        if (l > N - 2) return false;

        int r = N - 1;

        while (l < r) {
            int sum = num - (arr[l] + arr[r]);

            if (sum > 0) { // 두 수가 더 작은 경우
                l++;
            } else if (sum < 0) { // 두 수가 더 큰 경우
                r--;
            } else { // 일치하는 경우
                return true;
            }
        }
        return false;
    }

    private static boolean doubleCheck(int num, int leftR, int rightL) {
        if (leftR == -1 || rightL == N) return false;

        while (leftR > -1 && rightL < N) {
            int sum = num - (arr[leftR] + arr[rightL]);

            if (sum > 0) { // 두 수가 더 작은 경우
                rightL++;
            } else if (sum < 0) { // 두 수가 더 큰 경우
                leftR--;
            } else { // 일치하는 경우
                return true;
            }
        }
        return false;
    }
}
