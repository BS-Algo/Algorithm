import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 구현의 핵심은 배열을 조합할때마다 매번 깊은 복사로 넘겨주는 것이었음.
// 기존에는 배열을 자주 생성하지 않기 위해서 기록했던 것을 다시 지워주는 로직으로 작성하려고 했지만 너무 복잡해졌음.
public class Main {
    public static class Cctv {
        int x;
        int y;
        int type;

        public Cctv(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    static int N;
    static int M;

    static ArrayList<Cctv> cctvs = new ArrayList<>();
    
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][][] direction = {{{0}}, {{0}, {1}, {2}, {3}}, {{0, 1}, {2, 3}}, {{0, 3}, {1, 3}, {1, 2}, {0, 2}}, {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}}, {{0, 1, 2, 3}}};

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer nums = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(nums.nextToken());
                arr[i][j] = num;
                // cctv 정보 저장
                if (num != 0 && num != 6) {
                    cctvs.add(new Cctv(i, j, num));
                }
            }
        }

        dfs(0, arr);

        System.out.println(result);

    }

    // 조합
    private static void dfs(int depth, int[][] map) {
        // 종료조건
        if (depth == cctvs.size()) {
            int count = countZero(map);
            result = Math.min(count, result);
            return;
        }

        int type = cctvs.get(depth).type;
        int x = cctvs.get(depth).x;
        int y = cctvs.get(depth).y;

        for (int i = 0; i < direction[type].length; i++) {

            int[][] newMap = copyArr(map);

            for (int j = 0; j < direction[type][i].length; j++) {

                int dir = direction[type][i][j];
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                while (true) {

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        break;
                    }

                    if (map[nx][ny] == 6) {
                        break;
                    }

                    newMap[nx][ny] = -1;
                    nx += dx[dir];
                    ny += dy[dir];
                }
            }

            dfs(depth + 1, newMap);
        }
    }

    private static int[][] copyArr(int[][] map) {
        int[][] newMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }

        return newMap;
    }

    private static int countZero(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}