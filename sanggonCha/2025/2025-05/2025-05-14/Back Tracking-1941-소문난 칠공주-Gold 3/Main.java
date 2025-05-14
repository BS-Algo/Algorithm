import java.io.*;
import java.util.*;

class Main {
    static int ans = 0;
    static char[][] arr = new char[5][5];
    static int[] di = {1, -1, 0, 0}, dj = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        // ----------------------------------
        // 로직
        int idx = 0;
        int depth = 0;
        boolean[] visited = new boolean[25];
        combination(idx, depth, visited);
        System.out.println(ans);
    }

    private static boolean adjacentCheck(boolean[] visited) {
        boolean[][] check = new boolean[5][5];

        int i = 0, j = 0;

        for (int idx = 0; idx < 25; idx++) {
            if (visited[idx]) {
                i = idx / 5;
                j = idx % 5;
                check[i][j] = true;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});

        boolean[][] visitedDFS = new boolean[5][5];
        visitedDFS[i][j] = true;

        int count = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int ni = cur[0] + di[dir];
                int nj = cur[1] + dj[dir];

                if (ni >= 0 && ni < 5 && nj >= 0 && nj < 5 && check[ni][nj] && !visitedDFS[ni][nj]) {
                    visitedDFS[ni][nj] = true;
                    q.offer(new int[]{ni, nj});
                    count++;
                }
            }
        }

        if (count == 7) return true;
        return false;
    }

    private static boolean countCheck(boolean[] visited) {
        int count = 0;
        for (int idx = 0; idx < 25; idx++) {
            if (visited[idx]) {
                int i = idx / 5;
                int j = idx % 5;
                if (arr[i][j] == 'S')
                    count++;
            }
        }
        if (count >= 4) return true;
        return false;
    }

    private static void combination(int idx, int depth, boolean[] visited) {
        // 종료조건
        if (depth == 7) {
            if (countCheck(visited) && adjacentCheck(visited)) {  // 이다솜파의 학생이 4명 이상인지 체크
                ans++;
            }
            return;
        }

        for (int i = idx; i < 25; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i + 1, depth + 1, visited);
                visited[i] = false; // 복구
            }
        }
    }
}