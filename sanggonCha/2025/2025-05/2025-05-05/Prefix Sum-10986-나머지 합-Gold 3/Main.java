import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 변수 및 배열 생성
        long ans = 0,sum = 0;
        long[] remainderArr = new long[M]; // 나머지를 카운트할 배열

        // 수 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Long.parseLong(st.nextToken());
            int remainder = (int) (sum % M); // (sum % M) 을 반드시 괄호로 감싸야 함

            if (remainder == 0) ans++; // 길이 1인 경우는 바로 카운트

            remainderArr[remainder]++; // 누적합을 M으로 나눈 나머지를 카운트
        }

        for (int i = 0; i < M; i++) {
            if (remainderArr[i] > 0) {
                // 누적합의 나머지가 일치할 경우 나누어 떨어짐 -> 조합의 개수
                ans += remainderArr[i] * (remainderArr[i] - 1) / 2;
            }
        }

        System.out.println(ans);
    }
}