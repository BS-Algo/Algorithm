import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static int[] visited;

    // 정점의 수
    static int N;
    // 간선의 수
    static int M;
    // 순서
    static int sequence = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());
        // 시작 정점
        int R = Integer.parseInt(info.nextToken());

        // 노드의 수만큼 ArrayList 생성
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 방문 리스트 생성
        visited = new int[N + 1];

        // 그래프 연결
        for (int i =0 ; i < M; i++) {

            StringTokenizer link = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(link.nextToken());
            int e = Integer.parseInt(link.nextToken());

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        // 내림차순으로 정렬
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        // dfs
        dfs(R);
        
        // 결과 출력
        for (int i = 1; i < N + 1; i++) {
            System.out.println(visited[i]);
        }

    }

    private static void dfs(int R) {

        visited[R] = ++sequence;

        for (int i = 0; i < graph.get(R).size(); i++) {
            int next = graph.get(R).get(i);
            if (visited[next] == 0) {
                dfs(next);
            }
        }

    }
}