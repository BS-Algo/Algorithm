import java.io.*;
import java.util.*;

class Main {
    static int N, M, groupNumber = 0;
    static int[] di = {0, 0, 1, -1}, dj = {1, -1, 0, 0};
    static int[][] map;
    static HashMap<Integer, Integer> groupCount = new HashMap<>();// 그룹별 0의 개수를 카운트
    static HashMap<Integer, Integer> whichGroup = new HashMap<>();// 해당 좌표가 어떤 그룹에 속하는지를 기억


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 맵 입력 받기
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 구간 카운트
        count();

        // 배열 재표현
        representation();

        // 출력
        result();
    }

    /**
     * 구간 별로 인접한 0의 개수를 카운트하는 함수(카운트한 결과는 HashMap에 저장)
     **/
    private static void count() {
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    groupNumber++;
                    int count = 1;
                    visited[i][j] = true;

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    whichGroup.put(i * M + j, groupNumber);

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int ni = cur[0] + di[k];
                            int nj = cur[1] + dj[k];
                            if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == 0 && !visited[ni][nj]) {
                                count++;
                                visited[ni][nj] = true;
                                q.offer(new int[]{ni, nj});
                                whichGroup.put(ni * M + nj, groupNumber);
                            }
                        }
                    }
                    groupCount.put(groupNumber, count); // 그룹별 카운트한 결과를 추가
                }
            }
        }
    }

    /**
     * 그룹과 그룹의 카운트 수를 확인하여 배열을 재표현
     **/
    private static void representation() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    // 같은 그룹을 중복해서 세는 것을 방지하기 위한 배열
                    Set<Integer> used = new HashSet<>();

                    int sum = 1;

                    for (int k = 0; k < 4; k++) {

                        int ni = i + di[k];
                        int nj = j + dj[k];

                        if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == 0) {
                            if (whichGroup.get(ni * M + nj) != null) {
                                int groupNumber = whichGroup.get(ni * M + nj);
                                used.add(groupNumber);
                            }
                        }
                    }
                    for (int groupNumber : used) {
                        sum += groupCount.get(groupNumber);
                    }

                    map[i][j] = sum % 10;
                }
            }
        }
    }

    private static void result() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}