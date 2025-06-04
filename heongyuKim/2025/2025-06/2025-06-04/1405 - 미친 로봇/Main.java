import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 처음에는 단순한 경로의 수 / 전체 경로의 수로 계산하는 방식으로 로직을 구성하였는데
// 확률 때문에 이렇게 로직을 수행하면 답이 틀리게 된다.
// 그래서 각 방향별로 확률을 곱해주고 길이가 N만큼 도달하였을 때 결과에 확률을 계산한 것을 더해줘야한다.
// 가지치기 조건은 갈 수 없는 곳이면 skip 처리.
public class Main {
    static int N;

    static boolean[][] board = new boolean[30][30];

    static int[] direction = new int[] {0, 0, 0, 0}; // 동 서 남 북
    static int[] dx = new int[] {0, 0, -1, 1};
    static int[] dy = new int[] {1, -1, 0, 0};

    static double result = 0.0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());

        // 확률이 존재하는 방향
        int n = 0;

        for (int i = 0; i < 4; i++) {
            int rate = Integer.parseInt(info.nextToken());
            if (rate != 0) {
                n++;
            }
            direction[i] = rate;
        }

        // N이 1이면 1.0
        if (N == 1) {
            System.out.println(1.0);
            return;
        }

        // 만약 확률이 있는 방향이 1개일 때
        if (n == 1) {
            System.out.println(1.0);
            return;
        }


        // 만약 확률이 있는 방향이 2개일 때
        if (n == 2) {
            // 동 - 북이면 확률이 1.0
            if (direction[0] != 0 && direction[3] != 0) {
                System.out.println(1.0);
                return;
            }

            // 서 - 남이면 확률이 1.0
            if (direction[1] != 0 && direction[2] != 0) {
                System.out.println(1.0);
                return;
            }
        }

        board[14][14] = true;
        dfs(0, 14, 14, 1.0);

        System.out.println(result);
    }

    private static void dfs(int depth, int x, int y, double probability) {
        if (depth == N) {
            result += probability;
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 가지치기 조건
            if (direction[i] != 0) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!board[nx][ny]) {
                    board[nx][ny] = true;
                    dfs(depth + 1, nx, ny, probability * direction[i] / 100.0);
                    board[nx][ny] = false;
                }
            }
        }
    }
}