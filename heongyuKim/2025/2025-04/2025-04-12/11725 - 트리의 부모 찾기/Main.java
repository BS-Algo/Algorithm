import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


// 방문 리스트에 결과를 저장하면 메모리도 덜 사용할 수 있음.
// 메모리 제한이 256MB에 N이 10만개까지 주어진다면 ArrayList를 2중으로 사용하는 방식을 채택해야함.
class Main {

    // 노드의 갯수
    static int N;

    // 그래프
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    // 방문 리스트
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 그래프 생성
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 방문리스트 생성
        visited = new int[N + 1];

        // 연결 관계 기록
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer link = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(link.nextToken());
            int e = Integer.parseInt(link.nextToken());

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        // dfs
        dfs(1);

        for (int i = 2; i < N + 1; i++) {
            System.out.println(visited[i]);
        }
    }

    private static void dfs(int node) {
        for (int next : graph.get(node)) {
            if (visited[next] == 0) {
                visited[next] = node;
                dfs(next);
            }
        }
    }
}