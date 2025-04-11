import java.io.*;
import java.util.*;


public class Main {
    static int N, M, P;
    static int[] di = {0, 0, 1, -1}, dj = {1, -1, 0, 0}, Si;
    static char[][] board;
    static Map<Integer, Queue<int[]>> players = new HashMap<>(); // 플레이어들의 좌표 정보를 저장

    static class Node {
        int i, j, depth;

        Node(int i, int j, int depth) {
            this.i = i;
            this.j = j;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M, P 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        // Si 입력 받기
        st = new StringTokenizer(br.readLine());
        Si = new int[P];
        for (int i = 0; i < P; i++) {
            Si[i] = Integer.parseInt(st.nextToken());
        }

        // 게임판 입력 받기
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (Character.isDigit(line.charAt(j))) {
                    int player = line.charAt(j) - '0';
                    Queue<int[]> castles;
                    if (players.get(player) == null) {
                        castles = new LinkedList<>();
                        castles.offer(new int[]{i, j});
                    } else {
                        castles = players.get(player);
                        castles.offer(new int[]{i, j});
                    }
                    players.put(player, castles);
                }
                board[i][j] = line.charAt(j);
            }
        }

        // bfs
        bfs();

        // 출력
        count();
    }

    // bfs
    private static void bfs() {
        // 플레이어별 큐를 Node 기반으로 변경
        Map<Integer, Queue<Node>> newPlayers = new HashMap<>();
        for (int p : players.keySet()) {
            Queue<Node> queue = new LinkedList<>();
            for (int[] pos : players.get(p)) {
                queue.offer(new Node(pos[0], pos[1], 0));
            }
            newPlayers.put(p, queue);
        }

        // 더 이상 확장이 안 될때까지 실행
        while (true) {
            boolean canExpand = false; // 확장 가능 여부를 저장할 변수

            // 한 라운드씩 진행: 모든 플레이어 확장
            for (int p = 1; p <= P; p++) {
                int limit = Si[p - 1]; // 한 라운드에서 확장 가능한 칸수

                Queue<Node> queue = newPlayers.getOrDefault(p, new LinkedList<>()); // 현재 플레이어의 성 좌표
                Queue<Node> nextQueue = new LinkedList<>(); // 다음 라운드에서 사용할 큐

                while (!queue.isEmpty()) {
                    Node cur = queue.poll();

                    // 제한 칸수만큼 다 확장했으면,
                    // 현재 큐에서는 작업을 멈추고
                    if (cur.depth == limit) {
                        // 다음 라운드에서 사용할 큐에 추가
                        nextQueue.offer(new Node(cur.i, cur.j, 0));
                        continue;
                    }

                    for (int k = 0; k < 4; k++) {
                        int ni = cur.i + di[k];
                        int nj = cur.j + dj[k];

                        if (ni >= 0 && ni < N && nj >= 0 && nj < M && board[ni][nj] == '.') {
                            board[ni][nj] = (char) (p + '0');
                            queue.offer(new Node(ni, nj, cur.depth + 1));
                            canExpand = true;
                        }
                    }
                }
                newPlayers.put(p, nextQueue); // 다음 라운드 확장을 위해서 갱신
            }

            // 확장이 한 번도 발생하지 않았다면 종료
            if (!canExpand) return;
        }
    }

    // count
    private static void count() {
        int[] result = new int[P];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Character.isDigit(board[i][j])) {
                    result[board[i][j] - '0' - 1]++;
                }
            }
        }

        for (int i = 0; i < P; i++) {
            System.out.print(result[i] + " ");
        }
    }
}