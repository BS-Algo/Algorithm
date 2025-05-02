import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// dfs로 검색한 문제인데 백트래킹도 사용해야하는 문제여서 어떻게 풀어야할지 몰랐으며
// 문제를 꼼꼼히 안 읽어보아서 문제를 잘 이해못했던 것도 있음. 좀 명확하게 문제를 적어놓지...
// 다시 풀어봐야겠다.
class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    static int N;
    static int M;

    static boolean isFriend = false;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        // 그래프와 방문리스트 생성
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N];

        // 친구관계에 따른 그래프 연결
        for (int i = 0; i < M; i++) {
            StringTokenizer friend = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(friend.nextToken());
            int b = Integer.parseInt(friend.nextToken());
            
            // 양방향 연결
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 0);

            if (isFriend) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    private static void dfs(int node, int depth) {
        if (depth == 4) {
            isFriend = true;
            return;
        }

        visited[node] = true;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next, depth + 1);
                if (isFriend) return;
            }
        }

        visited[node] = false;
    }
}