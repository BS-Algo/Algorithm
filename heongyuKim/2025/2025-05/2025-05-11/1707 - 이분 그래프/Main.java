import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 집합을 색으로 적용하여 색으로 나눈 다음 dfs 탐색하면서 같은 색깔이 있으면 return 처리해주어 해결하였음.
class Main {
    static int T;

    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;

    static boolean result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            result = true;

            StringTokenizer info = new StringTokenizer(br.readLine());
            
            // 노드와 간선의 갯수
            int V = Integer.parseInt(info.nextToken());
            int E = Integer.parseInt(info.nextToken());

            graph = new ArrayList<>();
            visited = new int[V + 1];

            for (int j = 0; j < V + 1; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < E; j++) {
                StringTokenizer link = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(link.nextToken());
                int e = Integer.parseInt(link.nextToken());

                graph.get(s).add(e);
                graph.get(e).add(s);
            }


            for (int j = 1; j < V + 1; j++) {
                if (visited[j] == 0) {
                    dfs(j, -1);
                }
            }

            if (!result) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    private static void dfs(int node, int color) {
        visited[node] = color;

        for (int next : graph.get(node)) {
            if (visited[next] == color) {
                result = false;
                return;
            }

            if (visited[next] == 0) {
                dfs(next, -color);
            }
        }
    }
}