import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int num;
        int weight;

        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    private static int n, furthestNode = 1, maxWeight = 0;
    private static List<Node>[] tree;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N(노드의 개수) 입력 받기
        n = Integer.parseInt(br.readLine());

        // 트리 생성(n(1 ≤ n ≤ 10,000) -> ArrayList에 저장
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 간선 정보 입력 받기
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[start].add(new Node(end, weight));
            tree[end].add(new Node(start, weight)); // 무방향 그래프
        }

        // 첫 번째 dfs: 가장 먼 노드를 찾기
        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);

        // 두 번째 dfs: 가장 먼 노드에서 출발하여 트리의 지름 찾기
        visited = new boolean[n + 1];
        visited[furthestNode] = true;
        dfs(furthestNode, 0);

        // 출력
        System.out.println(maxWeight);
    }

    private static void dfs(int now, int weightSum) {
        // 최대 거리 갱신
        if (weightSum > maxWeight) {
            furthestNode = now; // 최대 거리 노드 갱신
            maxWeight = weightSum; // 최대 거리 갱신
        }

        // 다음 방문 대상 탐색
        for (Node node : tree[now]) {
            int next = node.num;
            int weight = node.weight;

            // 방문한 적 없다면
            if (!visited[next]) {
                visited[next] = true; // 방문 체크
                dfs(next, weightSum + weight); // 다음 노드 방문
            }
        }
    }
}