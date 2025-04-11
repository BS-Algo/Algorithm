import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] di = {0, 0, 1, -1}, dj = {1, -1, 0, 0};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 치즈 입력 받기
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시간 세기
        int time = 0;
        while (true) {

            Map<String, Integer> toMelt = new HashMap<>();

            // 녹일 치즈 찾기
            bfs(toMelt);

            // 녹일 치즈가 없으면 종료
            if (toMelt.isEmpty()) break;

            // 녹일 치즈가 있다면 시간 추가
            time++;

            // 치즈 녹이기
            for (String key : toMelt.keySet()) {
                if (toMelt.get(key) >= 2) {
                    String[] parts = key.split(",");
                    int i = Integer.parseInt(parts[0]);
                    int j = Integer.parseInt(parts[1]);
                    arr[i][j] = 0;
                }
            }

        }

        // 출력
        System.out.println(time);
    }

    // bfs
    private static void bfs(Map<String, Integer> toMelt) {
        // bfs를 위한 초기 세팅
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        // bfs
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int i = cur[0];
            int j = cur[1];

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];

                if (ni >= 0 && ni < N && nj >= 0 && nj < M && !visited[ni][nj]) {
                    if (arr[ni][nj] == 0) { // 공기는 Queue에 넣어서 추가 탐색
                        q.offer(new int[]{ni, nj});
                        visited[ni][nj] = true;
                    } else { // 치즈를 만났다면, 공기와 접촉한 횟수 누적
                        String key = ni + "," + nj;
                        toMelt.put(key, toMelt.getOrDefault(key, 0) + 1);
                    }
                }
            }
        }
    }
}