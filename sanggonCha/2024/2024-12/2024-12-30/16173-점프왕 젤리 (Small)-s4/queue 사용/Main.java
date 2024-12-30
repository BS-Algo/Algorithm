import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // map 입력 받기
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] mapString = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(mapString[j]);
            }
        }

        // BFS 탐색
        if (canReachEnd(map, N)) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    public static boolean canReachEnd(int[][] map, int N) {
        boolean[][] visited = new boolean[N][N]; // 방문 여부 체크
        Queue<int[]> queue = new LinkedList<>(); // BFS를 위한 큐
        queue.add(new int[]{0, 0}); // 시작점 추가
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int i = current[0];
            int j = current[1];

            // 도착 여부 체크
            if (map[i][j] == -1) { // 도착지는 -1
                return true;
            }

            // 현재 칸의 이동 거리
            int move = map[i][j];
            if (move == 0) continue; // 이동할 수 없는 칸은 무시

            // 아래로 이동
            int ni = i + move;
            if (ni < N && !visited[ni][j]) {
                queue.add(new int[]{ni, j});
                visited[ni][j] = true;
            }

            // 오른쪽으로 이동
            int nj = j + move;
            if (nj < N && !visited[i][nj]) {
                queue.add(new int[]{i, nj});
                visited[i][nj] = true;
            }

        }
        return false;
    }
}