import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs로 풀었지만 플로이드 워셜로 풀면 간단하게 풀 수 있음. 다음에는 플로이도 워셜로 풀어봐야겠다.
class Main {
    // 노드의 수
    static int N;

    // 간선의 수
    static int M;

    // 그래프
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    // 방문 리스트
    static int[] visited;

    // 결과 리스트
    static int[] result;

    // 최소 값을 가진 노드
    static int minNode = Integer.MAX_VALUE;

    // 최소 값
    static int minimum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        // 방문리스트 생성
        visited = new int[N + 1];

        // 결과 리스트 생성
        result = new int[N + 1];

        // 그래프 노드 생성
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 연결
        for (int i = 0; i < M; i++) {
            StringTokenizer link = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(link.nextToken());
            int e = Integer.parseInt(link.nextToken());

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(visited, -1);
            bfs(i);
        }
        
        // 최소값을 가진 노드 찾기
        for (int i = visited.length - 1; i >= 1; i--) {
            if (minimum >= result[i]) {
                minNode = i;
                minimum = result[i];
            }
        }
        
        // 결과 출력    
        System.out.println(minNode);
    }

    private static void bfs(int R) {
        Queue<Integer> q = new LinkedList<>();
        visited[R] = 0;
        q.offer(R);

        int sum = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int i = 0; i < graph.get(node).size(); i++) {
                int next = graph.get(node).get(i);

                if (visited[next] == -1) {
                    visited[next] = visited[node] + 1;
                    q.offer(next);
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] != -1) {
                sum += visited[i];
            }
        }

        result[R] = sum;
    }
}