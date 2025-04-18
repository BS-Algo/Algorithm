import java.io.*;
import java.util.*;

class Main {
    static int N, root, ans = 0;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 리스트 초기 세팅
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }


        // 그래프 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int node = 0; node < N; node++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = node; // 루트 노드 기억
                continue;    // -1이면 연결하지 않는다
            }
            graph[parent].add(node);
        }

        // 지울 노드 입력 받기
        int deleteNode = Integer.parseInt(br.readLine());

        // 출력 노드가 0이면 바로 종료
        if (deleteNode == root) {
            System.out.println(0);
            return;
        }

        // deleteNode가 갖고 있던 자식들 모두 제거
        graph[deleteNode].clear();

        // 다른 부모 노드에서 deleteNode 제거
        for (int i = 0; i < N; i++) {
            graph[i].remove(Integer.valueOf(deleteNode)); // deleteNode 값을 제거
            // remove(Object o) : 리스트 안에 있는 값 자체를 찾아서 제거
            // Integer.valueOf() : Integer 객체로 만듬
        }

        // bfs
        bfs();

        // 출력
        System.out.println(ans);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);

        boolean[] visited = new boolean[N];
        visited[root] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (graph[now].isEmpty()) {
                ans++;
            } else {

                for (int next : graph[now]) {

                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
        }
    }
}