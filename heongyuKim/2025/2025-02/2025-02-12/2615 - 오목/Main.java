import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다시 풀어봐야겠다....
class Main {
    // 바둑판
    static int[][] board = new int[21][21];
    static int[][][] memo = new int[21][21][4];
    
    // 방향 - 오른쪽, 아래, 오른쪽 아래 대각선, 왼쪽 아래 대각선
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 바둑판에 결과 채우기
        for (int i = 1; i <= 19; i++) {
            StringTokenizer info = new StringTokenizer(br.readLine());

            for (int j = 1; j <= 19; j++) {
                board[i][j] = Integer.parseInt(info.nextToken());
            }
        }

        for (int j = 1; j <= 19; j++) {
            for (int i = 1; i <= 19; i++) {
                if (board[i][j] != 0) {
                   for (int d = 0; d < 4; d++) {
                       if (memo[i][j][d] == 0 && calcul(i, j, d, board[i][j]) == 5) {
                           System.out.println(board[i][j]);
                           System.out.println(i + " " + j);
                           return;
                       }
                   }
                }
            }
        }

        System.out.println(0);
    }

    static int calcul(int x, int y, int dir, int color) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (board[nx][ny] == color) {
            return memo[nx][ny][dir] = calcul(nx, ny, dir, color) + 1;
        }
        return 1;
    }

}