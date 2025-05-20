import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> graphReverse = new ArrayList<>();
    static boolean[] visited;

    static int[] result;
    static int total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        // 노드 생성
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
            graphReverse.add(new ArrayList<>());
        }

        // 결과 리스트 생성
        result = new int[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer link = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(link.nextToken());
            int b = Integer.parseInt(link.nextToken());
            graph.get(a).add(b);
            graphReverse.get(b).add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            dfsReverse(i, i);

            visited = new boolean[N + 1];
            dfs(i, i);

            if (result[i] == N - 1) total++;
        }

        System.out.println(total);

    }

    private static void dfs(int node, int goal) {
        visited[node] = true;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                result[goal]++;
                dfs(next, goal);
            }
        }
    }

    private static void dfsReverse(int node, int goal) {
        visited[node] = true;

        for (int next : graphReverse.get(node)) {
            if (!visited[next]) {
                result[goal]++;
                dfsReverse(next, goal);
            }
        }
    }
}
