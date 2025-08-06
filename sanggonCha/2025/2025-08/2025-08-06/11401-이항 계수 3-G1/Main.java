import java.util.*;
import java.io.*;

public class Main {
    private static int P = 1000000007, p = P - 2;
    private static long answer = 1;

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 1. (N-K)!
        for (int i = N; i > N - K; i--) {
            answer = ((i % P) * answer) % P;
        }

        // 2. 페르마의 소정리: (K!)^-1 (mod P)-> (K!)^P-2 (mod P) (역원)
        // 2-1. K! (mod P)
        long k = 1;
        for (int i = K; i >= 1; i--) {
            k = ((i % P) * k) % P;
        }

        // 2-1. ((K)!)^P-2 (mod P)
        // 거듭 제곱을 통해 O(log P)로 구하기
        while (p > 0) {
            if ((p & 1) == 1) { // 1의 자리수 비트 연산: 해당 자리수가 1이라면
                answer = (answer * (k % P)) % P; // answer에 곱
            }
            // base(K)를 증가
            k = (k * k) % P;
            p = p >> 1; // 오른쪽으로 비트 쉬프트 이동
        }

        System.out.println(answer);
    }
}