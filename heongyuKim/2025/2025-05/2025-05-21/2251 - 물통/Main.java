import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 모든 경우를 bfs해주기
public class Main {
    // 물통 A,B,C 의 용량
    static int A;
    static int B;
    static int C;

    static boolean[][][] visited;

    static ArrayList<Integer> result = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        A = Integer.parseInt(info.nextToken());
        B = Integer.parseInt(info.nextToken());
        C = Integer.parseInt(info.nextToken());

        visited = new boolean[A + 1][B + 1][C + 1];

        bfs();

        for (int i = 0; i <= B; i++) {
            for (int j = 0; j <= C; j++) {
                if (visited[0][i][j]) {
                    result.add(j);
                }
            }
        }

        Collections.sort(result);

        for (int num : result) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, C});
        visited[0][0][C] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int a = node[0];
            int b = node[1];
            int c = node[2];

            // 물통 상태
            int[] current = {a, b, c};
            int[] capacity = {A, B, C};

            // i → j 물 이동 (i != j)
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;

                    int[] next = {current[0], current[1], current[2]};

                    // i번 물통에서 j번 물통으로 물을 붓기
                    int move = Math.min(current[i], capacity[j] - current[j]);
                    next[i] -= move;
                    next[j] += move;

                    if (!visited[next[0]][next[1]][next[2]]) {
                        visited[next[0]][next[1]][next[2]] = true;
                        q.offer(new int[] {next[0], next[1], next[2]});
                    }
                }
            }
        }
    }

}