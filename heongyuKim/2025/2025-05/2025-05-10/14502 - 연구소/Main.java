import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 결국은 벽을 세우고 탐색하려면 tempGraph를 이용하는 방법도 좋을듯하다.
class Main {
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static int M;

    static int[][] graph;
    static int[][] tempGraph;
    static boolean[][] visited;
    static ArrayList<int[]> wall = new ArrayList<>();
    static ArrayList<int[]> virus = new ArrayList<>();

    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        // N과 M
        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        // 그래프와 방문 리스트 생성
        graph = new int[N][M];
        visited = new boolean[N][M];

        // 그래프에 값 넣기
        for (int i = 0; i < N; i++) {
            StringTokenizer nums = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(nums.nextToken());
                graph[i][j] = num;
                
                // 벽을 세울 수 있는 위치 추가
                if (num == 0) {
                    wall.add(new int[] {i, j});
                }

                if (num == 2) {
                    virus.add(new int[] {i, j});
                }
            }
        }

        // 벽 세우기
        for (int i = 0; i < wall.size() - 2; i++) {
            for (int j = i + 1; j < wall.size() - 1; j++) {
                for (int q = j + 1; q < wall.size(); q++) {
                    tempGraph = copyGraph();

                    int count = 0;
                    int[] first = wall.get(i);
                    int[] second = wall.get(j);
                    int[] third = wall.get(q);

                    tempGraph[first[0]][first[1]] = 1;
                    tempGraph[second[0]][second[1]] = 1;
                    tempGraph[third[0]][third[1]] = 1;

                    for (int w = 0; w < virus.size(); w++) {
                        int[] location = virus.get(w);

                        if (!visited[location[0]][location[1]]) {
                            bfs(location[0], location[1]);
                        }
                    }

                    for (int w = 0; w < N; w++) {
                        for (int e = 0; e < M; e++) {
                            if (tempGraph[w][e] == 0) {
                                count++;
                            }
                        }
                    }
                    result = Math.max(result, count);
                    visited = new boolean[N][M];
                }
            }
        }

        System.out.println(result);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[] {x, y});
        tempGraph[x][y] = 2;

        while (!q.isEmpty()) {
            int[] location = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + location[0];
                int ny = dy[i] + location[1];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && !visited[nx][ny] && tempGraph[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    tempGraph[nx][ny] = 2;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }

    private static int[][] copyGraph() {
        int[][] newGraph = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newGraph[i][j] = graph[i][j];
            }
        }
        return newGraph;
    }

}