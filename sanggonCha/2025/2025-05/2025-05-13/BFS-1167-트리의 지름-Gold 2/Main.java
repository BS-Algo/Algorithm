import java.io.*;
import java.util.*;

class Main {
    // 노드 번호와 거리를 모두 저장해야해서 클래스 생성
    static class Node {
        int to;
        int dis;

        Node(int to, int dis) {
            this.to = to;
            this.dis = dis;
        }
    }

    static int N, maxDis = 0, maxNode = 1;
    static List<Node>[] tree;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        // N 입력
        N = Integer.parseInt(br.readLine()); // 정점의 개수
        
        // tree 생성
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
     
            int from = Integer.parseInt(st.nextToken());
     
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                
                if (to == -1) break; // -1을 입력 받으면 종료

                int dis = Integer.parseInt(st.nextToken());

                tree[from].add(new Node(to, dis));
            }
        }

        // -----------------------------------------------

        // 로직
        // 1. 가장 먼 노드를 찾기
        int start = 1, dis = 0;
        visited = new boolean[N + 1];
        visited[start] = true;
        dfs(start, dis);

        // 2. 가장 먼 노드에서 출발해서 최장 거리(지름) 찾기
        dis = 0;
        visited = new boolean[N + 1];
        visited[maxNode] = true;
        dfs(maxNode, dis);

        System.out.println(maxDis);
    }

    private static void dfs(int now, int dis) {
        if (dis > maxDis) {
            maxDis = dis; // 최대 거리 갱신
            maxNode = now; // 최대 거리 노드 갱신
        }

        // 다음 방문 대상 탐색
        for (Node node : tree[now]) {
            int to = node.to;

            if (!visited[to]) { // 방문하지 않았다면
                visited[to] = true; // 방문 체크
                dfs(to, dis + node.dis); // 방문
            }
        }
    }
}