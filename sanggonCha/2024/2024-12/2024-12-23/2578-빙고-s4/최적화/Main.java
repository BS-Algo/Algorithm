import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] bingo = new int[5][5];
        int[][] inputNumbers = new int[5][5];

        for (int i = 0; i < 5; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for (int i = 0; i < 5; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                inputNumbers[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        System.out.println(findBingoTurn(bingo, inputNumbers));
    }

    private static int findBingoTurn(int[][] bingo, int[][] inputNumbers) {
        for (int turn = 0; turn < 25; turn++) {
            markNumber(bingo, inputNumbers[turn / 5][turn % 5]);
            if (countBingoLines(bingo) >= 3) {
                return turn + 1;
            }
        }
        return 0; // 문제에는 없지만 혹시나 빙고가 되지 않을 경우에 대한 예외처리
    }

    private static void markNumber(int[][] bingo, int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == number) {
                    bingo[i][j] = 0;
                    return;
                }
            }
        }
    }

    private static int countBingoLines(int[][] bingo) {
        int lines = 0;

        for (int i = 0; i < 5; i++) {
            if (isLineBingo(bingo, i, true)) lines++; // 가로 체크
            if (isLineBingo(bingo, i, false)) lines++; // 세로 체크
        }

        if (isDiagonalBingo(bingo, true)) lines++; // 대각선 1
        if (isDiagonalBingo(bingo, false)) lines++; // 대각선 2

        return lines;
    }

    // 가로/세로 체크
    private static boolean isLineBingo(int[][] bingo, int index, boolean isRow) {
        if (isRow) { // 가로 체크
            int[] line = bingo[index];
            for (int num : line) {
                if (num != 0) {
                    return false;
                }
            }
            return true;
        } else { // 세로 체크
            for (int i = 0; i < 5; i++) {
                if (bingo[i][index] != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // 대각선 체크
    private static boolean isDiagonalBingo(int[][] bingo, boolean isMainDiagonal) {
        for (int i = 0; i < 5; i++) {
            if (bingo[i][isMainDiagonal ? i : 4 - i] != 0) {
                return false;
            }
        }
        return true;
    }
}