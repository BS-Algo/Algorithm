import java.io.*;
import java.util.*;

public class Main {
    static int N, M, si, sj, ans = 0;
    static int[] di = {0, 0, 1, -1};
    static int[] dj = {1, -1, 0, 0};
    static char[][] campus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 보드 입력 받기
        campus = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char temp = line.charAt(j);
                if (temp == 'I') {
                    si = i;
                    sj = j;
                }
                campus[i][j] = temp;
            }
        }

        // BFS
        bfs();
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{si, sj});

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int i = info[0];
            int j = info[1];

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];

                if (indexCheck(ni, nj)) {
                    if (campus[ni][nj] == 'P') {
                        ans++;
                        campus[ni][nj] = 'I';
                        queue.offer(new int[]{ni, nj});
                    } else if (campus[ni][nj] == 'O') {
                        campus[ni][nj] = 'I';
                        queue.offer(new int[]{ni, nj});
                    }
                }
            }
        }

        if (ans == 0) System.out.println("TT");
        else System.out.println(ans);
    }

    private static boolean indexCheck(int ni, int nj) {
        return 0 <= ni && ni < N && 0 <= nj && nj < M;
    }
}
