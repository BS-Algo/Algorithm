import java.io.*;
import java.util.*;

class Country {
    int i, j;

    public Country(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {
    static boolean flag = true;
    static int N, L, R, ni, nj, day = 0;
    static int[][] map, visited, dij = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, L, R 입력 받기
        String[] NLR = br.readLine().split(" ");
        N = Integer.parseInt(NLR[0]);
        L = Integer.parseInt(NLR[1]);
        R = Integer.parseInt(NLR[2]);
        map = new int[N][N];

        // 인구수 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (flag) {
            flag = false;
            visited = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        visited[i][j] = 1; // 방문 체크
                        populationMove(i, j); // 인구 이동이 가능한지 체크
                    }
                }
            }

            if (!flag) {
                System.out.println(day);
                break;
            }
            day++;
        }

    }

    private static void populationMove(int i, int j) {
        int cnt = 1;
        int popSum = map[i][j];
        Queue<Country> queue1 = new LinkedList<>(); // bfs용 queue
        Queue<Country> queue2 = new LinkedList<>(); // 인구이동용 queue
        queue1.add(new Country(i, j));
        queue2.add(new Country(i, j));

        while (!queue1.isEmpty()) {
            Country country = queue1.poll();
            i = country.i;
            j = country.j;
            for (int k = 0; k < 4; k++) {
                ni = i + dij[k][0];
                nj = j + dij[k][1];
                if (indexCheck(ni, nj)) {
                    int dif = Math.abs(map[ni][nj] - map[i][j]);
                    if (visited[ni][nj] == 0 && dif >= L && dif <= R) {
                        flag = true;
                        visited[ni][nj] = 1; // 방문 체크
                        queue1.add(new Country(ni, nj));
                        queue2.add(new Country(ni, nj));
                        popSum += map[ni][nj];
                        cnt++;
                    }
                }
            }
        }

        if (queue2.size() > 1) {
            int afterPop = popSum / cnt;
            while (!queue2.isEmpty()) {
                Country country = queue2.poll();
                i = country.i;
                j = country.j;
                map[i][j] = afterPop;
            }
        }
    }

    private static boolean indexCheck(int ni, int nj) {
        return ni < N && ni >= 0 && nj < N && nj >= 0;
    }

    // 디버깅용 함수
    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}