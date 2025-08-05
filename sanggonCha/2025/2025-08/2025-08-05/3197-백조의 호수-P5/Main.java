import java.util.*;
import java.io.*;

public class Main {
    private static List<int[]> glacier = new ArrayList<>();
    private static List<int[]> swan = new ArrayList<>();
    private static char[][] charMap;
    private static int[][] intMap;
    private static int[] di = {0, 0, 1, -1}, dj = {1, -1, 0, 0};
    private static int R, C, answer = 0, leftDay = 0, rightDay = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        charMap = new char[R][C];
        intMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                charMap[i][j] = line.charAt(j);
            }
        }

        // 1. 빙하 녹이기
        meltGlacier();

        // 디버깅
//        debug();

        // 2. 이분 탐색
        binarySearch();

        // 3. 출력
        System.out.println(answer);
    }

    private static boolean bfs(int nowDay) {

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];

        int[] cur = swan.get(0);
        int[] targetSwan = swan.get(1);

        int i = cur[0];
        int j = cur[1];

        visited[i][j] = true;
        q.offer(swan.get(0));

        while (!q.isEmpty()) {
            cur = q.poll();

            if (cur[0] == targetSwan[0] && cur[1] == targetSwan[1]) {
                return true;
            }

            for (int d = 0; d < 4; d++) {

                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];

                if (indexCheck(ni, nj) && !visited[ni][nj] && intMap[ni][nj] <= nowDay) {
                    visited[ni][nj] = true; // 방문 체크
                    q.offer(new int[]{ni, nj}); // 다음 방문을 위해 추가
                }
            }
        }

        return false;
    }

    private static void debug() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(intMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void binarySearch() {

        while (leftDay <= rightDay) {
            int nowDay = (leftDay + rightDay) / 2;

            if (bfs(nowDay)) {
                rightDay = nowDay - 1;
                answer = nowDay;
            } else {
                leftDay = nowDay + 1;
            }
        }
    }

    private static boolean indexCheck(int ni, int nj) {
        return ni >= 0 && ni < R && nj >= 0 && nj < C;
    }

    private static void findGlacier() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (charMap[i][j] == 'X') { // 빙하를 찾으면
                    glacier.add(new int[]{i, j}); // 리스트에 추가
                } else if (charMap[i][j] == 'L') {
                    glacier.add(new int[]{i, j});
                    swan.add(new int[]{i, j}); // 큐에 추가
                    intMap[i][j] = 0;
                } else {
                    intMap[i][j] = 0;
                }
            }
        }
    }

    private static void recordMeltingDay() {

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (charMap[i][j] != 'X') {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int i = cur[0];
            int j = cur[1];

            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];

                // 인접한 곳이 빙하가 아니라면 = 호수를 만났다면
                if (indexCheck(ni, nj) && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    intMap[ni][nj] = intMap[i][j] + 1;
                    rightDay = Math.max(rightDay, intMap[ni][nj]);
                    q.offer(new int[]{ni, nj});
                }
            }
        }
    }

    private static void meltGlacier() {
        boolean[][] visited = new boolean[R][C];
        int count = 1;

        // 1. 모든 빙하 찾기
        findGlacier();

        // 2. 빙하가 녹는 날을 기록
        recordMeltingDay();
    }
}