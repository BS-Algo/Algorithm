import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Main {
    static int N;
    static int M;

    static int[][] graph;

    // 1의 좌표를 저장할 ArrayList
    static ArrayList<int[]> houseLocation = new ArrayList<>();

    // 2의 좌표를 저장할 ArrayList
    static ArrayList<int[]> chickenLocation = new ArrayList<>();

    static boolean[] chickenVisited;

    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer nums = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(nums.nextToken());
                graph[i][j] = num;

                if (num == 1) {
                    houseLocation.add(new int[] {i, j});
                }

                if (num == 2) {
                    chickenLocation.add(new int[] {i, j});
                }
            }
        }

        chickenVisited = new boolean[chickenLocation.size()];
        dfs(0, 0);

        System.out.println(result);
    }

    private static void dfs(int start, int depth) {
        if (depth == M) {
            int sum = 0;

            // 각 부분별로
            for (int[] house : houseLocation) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < chickenLocation.size(); i++) {
                    if (chickenVisited[i]) {
                        int chickenX = chickenLocation.get(i)[0];
                        int chickenY = chickenLocation.get(i)[1];
                        min = Math.min(min, Math.abs(house[0] - chickenX) + Math.abs(house[1] - chickenY));
                    }
                }
                sum += min;
            }

            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chickenLocation.size(); i++) {
            if (!chickenVisited[i]) {
                chickenVisited[i] = true;
                dfs(i + 1, depth + 1);
                chickenVisited[i] = false;
            }
        }

    }
}