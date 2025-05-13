import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


// 먼저 루트에서 가장 먼 노드로 가서 거기에서 가장 먼 거리를 계산하는 방식으로 푸는 것이 핵심이었다...
class Main {
    static int N;

    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static boolean[] visited;

    static int maxNode = 0;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 그래프 생성
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 연결 - 가중치랑 같이
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer link = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(link.nextToken());
            int e = Integer.parseInt(link.nextToken());
            int weight = Integer.parseInt(link.nextToken());

            graph.get(s).add(new int[] {e, weight});
            graph.get(e).add(new int[] {s, weight});
        }

        visited = new boolean[N + 1];
        dfs(1, 0);

        visited = new boolean[N + 1];
        dfs(maxNode, 0);


        System.out.println(result);
    }

    private static void dfs(int node,  int count) {
        visited[node] = true;
        if (count > result) {
            result = Math.max(result, count);
            maxNode = node;
        }

        for (int[] next : graph.get(node)) {
            int n = next[0];
            int weight = next[1];

            if (!visited[n]) {
                dfs(n,count + weight);
            }

        }
    }
}