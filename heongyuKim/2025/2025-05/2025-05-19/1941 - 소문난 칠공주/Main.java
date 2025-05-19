import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


// 어려웠던 문제... 복습이 필요하다..
class Main {
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static char[][] classroom;
    static boolean[] visited;
    // 조합에 쓸 배열
    static int[] selected = new int[7];

    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        classroom = new char[5][5];

        // 값 받기
        for (int i = 0; i < 5; i++) {
            String students = br.readLine();
            for (int j = 0; j < 5; j++) {
                classroom[i][j] = students.charAt(j);
            }
        }

        dfs(0, 0, 0);
        System.out.println(result);
    }

    private static void dfs(int depth, int y, int start) {
        // 임도연파가 4명이상이면 리턴
        if (y >= 4) return;

        if (depth == 7) {
            visited = new boolean[7];
            bfs();
            return;
        }

        for (int i = start; i < 25; i++) {
            selected[depth] = i;
            if (classroom[i / 5][i % 5] == 'Y') {
                dfs(depth + 1, y + 1, i + 1);
            } else {
                dfs(depth + 1, y, i + 1);
            }
        }
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{selected[0] / 5, selected[0] % 5});
        visited[0] = true;
        int conn = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int ni = nx * 5 + ny;

                if (0 > nx || nx >= 5 || 0 > ny || ny >= 5)
                    continue;

                for (int j = 0; j < 7; j++) {
                    if (!visited[j] && selected[j] == ni) {
                        q.add(new int[]{nx, ny});
                        visited[j] = true;
                        conn++;
                    }
                }
            }
        }

        if (conn == 7)
            result++;
    }
}