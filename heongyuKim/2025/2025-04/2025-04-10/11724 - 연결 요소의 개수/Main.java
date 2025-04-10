import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int M;

    static int[][] graph;
    static boolean[] visited;

    static int count = 0;

    private static void dfs(int node) {

        visited[node] = true;

        for (int i = 0; i < N + 1; i++) {
            if (!visited[i] && graph[node][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        // 방문 리스트 생성
        visited = new boolean[N + 1];

        // 그래프 생성
        graph = new int[N + 1][N + 1];
        
        // 간선 정보를 바탕으로 그래프 연결
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s][e] = graph[e][s] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }
}