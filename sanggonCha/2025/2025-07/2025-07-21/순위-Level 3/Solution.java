import java.util.*;

class Solution {
    private static int[] count;
    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;

    public int solution(int n, int[][] results) {
        // 0. 그래프 준비
        graph = new ArrayList[n + 1]; // ArrayList 배열
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>(); // 각 배열에 ArrayList
        }

        // 1. 간선을 추가해서 단방향 그래프 완성하기
        for (int[] result : results) {
            int start = result[0];
            int end = result[1];

            graph[start].add(end); // 단방향 그래프
        }

        // 2. 모든 노드에서 dfs 수행
        count = new int[n + 1];
        for (int start = 1; start <= n; start++) {
            visited = new boolean[n + 1];
            visited[start] = true;
            dfs(start, start);
        }

        // 3. 방문 횟수가 n-1 번인 경우는 비교를 통해 순위를 결정지을 수 있는 경우
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print(count[i] + " ");
            if (count[i] == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private static void dfs(int root, int now) {
        for (int next : graph[now]) {
            if (!visited[next]) {
                visited[next] = true;
                count[next]++; // next가 패배한 정보를 기록 -> next를 이길 수 있는 선수의 수
                count[root]++; // root가 이긴 정보를 기록 -> root가 이길 수 있는 선수의 수
                dfs(root, next);
            }
        }
    }
}