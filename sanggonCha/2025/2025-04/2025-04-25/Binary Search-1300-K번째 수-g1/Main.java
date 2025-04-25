import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, K 입력 받기
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        // 이분 탐색
        long ans = 0;
        long left = 1;
        long right = (long) N * N;

        while (left <= right) {
            long cnt = 0;
            long mid = (left + right) / 2; // 임의의 수라고 추정(이 값이 배열 A에 존재하는지 존재하지 않는지 아직 모름)

            for (long i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if (cnt < K) left = mid + 1;
            else {
                ans = mid; // cnt == k 인 경우도 포함하고 있음 -> 이때부터 이미 정답일 수도 있으므로 ans에 일단 옮겨담기
                right = mid - 1; 
                // 현재 추정한 값은 배열 A에 포함된 값인지 아닌지 확실하지가 않다. 
                // 그러나 cnt += Math.min(mid / i, N); 부분에 의해서
                // 추정한 mid 값이 배열 A에 포함된 값이라면, 인덱스 K보다 더 큰 값이 나온다
                // 그래서 다시 한 번 else 조건을 거치게 되고, 결국 while문을 탈출하면서 종료된다.
            }
        }

        System.out.println(ans);
    }
}