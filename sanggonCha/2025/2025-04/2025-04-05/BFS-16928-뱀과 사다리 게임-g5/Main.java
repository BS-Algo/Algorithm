import java.io.*;
import java.util.*;

public class Main {
    static int[] board = new int[101];
    static int[] portal = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 사다리, 뱀 입력 받기
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            portal[start] = end;
        }

        // bfs
        bfs(1);

        // 출력
        System.out.println(board[100]);
    }

    private static void bfs(int start) {

        // Queue 생성 및 세팅
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int dice = 1; dice <= 6; dice++) {
                int next = now + dice;
                if (next > 100) continue;

                // 포탈이 존재한다면 이동
                if (portal[next] != 0) {
                    next = portal[next];
                }

                // 아직 방문하지 않은 경우만
                if (board[next] == 0) { // 방문하지 않았다면
                    board[next] = board[now] + 1; // 방문 처리
                    queue.offer(next);
                }

                // 도착하면 바로 종료
                if (next == 100) return;
            }
        }
    }
}