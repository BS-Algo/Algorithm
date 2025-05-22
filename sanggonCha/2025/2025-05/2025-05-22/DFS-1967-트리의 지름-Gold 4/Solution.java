import java.util.*;

class Solution {
    private static boolean[] visited;
    private static List<Integer>[] graph;

    public int solution(int n, int[][] edge) {
        // graph 생성
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // edge 입력
        for (int[] e : edge) {
            int from = e[0];
            int to = e[1];
            
            graph[from].add(to);
            graph[to].add(from); // 양방향 그래프
        }

        // bfs 세팅
        visited = new boolean[n + 1];
        visited[1] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 1, 0 });
        
        int maxDis = 0, ans = 0;

        // bfs
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            int now = cur[0]; // 현재 노드 번호
            int dis = cur[1]; // 현재 거리
            
            if (dis > maxDis) {
                maxDis = dis;
                ans = 1;
            } else if (dis == maxDis) {
                ans++;
            }

            // 다음 방문 대상 탐색
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[] { next, dis + 1 });
                }
            }
        }

        return ans;
    }
}