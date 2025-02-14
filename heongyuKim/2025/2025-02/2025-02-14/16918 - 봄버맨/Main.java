import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


class Main {

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // R, C, N
        StringTokenizer info = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(info.nextToken());
        int C = Integer.parseInt(info.nextToken());
        int N = Integer.parseInt(info.nextToken());

        // 폭탄을 다룰 판
        char[][] bombBoard = new char[R][C];

        // 폭탄의 시간을 다룰 판
        int[][] timeBoard = new int[R][C];
            
        // 초기 세팅
        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            for (int j = 0; j < C; j++) {
                char box = line.charAt(j);

                bombBoard[i][j] = box;

                if (box == 'O') {
                    timeBoard[i][j] = 3;
                    
                }
            }

        }

        int time = 0;

        while (time++ < N) {
            
            // 폭탄으로 채우기
            if (time % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bombBoard[i][j] == '.') {
                            bombBoard[i][j] = 'O';
                            timeBoard[i][j] = time + 3;
                        }
                    }
                }
            } else {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (timeBoard[i][j] == time && bombBoard[i][j] == 'O') {
                            bombBoard[i][j] = '.';
                            timeBoard[i][j] = 0;

                            for (int e = 0; e < 4; e++) {

                                if (0 > i + dx[e] || i + dx[e] >= R || 0 > j + dy[e] || j + dy[e] >= C) continue;

                                if (timeBoard[i + dx[e]][j + dy[e]] != time && bombBoard[i + dx[e]][j + dy[e]] == 'O') {
                                    bombBoard[i + dx[e]][j + dy[e]] = '.';
                                    timeBoard[i + dx[e]][j + dy[e]] = 0;
                                }

                            }
                        }
                    }
                }
            }

        }

        printBoard(bombBoard);


    }

    static void printBoard(char[][] board) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result.append(board[i][j]);
            }
            result.append('\n');
        }

        System.out.println(result.toString());

    }
}