import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] bingo = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int[][] inputNumbers = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                inputNumbers[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        bingoFunc(bingo, inputNumbers);
    }

    private static void bingoFunc(int[][] bingo, int[][] inputNumbers) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                checkInput(inputNumbers[i][j], bingo); // 입력 받은 수를 체크
                if (bingoCheck(bingo)) {
                    System.out.println(5 * i + j + 1);
                    return;
                }
            }
        }
    }

    private static void checkInput(int input, int[][] bingo) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == input) {
                    bingo[i][j] = 0; // 복원하지 않아도 되므로 삭제
                    return;
                }
            }
        }
    }

    private static boolean bingoCheck(int[][] bingo) {
        int check = 0;
        boolean isBingo;

        // 가로 체크
        for (int i = 0; i < 5; i++) {
            isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] != 0) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                check += 1;
            }
        }

        // 세로 체크
        for (int i = 0; i < 5; i++) {
            isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] != 0) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                check += 1;
            }
        }

        // 대각선 체크
        isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] != 0) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) {
            check += 1;
        }

        // 대각선 체크
        isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (bingo[4 - i][i] != 0) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) {
            check += 1;
        }

        if (check >= 3) {
            return true;
        } else {
            return false;
        }
    }
}