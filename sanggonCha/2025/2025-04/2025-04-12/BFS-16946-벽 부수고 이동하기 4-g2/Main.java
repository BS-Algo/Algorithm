import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, group;
    static int[] groupSize;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        group = new int[N][M];
        int groupId = 1;
        List<Integer> groupSizes = new ArrayList<>();
        groupSizes.add(0); // index 0 dummy

        // 맵 입력
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        // 0번 그룹부터 BFS로 묶기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && group[i][j] == 0) {
                    int size = bfs(i, j, groupId);
                    groupSizes.add(size);
                    groupId++;
                }
            }
        }

        // 출력용 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 벽이면 인접한 그룹 크기 더해서 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    Set<Integer> nearGroups = new HashSet<>();
                    int count = 1; // 현재 벽 포함

                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (ni >= 0 && nj >= 0 && ni < N && nj < M) {
                            int g = group[ni][nj];
                            if (g > 0 && !nearGroups.contains(g)) {
                                nearGroups.add(g);
                                count += groupSizes.get(g);
                            }
                        }
                    }
                    sb.append(count % 10);
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    // BFS로 그룹을 나누고 크기를 리턴
    static int bfs(int i, int j, int id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        group[i][j] = id;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ni = now[0] + dx[d];
                int nj = now[1] + dy[d];
                if (ni >= 0 && nj >= 0 && ni < N && nj < M) {
                    if (map[ni][nj] == 0 && group[ni][nj] == 0) {
                        group[ni][nj] = id;
                        count++;
                        queue.offer(new int[]{ni, nj});
                    }
                }
            }
        }

        return count;
    }
}
