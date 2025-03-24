import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // n 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 배열 입력 받기
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 생성
        int[] dp = new int[n];
        int[] index = new int[n];

        // 초기값 설정
        for (int i = 0; i < n; i++) {
            // 최소 길이는 1
            dp[i] = 1;
            // 수열의 시작점 or 중간점 or 종점일지 알 수 없음 && -1: 수열의 시작을 의미
            index[i] = -1;
        }

        // dp
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            index[i] = -1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    index[i] = j;
                }
            }
        }

        // 최장 길이 찾기
        int maxLength = 1;
        int maxLengthIndex = 0;
        for (int i = 0; i < n; i++) {
            if (maxLength < dp[i]) {
                maxLength = dp[i];
                maxLengthIndex = i;
            }
        }

        // 최장 길이 수열 복원
        int idx = maxLength;
        int[] LIS = new int[maxLength];
        int beforeIndex = maxLengthIndex; // 직관적 이해를 위해 변수 생성
        while (beforeIndex != -1) {
            LIS[--idx] = arr[beforeIndex];
            beforeIndex = index[beforeIndex];
        }

        // 출력
        System.out.println(maxLength);
        for (int i = 0; i < maxLength; i++) {
            System.out.print(LIS[i] + " ");
        }
    }
}
