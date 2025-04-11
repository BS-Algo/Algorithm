import java.io.*;
import java.util.*;

public class Main {
    static int h, w;
    static int[][] board;
    static boolean[][] visited;
    static int[] di = {0, 0, 1, -1}, dj = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // h, w 입력 받기
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        board = new int[h][w];

        // 치즈 입력 받기
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int lastCount = 0;

        //
        while (true) {
            visited = new boolean[h][w];
            List<int[]> toMelt = new ArrayList<>();

            bfs(toMelt); // 외부 공기를 탐색하며 녹일 치즈 후보 찾기

            if (toMelt.isEmpty()) break; // 더 이상 녹일 치즈가 없다면 종료

            lastCount = toMelt.size(); // 현재 녹여야할 치즈 수

            for (int[] cheese : toMelt) {
                board[cheese[0]][cheese[1]] = 0;
            }
            time++;
        }

        System.out.println(time);
        System.out.println(lastCount);
    }

    private static void bfs(List<int[]> toMelt) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];

                if (ni >= 0 && ni < h && nj >= 0 && nj < w && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    if (board[ni][nj] == 1) {
                        toMelt.add(new int[]{ni, nj}); // 외부 공기와 접촉한 치즈
                    } else {
                        queue.offer(new int[]{ni, nj}); // bfs 대상에 추가
                    }
                }
            }
        }
    }
}