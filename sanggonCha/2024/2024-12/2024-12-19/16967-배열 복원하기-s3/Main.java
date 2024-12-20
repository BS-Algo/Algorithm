import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 첫 줄 변수 입력 받기
        int H = sc.nextInt();
        int W = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        int[][] origin = new int[H][W];
        int[][] overlap = new int[H + X][W + Y];

        // 겹쳐진 배열 입력 받기
        for (int i = 0; i < H + X; i++) {
            for (int j = 0; j < W + Y; j++) {
                overlap[i][j] = sc.nextInt();
            }
        }

        // 복원 1, 2사분면
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < W; j++) {
                origin[i][j] = overlap[i][j];
            }
        }

        // 복원 3사분면
        for (int i = X; i < H; i++) {
            for (int j = 0; j < Y; j++) {
                origin[i][j] = overlap[i][j];
            }
        }

        // 복원 4사분면
        for (int i = X; i < H; i++) {
            for (int j = Y; j < W; j++) {
                origin[i][j] = overlap[i][j] - origin[i - X][j - Y];
            }
        }

        // 출력
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W - 1; j++) {
                System.out.printf("%d ", origin[i][j]);
            }
            System.out.printf("%d\n", origin[i][W - 1]);
        }
    }
}