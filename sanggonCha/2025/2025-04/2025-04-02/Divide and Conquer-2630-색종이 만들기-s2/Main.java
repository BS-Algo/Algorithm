import java.io.*;
import java.util.*;

public class Main {
    static int N, white = 0, blue = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        // 배열 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 재귀(분할 정복)
        recursion(N, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }

    /** n*n 크기의 2차원 배열을 1/2씩 분할 정복을 수행하는 함수 **/
    private static void recursion(int size, int i, int j) {
        if (check(size, i, j)) {
            if (arr[i][j] == 1) blue++;
            else white++;
        } else {
            size /= 2;
            recursion(size, i, j); // 1사분면
            recursion(size, i, j + size); // 2사분면
            recursion(size, i + size, j); // 3사분면
            recursion(size, i + size, j + size); // 4사분면
        }
    }

    /** 모두 같은 색으로 칠해져 있는지를 확인해서 true or flase 값을 반환하는 함수 **/
    private static boolean check(int size, int si, int sj) {
        int flag = arr[si][sj];
        for (int i = si; i < si + size; i++) {
            for (int j = sj; j < sj + size; j++) {
                if (arr[i][j] != flag) return false;
            }
        }
        return true;
    }
}
