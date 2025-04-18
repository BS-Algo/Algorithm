import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    
    // 그래프
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    // 방문 리스트
    static int[] visited;

    // 노드의 갯수
    static int N;

    // 간선의 갯수
    static int M;

    // 순서
    static int count = 0;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());
        int R = Integer.parseInt(info.nextToken());

        // 노드 생성
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 방문 리스트 생성
        visited = new int[N + 1];

        // 간선 잇기
        for (int i = 0; i < M; i++) {
            StringTokenizer link = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(link.nextToken());
            int e = Integer.parseInt(link.nextToken());
            
            // 무방향 그래프
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        // 내림차순 정렬
        for (ArrayList<Integer> node : graph) {
            Collections.sort(node, Collections.reverseOrder());
        }

        bfs(R);
        
        // 결과 출력
        for (int i = 1 ; i < N + 1; i++) {
            System.out.println(visited[i]);
        }
    }

    private static void bfs(int R) {
        Queue<Integer> q = new LinkedList<>();

        visited[R] = ++count;
        q.offer(R);

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int i = 0; i < graph.get(node).size(); i++) {
                int next = graph.get(node).get(i);

                if (visited[next] == 0) {
                    q.offer(next);
                    visited[next] = ++count;
                }
            }
        }
    }
}