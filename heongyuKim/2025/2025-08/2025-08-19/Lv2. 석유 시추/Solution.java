import java.util.*;

class Solution {
    static boolean[][] visited;

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static HashMap<Integer, Integer> map = new HashMap<>();
    public int solution(int[][] land) {
        int answer = 0;

        // 가로 길이
        int width = land[0].length;
        // 세로 길이
        int height = land.length;

        visited = new boolean[height][width];
        // 위치마다 탐색 - 열을 기준으로
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                // 탐색하다가 1을 발견하면 완전 탐색으로 시추 가능한 석유 덩어리 측정하기
                if (land[j][i] == 1 && !visited[j][i]) {
                    bfs(j, i, land);
                }
            }
        }

        for (int place : map.keySet()) {
            answer = Math.max(answer, map.get(place));
        }

        // 답 출력
        return answer;
    }

    public void bfs(int x, int y, int[][] land) {
        HashSet<Integer> set = new HashSet<>();
        int gas = 1;
        // 큐 생성
        Queue<int[]> q = new LinkedList<>();
        // 큐에 시작점 넣기
        q.offer(new int[] {x, y});
        // 방문 처리
        visited[x][y] = true;
        set.add(y);

        while (!q.isEmpty()) {
            // 큐에 들어있는 원소 꺼내기
            int[] place = q.poll();
            int placeX = place[0];
            int placeY = place[1];

            // 이 값을 기준으로 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = placeX + dx[i];
                int ny = placeY + dy[i];

                if ((-1 < nx && nx < land.length && -1 < ny && ny < land[0].length) && (land[nx][ny] == 1 && !visited[nx][ny])) {
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    gas++;
                    set.add(ny);
                }
            }
        }

        for (int col : set) {
            map.put(col, map.getOrDefault(col, 0) + gas);
        }
    }
}