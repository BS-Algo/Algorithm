import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 빙고판 생성
        int[][] bingoBoard = new int[5][5];
        
        // 빙고판에 숫자 넣기
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingoBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int checkBingo = 0;
        int bingoCount = 0;
        // 사회자가 부른 수 하나 지우고 빙고 체크
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int removeNum = Integer.parseInt(st.nextToken());
                bingoClearCell(bingoBoard, removeNum);
                checkBingo++;

                if (checkBingo >= 12) {
                    // 빙고 여부 체크하기
                    // 가로
                    bingoCount += checkBingoRow(bingoBoard);
                    // 세로
                    bingoCount += checkBingoCol(bingoBoard);
                    // 대각선
                    bingoCount += checkBingoDiagonal(bingoBoard);

                    if (bingoCount >= 3) {
                        System.out.println(checkBingo);
                        return;
                    } else {
                        bingoCount = 0;
                    }
                }
            }
        }
    }

    // 빙고 지우기 함수
    static void bingoClearCell(int[][] bingoBoard, int removeNum) {
        // 부르트포스로 모두 체크 한 후 0으로 만들기
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (bingoBoard[r][c] == removeNum) {
                    bingoBoard[r][c] = 0;
                    return;
                }
            }
        }
    }

    // 빙고 체크 함수 - 가로
    static int checkBingoRow(int[][] bingoBoard) {
        int rowBingo = 0;
        for (int r = 0; r < 5; r++) {
            int row = r;
            if (IntStream.range(0, 5).allMatch(col -> bingoBoard[row][col] == 0)) {
                rowBingo++;
            }
        }

        return rowBingo;
    }

    // 빙고 체크 함수 - 세로
    static int checkBingoCol(int[][] bingoBoard) {
        int colBingo = 0;
        for (int c = 0; c < 5; c++) {
            int col = c;
            boolean isBingo = IntStream.range(0, 5).allMatch(row -> bingoBoard[row][col] == 0);

            if (isBingo) {
                colBingo++;
            }
        }
        return colBingo;
    }

    // 빙고 체크 함수 - 대각선
    static int checkBingoDiagonal(int[][] bingoBoard) {
        int diagonalBingo = 0;

        // 오른쪽 아래로 내려가는 대각선
        if (IntStream.range(0, 5).allMatch(index -> bingoBoard[index][index] == 0)) {
            diagonalBingo++;
        }

        // 왼쪽 아래로 내려가는 대각선
        if (IntStream.range(0, 5).allMatch(index -> bingoBoard[index][4 - index] == 0)) {
            diagonalBingo++;
        }
        return diagonalBingo;
    }
}