import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    
    // 노드 갯수, 간선 갯수
    static int N, M;
    // 그래프
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // 방문 리스트
    static int[] visited;
    
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

        // 방문리스트 생성
        visited = new int[N + 1];

        // 그래프 잇기
        for (int i = 0; i < M; i++) {
            StringTokenizer link = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(link.nextToken());
            int e = Integer.parseInt(link.nextToken());

            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        
        // 오름차순 정렬
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph.get(i));
        }

        bfs(R);
        
        // 결과 출력
        for (int i = 1; i < N + 1; i++) {
            System.out.println(visited[i]);
        }

    }

    private static void bfs(int R) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(R);
        visited[R] = ++count;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int i = 0; i < graph.get(node).size(); i++) {
                int next = graph.get(node).get(i);

                if (visited[next] != 0) {
                    continue;
                }

                q.offer(next);
                visited[next] = ++count;
            }

        }
    }
}