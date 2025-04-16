import java.io.*;
import java.util.*;

class Main {
    static int N, M, R;
    static int[] ans;
    static List<Integer>[] edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M, R 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 간선 리스트 초기화
        edge = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edge[i] = new ArrayList<>();
        }

        // 간선 입력 받기
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            edge[s].add(e);
            edge[e].add(s); // 무방향 그래프
        }

        // bfs
        bfs();

        // 출력
        result();
    }

    private static void result() {
        for (int i = 1; i <= N; i++) {
            System.out.println(ans[i]);
        }
    }

    private static void bfs() {
        ans = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(R);
        visited[R] = true;

        int order = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            ans[now] = order++; // 큐에서 꺼낼 때만 순서를 기록(이미 방문한 것이기에 한 번만 기록하면 됨)

            // 다음 방문할 노드를 정렬
            Collections.sort(edge[now]);

            for (int next : edge[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
