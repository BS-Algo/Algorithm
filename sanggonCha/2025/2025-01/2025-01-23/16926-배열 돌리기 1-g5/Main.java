import java.io.*;

public class Main {
    private static int[][] arr;
    private static int[] temp;
    private static int N, M;
    private static int cv; // Control Variable

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMR = br.readLine().split(" ");
        N = Integer.parseInt(NMR[0]);
        M = Integer.parseInt(NMR[1]);
        cv = Math.min(N, M) / 2;
        int R = Integer.parseInt(NMR[2]);

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        // R번 회전
        for (int i = 0; i < R; i++) {
            rotate1(); // ←
            rotate2(); // ↑
            rotate3(); // →
            rotate4(); // ↓
        }

        printArr();
    }

    // (i, i) 저장
    private static void save() {
        temp = new int[cv];
        for (int i = 0; i < cv; i++) {
            temp[i] = arr[i][i];
        }
    }

    private static void push() {
        for (int i = 0; i < cv; i++) {
            arr[i + 1][i] = temp[i];
        }
    }

    // ←
    private static void rotate1() {
        save();

        for (int i = 0; i < cv; i++) {
            for (int j = i; j < (M - 1) - i; j++) {
                arr[i][j] = arr[i][j + 1];
            }
        }
    }

    // ↑
    private static void rotate2() {
        for (int j = M - 1; j > M - 1 - cv; j--) {
            for (int i = (M - 1) - j; i < (N - 1) - ((M - 1) - j); i++) {
                arr[i][j] = arr[i + 1][j];
            }
        }
    }

    // →
    private static void rotate3() {
        for (int i = N - 1; i > (N - 1) - cv; i--) {
            for (int j = (M - 1) - ((N - 1) - i); j > (N - 1) - i; j--) {
                arr[i][j] = arr[i][j - 1];
            }
        }
    }

    // ↓
    private static void rotate4() {
        for (int j = 0; j < cv; j++) {
            for (int i = (N - 1) - j; i > j; i--) {
                arr[i][j] = arr[i - 1][j];
            }
        }

        push();
    }

    // 출력
    private static void printArr() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}