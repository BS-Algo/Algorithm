import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    // 루트 노드
    static int root = 0;

    // 제거해야할 노드
    static int removeNode;
    static int result = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 연결
        StringTokenizer edge = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(edge.nextToken());
            if (parent != -1) {
                graph.get(parent).add(i);
            } else {
                root = i;
            }
        }

        removeNode = Integer.parseInt(br.readLine());
        if (removeNode == root) {
            System.out.println(0);
            return;
        }

        // 노드 제거
        for (int i = 0; i < N; i++) {
            graph.get(i).remove(Integer.valueOf(removeNode));
        }

        dfs(root);
        System.out.println(result);
    }

    private static void dfs(int node) {
        if (graph.get(node).isEmpty()) {
            result++;
            return;
        }

        for (int next : graph.get(node)) {
            dfs(next);
        }
    }
}