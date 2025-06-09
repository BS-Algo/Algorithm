import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N; // 세로선의 갯수(넓이)
    static int M; // 처음에 주어진 가로선 갯수
    static int H; // 가로선을 놓을 수 있는 갯수(높이)

    static boolean[][] ladder; // 가로선을 놓을 배열

    static int result = 10000; // 결과로 출력할 변수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer info = new StringTokenizer(br.readLine());
        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());
        H = Integer.parseInt(info.nextToken());

        // 사다리 배열 생성
        ladder = new boolean[H + 1][N + 1];

        // 사다리 있으면 놓기
        for (int i = 0; i < M; i++) {
            StringTokenizer info2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(info2.nextToken());
            int y = Integer.parseInt(info2.nextToken());
            ladder[x][y] = true;
        }

        // 먼저 주어진 예시가 바로 가능한 경우인지 확인하기
        if (check()) {
            System.out.println(0);
            return;
        }

        // dfs
        dfs(0, 1, 1);

        // 만약 불가능한거나 3보다 크면 -1 출력
        if (result == 10000) {
            System.out.println(-1);
            return;
        }

        // 그렇지 않으면 결과 출력
        System.out.println(result);
    }

    // 조합
    private static void dfs(int depth, int h, int n) {
        if (depth > 3 || depth > result) {
            return;
        }

        if (check()) {
            result = Math.min(depth, result);
            return;
        }

        // 놓을 수 있는 곳을 찾아서 놓기
        for (int i = h; i <= H; i++) {
            for (int j = (i == h ? n : 1); j < N; j++) {
                if (ladder[i][j] || ladder[i][j - 1] || ladder[i][j + 1]) continue;
                ladder[i][j] = true;
                dfs(depth + 1, i, j);
                ladder[i][j] = false;
            }
        }
    }

    // 주어진 사다리가 가능한지 판단하는 메소드
    private static boolean check() {
        int[] checkList = new int[N + 1];

        // 초기화
        for (int i = 0; i < N + 1; i++) {
            checkList[i] = i;
        }

        for (int i = 1; i < H + 1; i++) {
            for (int j = 1; j < N; j++) {
                if (ladder[i][j]) {
                    int temp = checkList[j];
                    checkList[j] = checkList[j + 1];
                    checkList[j + 1] = temp;
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (checkList[i] != i) {
                return false;
            }
        }
        return true;
    }

}