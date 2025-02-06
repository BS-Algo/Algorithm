// https://velog.io/@yg9618/%EC%9D%B4%EB%B6%84-%ED%83%90%EC%83%89

import java.io.*;
import java.util.*;

public class Main {
    private static int i, left, right, mid;
    private static StringTokenizer st;
    private static boolean isFind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // A, B 입력 받기
        String[] AB = br.readLine().split(" ");
        int A = Integer.parseInt(AB[0]);
        int B = Integer.parseInt(AB[1]);

        // 집합 A 입력 받기
        st = new StringTokenizer(br.readLine());
        int[] setA = new int[A];
        for (i = 0; i < A; i++) {
            setA[i] = Integer.parseInt(st.nextToken());
        }


        // 집합 B 입력 받기
        st = new StringTokenizer(br.readLine());
        int[] setB = new int[B];
        for (i = 0; i < B; i++) {
            setB[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(setA);

        // A - B
        int cnt = 0;
        boolean[] tfA = new boolean[A];
        for (i = 0; i < B; i++) {
            left = 0;
            right = A - 1;
            isFind = false;

            while (left <= right) {
                mid = (left + right) / 2;
                if (setB[i] == setA[mid]) {
                    isFind = true;
                    tfA[mid] = true;
                    break;
                } else if (setB[i] < setA[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (isFind) {
                cnt++;
            }
        }

        // 출력
        System.out.println(A - cnt); // 크기
        StringBuilder sb = new StringBuilder();
        if (A - cnt > 0) {
            for (i = 0; i < A; i++) { // 집합 A의 원소
                if (!tfA[i]) {
                    sb.append(setA[i]).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }
}