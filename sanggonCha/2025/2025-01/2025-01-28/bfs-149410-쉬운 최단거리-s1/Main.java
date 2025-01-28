import java.io.*;
import java.util.*;

class Pair {
    int i, j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {
    static int n, m, ni, nj, startI, startJ;
    static int[][] dij = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static boolean indexCheck(int ni, int nj) {
        return ni >= 0 && ni < n && nj >= 0 && nj < m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n, m 입력 받기
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        // 지도 입력 받기
        int[][] map = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int point = Integer.parseInt(line[j]);
                map[i][j] = point;
                if (point == 2) {
                    q.add(new Pair(i, j));
                    map[i][j] = 0;
                } else if (point == 1) {
                    map[i][j] = -1;
                }
            }
        }

        // BFS
        // 0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            for (int i = 0; i < 4; i++) {
                ni = pair.i + dij[i][0];
                nj = pair.j + dij[i][1];
                if (indexCheck(ni, nj) && map[ni][nj] == -1) {
                    q.add(new Pair(ni, nj)); // 다음 탐색을 위해 큐에 추가
                    map[ni][nj] = map[pair.i][pair.j] + 1; // 거리 추가
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}