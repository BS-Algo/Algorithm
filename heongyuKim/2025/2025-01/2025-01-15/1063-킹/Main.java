import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 킹의 위치
        String king = st.nextToken();
        // 돌의 위치
        String rock = st.nextToken();
        // 움직이는 횟수
        int move = Integer.parseInt(st.nextToken());

        // 체스판 생성
        int[][] chessBoard = new int[8][8];

        // 체스판에 킹과 돌 놓기
        int kingRow = 8 - Integer.parseInt(String.valueOf(king.charAt(1)));
        int kingCol = king.charAt(0) - 'A';

        int rockRow = 8 - Integer.parseInt(String.valueOf(rock.charAt(1)));
        int rockCol = rock.charAt(0) - 'A';
        
        // 체스판에 킹과 돌의 위치 입력
        chessBoard[kingRow][kingCol] = 2;
        chessBoard[rockRow][rockCol] = 1;

        // 움직이기 전에 돌과 킹의 다음 위치가 체스판 밖일 경우를 먼저 처리하기
        for (int i = 0; i < move; i++) {
            String command = br.readLine();
            int moveRow = 0;
            int moveCol = 0;

            if (command.equals("R")) {
                moveCol++;
            } else if (command.equals("L")) {
                moveCol--;
            } else if (command.equals("B")) {
                moveRow++;
            } else if (command.equals("T")) {
                moveRow--;
            } else if (command.equals("RT")) {
                moveRow--;
                moveCol++;
            } else if (command.equals("LT")) {
                moveRow--;
                moveCol--;
            } else if (command.equals("RB")) {
                moveRow++;
                moveCol++;
            } else {
                moveRow++;
                moveCol--;
            }

            // 만약 킹의 다음 위치가 체스판 밖인지 확인
            if (kingRow + moveRow < 0 || kingRow + moveRow > 7 || kingCol + moveCol < 0 || kingCol + moveCol > 7) {
                continue;
            } else {
                // 만약 킹의 다음 위치가 지금 돌의 위치와 같다면
                if (chessBoard[kingRow + moveRow][kingCol + moveCol] == chessBoard[rockRow][rockCol]) {
                    if (rockRow + moveRow < 0 || rockRow + moveRow > 7 || rockCol + moveCol < 0 || rockCol + moveCol > 7) {
                        continue;
                    } else {
                        chessBoard[kingRow][kingCol] = 0;
                        chessBoard[rockRow][rockCol] = 2;
                        kingRow += moveRow;
                        kingCol += moveCol;
                        rockRow += moveRow;
                        rockCol += moveCol;
                        chessBoard[rockRow][rockCol] = 1;
                    }
                } else {
                    kingRow += moveRow;
                    kingCol += moveCol;
                }
            }
        }

        StringBuilder result = new StringBuilder();

        result.append(checkCol(kingCol));
        result.append(8 - kingRow).append('\n');

        result.append(checkCol(rockCol));
        result.append(8 - rockRow);

        System.out.println(result);

    }

    static String checkCol(int col) {
        String result = "";
        switch (col) {
            case 0:
                result = "A";
                break;
            case 1:
                result = "B";
                break;
            case 2:
                result = "C";
                break;
            case 3:
                result = "D";
                break;
            case 4:
                result = "E";
                break;
            case 5:
                result = "F";
                break;
            case 6:
                result = "G";
                break;
            case 7:
                result = "H";
                break;

        }
        return result;
    }
}