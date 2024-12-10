import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            arr[i][0] = x;
            arr[i][1] = y;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
//        // 버블 정렬
//        int tempX = 0, tempY = 0;
//        for (int i = n - 1; i > 0; i--) {
//            for (int j = 0; j < i; j++) {
//                if (arr[j][0] > arr[j + 1][0]) {
//                    tempX = arr[j][0];
//                    tempY = arr[j][1];
//                    arr[j][0] = arr[j + 1][0];
//                    arr[j][1] = arr[j + 1][1];
//                    arr[j + 1][0] = tempX;
//                    arr[j + 1][1] = tempY;
//                }
//            }
//        }

        // 최대값 구하기
        int maxY = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][1] > maxY) {
                maxY = arr[i][1];
            }
        }

        // 왼쪽 최대값 인덱스 구하기
        int maxLX = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][1] == maxY) {
                maxLX = i;
                break;
            }
        }

        // 오른쪽 최대값 인덱스 구하기
        int maxRX = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i][1] == maxY) {
                maxRX = i;
                break;
            }
        }
//        System.out.printf("maxLX: %d, maxRX: %d maxY: %d\n", maxLX, maxRX, maxY);
//        System.out.printf("arr[maxLX][1]: %d = arr[maxRX][1]: %d = maxY: %d\n", arr[maxLX][1], arr[maxRX][1], maxY);

        int ans = 0;

        // 왼쪽 -> 최고 높이
        int beforeX = 0;
        int beforeY = 0;
        int lX = 0;
        for (lX = 0; lX <= maxLX; lX++) {
            int x = arr[lX][0];
            int y = arr[lX][1];

            // 새로운 최고 높이가 나오면 누적합
            if (y > beforeY) {
                ans += beforeY * (x - beforeX);
                beforeY = y;
                beforeX = x;
            }
        }
//        System.out.printf("왼쪽 합: %d\n", ans);

        // 오른쪽 -> 최고 높이
        beforeX = 0;
        beforeY = 0;
        int rX = 0;
        for (rX = n - 1; rX >= maxRX; rX--) {
            int x = arr[rX][0];
            int y = arr[rX][1];

            // 새로운 최고 높이가 나오면 누적합
            if (y > beforeY) {
                ans += beforeY * (beforeX - x);
                beforeY = y;
                beforeX = x;
            }
        }
//        System.out.printf("오른쪽 합: %d\n", ans);


        // 최고 높이가 여러 개일 경우 보정
        if (maxLX != maxRX) {
            ans += (arr[maxRX][0] - arr[maxLX][0] + 1) * maxY;
        } else {
            ans += maxY;
        }
//        System.out.printf("최고높이 합: %d\n", ans);
        System.out.println(ans);
    }
}