import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    // 그래프를 나타낼 ArrayList
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // 방문 표시할 배열
    static int[] visited;

    static int N;
    static int M;
    static int R;
    
    // 방문 순서
    static int count = 1;
    static StringBuilder result = new StringBuilder();

    // dfs
    static void dfs(int node) {
        visited[node] = count;

        // 인접 노드를 순회
        for (int i = 0; i < graph.get(node).size(); i++) {
            int nextNode = graph.get(node).get(i);

            if (visited[nextNode] == 0) {
                count++;
                dfs(nextNode);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());
        R = Integer.parseInt(info.nextToken());

        visited = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보를 입력받기
        for (int i = 0; i < M; i++) {
            StringTokenizer link = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(link.nextToken());
            int e = Integer.parseInt(link.nextToken());

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        // 오름차순 정렬
        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        // dfs 시작
        dfs(R);

        // 결과를 StringBuilder에 저장
        for (int i = 1; i < visited.length; i++) {
            result.append(visited[i]).append("\n");
        }

        System.out.println(result.toString());
    }
}