import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] moves = br.readLine().toCharArray();

        // 길이는 0보다 크고, 50보다 작다
        int[][] maze = new int[101][101];
        maze[50][50] = 1; // 시작 위치기록

        // 이동 벡터
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        int pt = 2; // 남쪽을 보며 서있다
        int y = 50, x = 50;
        int maxY = 50, maxX = 50;
        int minY = 50, minX = 50;

        for (char move : moves) {
            if (move == 'F') {
                y += dy[pt];
                x += dx[pt];
                maze[y][x] = 1;
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
            } else if (move == 'R') {
                if (pt == 3) pt = 0;
                else pt++;
            } else if (move == 'L') {
                if (pt == 0) pt = 3;
                else pt--;
            }
        }

        for (int i = maxY; i >= minY; i--) {
            for (int j = minX; j <= maxX; j++) {
                if (maze[i][j] == 1) System.out.print(".");
                else System.out.print('#');
            }
            System.out.println();
        }
    }
}