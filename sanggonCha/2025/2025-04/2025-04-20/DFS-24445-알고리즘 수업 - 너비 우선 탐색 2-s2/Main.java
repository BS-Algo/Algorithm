import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] visited;
    static int N, M, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M, R 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken()) - 1;

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

        // 내림차순 정렬
        for (int i = 0; i < N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        // bfs();
        bfs();

        // 출력
        ans();
    }

    private static void ans() {
        for (int i = 0; i < N; i++) {
            System.out.println(visited[i]);
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(R);

        visited = new int[N];
        int order = 1;
        visited[R] = order++;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph[now]) {
                if (visited[next] == 0) {
                    visited[next] = order++;
                    q.offer(next);
                }
            }
        }
    }
}