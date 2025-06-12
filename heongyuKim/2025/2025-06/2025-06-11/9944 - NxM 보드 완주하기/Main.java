import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int caseNum = 0;

    static int N;
    static int M;

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static char[][] arr;
    static boolean[][] visited;

    // 빈칸의 갯수
    static int blank;

    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 여러 개의 테스트 케이스
        while (true) {
            caseNum++;

            String line = br.readLine();
            if (line == null) {
                break;
            }

            result = Integer.MAX_VALUE;

            StringTokenizer info = new StringTokenizer(line);

            N = Integer.parseInt(info.nextToken());
            M = Integer.parseInt(info.nextToken());

            arr = new char[N][M];
            visited = new boolean[N][M];

            blank = 0;

            for (int i = 0; i < N; i++) {
                String info2 = br.readLine();
                for (int j = 0; j < M; j++) {
                    if (info2.charAt(j) == '.') {
                        blank++;
                    }
                    arr[i][j] = info2.charAt(j);
                }
            }

            // 백트래킹 진행
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == '.') {
                        visited[i][j] = true;
                        dfs(i, j, 0, -1, 1);
                        visited[i][j] = false;
                    }
                }
            }

            if (result == Integer.MAX_VALUE) {
                System.out.println("Case " + caseNum + ": " + -1);
            } else {
                System.out.println("Case " + caseNum + ": " + result);
            }
        }
    }

    private static void dfs(int x, int y, int count, int curDir, int blankCount) {
        // 가지치기
        if (count > result) {
            return;
        }

        // 종료조건
        if (blankCount == blank) {
            result = Math.min(count, result);
            return;
        }

        // 로직
        for (int i = 0; i < 4; i++) {
            if (curDir == i) continue;

            int nx = x;
            int ny = y;
            
            int moved = 0; // 움직인 거리

            while (true) {
                nx += dx[i];
                ny += dy[i];

                if (0 > nx || nx > N - 1 || 0 > ny || ny > M - 1 || visited[nx][ny] || arr[nx][ny] == '*') break;

                visited[nx][ny] = true;
                moved++;
            }

            if (moved == 0) continue;

            dfs(nx - dx[i], ny - dy[i], count + 1, i, blankCount + moved);

            while (moved-- > 0) {
                nx -= dx[i];
                ny -= dy[i];
                visited[nx][ny] = false;
            }
        }
    }
}