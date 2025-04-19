import java.io.*;
import java.util.*;

class Main {
    static int N, M, order = 1;
    static int[] ans;
    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        // N, M, R 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken()) - 1;
        ans = new int[N];
        visited = new boolean[N];

        // graph 세팅
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph[u].add(v);
            graph[v].add(u); // 무방향 그래프
        }

        // 인접 노드 내림차순 정렬
        for (int i = 0; i < N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        // dfs
        visited[R] = true;
        dfs(R);

        // 출력
        for (int i = 0; i < N; i++) {
            System.out.println(ans[i]);
        }
    }

    private static void dfs(int now) {
        ans[now] = order++;
        for (int next : graph[now]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}