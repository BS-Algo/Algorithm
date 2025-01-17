import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 행렬 A 크기 입력 받기
        String[] nmA = br.readLine().split(" ");
        int nA = Integer.parseInt(nmA[0]);
        int mA = Integer.parseInt(nmA[1]);

        int[][] matrixA = new int[nA][mA];

        for (int i = 0; i < nA; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < mA; j++) {
                matrixA[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 행렬 B 크기 입력 받기
        String[] nmB = br.readLine().split(" ");
        int nB = Integer.parseInt(nmB[0]);
        int mB = Integer.parseInt(nmB[1]);

        int[][] matrixB = new int[nB][mB];

        for (int i = 0; i < nB; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < mB; j++) {
                matrixB[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 행렬 AB의 곱을 저장할 행렬 생성
        int[][] matrixResult = new int[nA][mB];
        for (int i = 0; i < nA; i++) {
            for (int j = 0; j < mB; j++) {
                for (int k = 0; k < mA; k++) {
                    matrixResult[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        for (int i = 0; i < nA; i++) {
            for (int j = 0; j < mB; j++) {
                System.out.printf("%d ", matrixResult[i][j]);
            }
            System.out.println();
        }
    }
}