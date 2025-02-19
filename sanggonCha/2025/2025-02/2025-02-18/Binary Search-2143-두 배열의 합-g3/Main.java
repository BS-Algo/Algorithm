import java.io.*;
import java.util.*;

public class Main {
    private static int T, n, m, N, M;
    private static int[] A, B, partialA, partialB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T 입력 받기
        T = Integer.parseInt(br.readLine());

        // A 입력 받기
        n = Integer.parseInt(br.readLine());
        N = n * (n + 1) / 2;
        A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // B 입력 받기
        m = Integer.parseInt(br.readLine());
        M = m * (m + 1) / 2;

        B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 부분합 만들기
        partialA = new int[N];
        makePartialSum(partialA, A, n);
        partialB = new int[M];
        makePartialSum(partialB, B, m);

        // 정렬
        Arrays.sort(partialA);
        Arrays.sort(partialB);

        // 경우의 수 세기
        long cnt = 0;
        int lA = 0, rB = M - 1;
        while (lA < N && rB >= 0) {
            if (partialA[lA] + partialB[rB] > T) {
                rB--;
            } else if (partialA[lA] + partialB[rB] < T) {
                lA++;
            } else {
                int idxA = lA;
                int valueA = partialA[lA];
                while (lA < N && valueA == partialA[lA]) {
                    lA++;
                }

                int idxB = rB;
                int valueB = partialB[rB];
                while (rB >= 0 && valueB == partialB[rB]) {
                    rB--;
                }

                cnt += (long) (lA - idxA) * (idxB - rB);
            }
        }

        // 출력
        System.out.println(cnt);
    }

    private static void makePartialSum(int[] partialArr, int[] originArr, int inputSize) {
        int index = 0;

        for (int i = 0; i < inputSize; i++) {
            int sum = 0;
            for (int j = i; j < inputSize; j++) {
                sum += originArr[j];
                partialArr[index++] = sum;
            }
        }
    }
}