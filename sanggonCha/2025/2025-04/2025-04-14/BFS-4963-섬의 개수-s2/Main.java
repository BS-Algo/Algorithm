import java.io.*;
import java.util.*;


public class Main {
    static int w, h;
    static int[] di = {0, 0, 1, -1, 1, 1, -1, -1}, dj = {1, -1, 0, 0, 1, -1, 1, -1};
    static String[][] map;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            // w, h 입력 받기
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            // 지도 입력 받기
            map = new String[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = st.nextToken();
                }
            }

            // bfs
            bfs();
        }
    }

    private static void bfs() {
        int ans = 0;

        boolean[][] visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!map[i][j].equals("0") && !visited[i][j]) {

                    Queue<int[]> q = new LinkedList<>();

                    q.offer(new int[]{i, j});
                    visited[i][j] = true;

                    ans++;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int k = 0; k < 8; k++) {

                            int ni = cur[0] + di[k];
                            int nj = cur[1] + dj[k];

                            if (ni >= 0 && ni < h && nj >= 0 && nj < w && !visited[ni][nj] && map[ni][nj].equals("1")) {
                                q.offer(new int[]{ni, nj});
                                visited[ni][nj] = true;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}