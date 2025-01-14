import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 좌표를 도출해야하는 숫자
        int findNum = Integer.parseInt(br.readLine());
        int x = 0;
        int y = 0;

        // N의 제곱만큼의 배열을 생성
        int[][] snail = new int[N][N];

        // 시작 숫자
        int num = N * N;

        // 방향 설정 - 아래, 오른쪽, 위, 왼쪽
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        // 방향을 나타낼 변수
        int direction = 0;
        
        // 현재 위치를 나타낼 변수
        int row = 0;
        int col = 0;

        // 첫번째 위치에 값을 넣기
        snail[row][col] = num;

        while (num > 1) {
            if (direction == 0) {
                if (row + dx[direction] > N - 1 || snail[row + dx[direction]][col + dy[direction]] != 0) {
                    direction = 1;
                } else {
                    num--;
                    row += dx[direction];
                    snail[row][col] = num;
                }
            } else if (direction == 1) {
                if (col + dy[direction] > N - 1 || snail[row + dx[direction]][col + dy[direction]] != 0) {
                    direction = 2;
                } else {
                    num--;
                    col += dy[direction];
                    snail[row][col] = num;
                }
            } else if (direction == 2) {
                if (row + dx[direction] < 0 || snail[row + dx[direction]][col + dy[direction]] != 0) {
                    direction = 3;
                } else {
                    num--;
                    row += dx[direction];
                    snail[row][col] = num;
                }
            } else {
                if (col + dy[direction] < 0 || snail[row + dx[direction]][col + dy[direction]] != 0) {
                    direction = 0;
                } else {
                    num--;
                    col += dy[direction];
                    snail[row][col] = num;
                }
            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == N - 1) {
                    sb.append(snail[i][j]).append("\n");
                } else {
                    sb.append(snail[i][j]).append(" ");
                }

                if (snail[i][j] == findNum) {
                    x = i + 1;
                    y = j + 1;
                }
            }
        }

        sb.append(x).append(" ").append(y);
        System.out.println(sb);
    }
}