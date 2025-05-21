import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] result;
    private static boolean[] visited;
    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N(노드의 개수) 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그래프 생성(N (2 ≤ N ≤ 500) -> ArrayList에 저장)
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end); // 단방향 그래프
        }

        // dfs
        result = new int[N+1];
        for(int start = 1; start <= N; start++) {
            visited = new boolean[N + 1];
            visited[start] = true;
            dfs(start, start);
        }

        // 검사
        int ans = 0;
        for(int i = 1; i <= N; i++) {
            if (result[i] == N-1) ans++;
        }

        // 출력
        System.out.println(ans);
    }

    private static void dfs(int root, int now) {
        // 다음 탐색
        for(int next: graph[now]) {
            if(!visited[next]) {
                result[root]++;
                result[next]++;

                visited[next] = true; // 방문 처리
                dfs(root, next);
            }
        }
    }
}
