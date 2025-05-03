import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Main {

    static int N;
    static int M;

    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static boolean[] visited;

    static int result  = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer info = new StringTokenizer(br.readLine());
        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];
        
        // 그래프 연결
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer link = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(link.nextToken());
            int b = Integer.parseInt(link.nextToken());
            int distance = Integer.parseInt(link.nextToken());

            graph.get(a).add(new int[] {b, distance});
            graph.get(b).add(new int[] {a, distance});
        }


        for (int i = 0; i < M; i++) {
            StringTokenizer nodes = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(nodes.nextToken());
            int end = Integer.parseInt(nodes.nextToken());

            dfs(start, end, 0);
            
            System.out.println(result);
            
            result = 0;
            visited = new boolean[N + 1];
        }
    }

    private static void dfs(int start, int end, int distance) {
        visited[start] = true;
        // 목표지점이면 결과에 거리 할당.
        if (start == end) {
            result = distance;
            return;
        }

        for (int[] node : graph.get(start)) {
            int next = node[0];
            int dis = node[1];

            if (!visited[next]) {
                dfs(next, end, distance + dis);
            }
        }
    }
}