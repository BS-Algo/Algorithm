import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static long cnt = 0L;
    private static long[] A, B, C, D;
    private static Map<Long, Long> hashMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력
        // N 입력 받기
        N = Integer.parseInt(br.readLine());

        // 배열 입력 받기
        A = new long[N];
        B = new long[N];
        C = new long[N];
        D = new long[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 배열 C + D를 해시 맵에 저장
        makeHashMap();

        // 3. 해시 맵에서 -(A + B)를 찾아서 카운트
        countZeroSums();

        // 4. 출력
        System.out.println(cnt);

    }

    private static void makeHashMap() {
        hashMap = new HashMap<>(N * N); // 해시맵 초기 크기 지정

        for (int i = 0; i < N; i++) { // C
            for (int j = 0; j < N; j++) { // D
                long sumCD = C[i] + D[j];
                hashMap.put(sumCD, hashMap.getOrDefault(sumCD, 0L) + 1L);
            }
        }
    }

    private static void countZeroSums() {
        for (int i = 0; i < N; i++) { // A
            for (int j = 0; j < N; j++) { // B
                long sumAB = A[i] + B[j];
                cnt += hashMap.getOrDefault(-sumAB, 0L); // -(A + B) 찾기
            }
        }
    }
}