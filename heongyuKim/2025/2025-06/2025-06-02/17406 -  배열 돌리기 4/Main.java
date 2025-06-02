import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int K;

    static int[][] arr;
    static ArrayList<int[]> cycle = new ArrayList<>();
    static boolean[] visited;

    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer info = new StringTokenizer(br.readLine());
        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());
        K = Integer.parseInt(info.nextToken());

        arr = new int[N][M];

        // 배열에 숫자 넣기
        for (int i = 0; i < N; i++) {
            StringTokenizer nums = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(nums.nextToken());
            }
        }

        // 연산 받기
        for (int i = 0; i < K; i++) {
            StringTokenizer cal = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(cal.nextToken());
            int c = Integer.parseInt(cal.nextToken());
            int s = Integer.parseInt(cal.nextToken());

            cycle.add(new int[] {r, c, s});
        }

        // 체크리스트 생성
        visited = new boolean[K];

        // 모든 경우로 돌리는 방법 - k는 1에서 6까지
        dfs(0, new ArrayList<>());

        System.out.println(result);
    }

    // 모든 경우의 수 - 6!
    private static void dfs(int depth, ArrayList<int[]> order) {
        if (depth == K) {
            int[][] temp = copyArray();

            for (int[] or : order) {
                int r = or[0];
                int c = or[1];
                int s = or[2];
                cycleArray(temp, r - s - 1, c - s - 1, r + s - 1, c + s - 1);
            }

            calculateRow(temp);
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order.add(cycle.get(i));
                dfs(depth + 1, order);
                // 백트래킹
                visited[i] = false;
                order.remove(cycle.get(i));
            }
        }
    }


    // 배열을 회전할 메소드 - 최악의 경우 N * M(모든 원소를 옮겨야 하는 경우)
    private static void cycleArray(int[][] arr, int startR, int startC, int endR, int endC) {
        // 회전 종료조건
        if (startR >= endR || startC >= endC) {
            return;
        }

        int temp = arr[startR][endC];

        // 왼 -> 오
        for (int i = endC; i > startC; i--) {
            arr[startR][i] = arr[startR][i - 1];
        }

        int temp2 = arr[endR][endC];

        // 위 -> 아래
        for (int i = endR; i > startR; i--) {
            if (i == startR + 1) {
                arr[i][endC] = temp;
            } else {
                arr[i][endC] = arr[i - 1][endC];
            }
        }

        int temp3 = arr[endR][startC];

        // 오 -> 왼
        for (int i = startC;  i < endC; i++) {
            if (i == endC - 1) {
                arr[endR][i] = temp2;
            } else {
                arr[endR][i] = arr[endR][i + 1];
            }
        }

        // 아래 -> 위
        for (int i = startR; i < endR; i++) {
            if (i == endR - 1) {
                arr[i][startC] = temp3;
            } else {
                arr[i][startC] = arr[i + 1][startC];
            }
        }

        cycleArray(arr, startR + 1, startC + 1, endR - 1, endC - 1);
    }

    // 배열 행에서 초기값을 계산할 메소드 - 계산은 1번씩
    private static void calculateRow(int[][] arr) {
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += arr[i][j];
                if (sum > result) {
                    break;
                }
            }

            result = Math.min(sum, result);
        }
    }

    // 초기 배열을 복사할 메소드
    private static int[][] copyArray() {
        int[][] copyArray = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyArray[i][j] = arr[i][j];
            }
        }

        return copyArray;
    }
}