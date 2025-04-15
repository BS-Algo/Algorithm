import java.io.*;
import java.util.*;

class Main {
    static int N, M, K, X;
    static List<Integer>[] graph; // 세로의 크기는 고정적이고, 가로의 크기는 각각 가변적인 2차원 배열과 동일
    static List<Integer> result = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 도로 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }

        // bfs
        bfs();

        // 출력
        if (!result.isEmpty()) {
            Collections.sort(result);
            for (int city : result) {
                System.out.println(city);
            }
        } else {
            System.out.println(-1);
        }
    }

    private static void bfs() {
        boolean[] visited = new boolean[N + 1];
        visited[X] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{X, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int dis = cur[1];

            if (dis == K) {
                result.add(now);
                continue;
            }

            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, dis + 1});
                }
            }
        }
    }
}