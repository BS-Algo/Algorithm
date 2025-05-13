import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


// 무식한 방법으로 각 노드에서 가장 먼 거리를 찾았는데 성능 면에서는 좋지 않았다...
class Main {
    static int N;

    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static boolean[] visited;

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

        for (int i = 1; i < N + 1; i++) {
            // 방문 리스트 생성
            visited = new boolean[N + 1];
            dfs(i, 0);
        }
        System.out.println(result);

    }

    private static void dfs(int start,  int count) {
        visited[start] = true;
        result = Math.max(result, count);

        for (int[] next : graph.get(start)) {
            int node = next[0];
            int weight = next[1];

            if (!visited[node]) {
                dfs(node,count + weight);
            }
        }
    }
}