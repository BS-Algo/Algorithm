import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static char[][] arr;
    static boolean[][][][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 손님 수 입력 받기

        // N M K 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열 생성
        arr = new char[N][M];
        visited = new boolean[N][M][N][M];

        // 보드 입력 받기
        int[] info = new int[5];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char temp = line.charAt(j);

                if (temp == 'R') {
                    info[0] = i;
                    info[1] = j;
                }
                if (temp == 'B') {
                    info[2] = i;
                    info[3] = j;
                }

                arr[i][j] = temp;
            }
        }

        // 큐와 방문 배열 세팅
        q.offer(info);
        visited[info[0]][info[1]][info[2]][info[3]] = true;

        // bfs
        bfs();
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int ri = cur[0];
            int rj = cur[1];
            int bi = cur[2];
            int bj = cur[3];
            int cnt = cur[4];

            if (cnt >= 10) { // 모두 10번을 초과 -> 탈출 불가
                System.out.println(-1);
                return;
            }

            for (int dir = 0; dir < 4; dir++) { // 네 방향으로 움직임
                int[] nextR = move(ri, rj, dir);
                int[] nextB = move(bi, bj, dir);

                // 벽이나 출구를 만난 결과 검사
                if (arr[nextR[0]][nextR[1]] == 'O' && arr[nextB[0]][nextB[1]] != 'O') { // Blue가 동시에 빠지면 안 됨!
                    System.out.println(cnt + 1);
                    return;
                }
                if (arr[nextB[0]][nextB[1]] == 'O') {
                    continue;
                }

                // 이동한 위치가 겹치는 경우(이동방향상 같은 선에 있었던 경우)
                if (nextR[0] == nextB[0] && nextR[1] == nextB[1]) {
                    if (nextR[2] > nextB[2]) { // Red가 더 많이 움직인 경우
                        nextR[0] -= di[dir]; // 1칸 back
                        nextR[1] -= dj[dir];
                    } else { // Blue가 더 많이 움직인 경우
                        nextB[0] -= di[dir]; // 1칸 back
                        nextB[1] -= dj[dir];
                    }
                }

                if (!visited[nextR[0]][nextR[1]][nextB[0]][nextB[1]]) { // 방문한 적 없으면
                    visited[nextR[0]][nextR[1]][nextB[0]][nextB[1]] = true;
                    q.offer(new int[]{nextR[0], nextR[1], nextB[0], nextB[1], cnt + 1});
                }
            }
        }

        System.out.println(-1); // 탈출 불가
    }

    private static int[] move(int i, int j, int dir) {
        int cnt = 0;

        while (true) {
            int ni = i + di[dir];
            int nj = j + dj[dir];

            // 벽을 만나면 이동 하지 않고 종료
            if (arr[ni][nj] == '#') break;

            i = ni;
            j = nj;
            cnt++;

            // 구멍을 만나면 이동 완료 후 종료
            if (arr[ni][nj] == 'O') break;
        }

        return new int[]{i, j, cnt};
    }
}