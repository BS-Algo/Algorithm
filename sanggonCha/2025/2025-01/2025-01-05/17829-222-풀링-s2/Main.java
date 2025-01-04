import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        poolingOperation(matrix, N);
    }

    private static void poolingOperation(int[][] matrix, int N) {
        if (N == 1) {
            System.out.println(matrix[0][0]);
        } else {
            int[] di = {0, 0, 1, 1};
            int[] dj = {0, 1, 0, 1};
            int[][] pooledMaxtrix = new int[N / 2][N / 2];

            for (int i = 0; i < N; i += 2) {
                for (int j = 0; j < N; j += 2) {
                    int[] matrix22 = new int[4];
                    for (int k = 0; k < 4; k++) {
                        int ni = i + di[k];
                        int nj = j + dj[k];
                        matrix22[k] = matrix[ni][nj];
                    }
                    Arrays.sort(matrix22); // 오름차순 정렬 - 버블 정렬같이 직접 구현해도 되긴 함..
                    pooledMaxtrix[i / 2][j / 2] = matrix22[2]; // 두 번째로 큰 값을 저장
                }
            }

            poolingOperation(pooledMaxtrix, N / 2); // 재귀 호출
        }
    }
}