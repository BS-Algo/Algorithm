import java.util.*;

class Solution {

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int r;
    static int c;

    public int solution(String[] board) {

        int answer = 0;

        // 격자판 가로, 세로
        r = board.length;
        c = board[0].length();

        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i].charAt(j) == 'R') {
                    // 시작점
                    int sr = i;
                    int sc = j;

                    visited[i][j] = true;
                    answer = bfs(new Node(sr, sc, 0), board, visited);
                }
            }
        }

        return answer;
    }

    public int bfs(Node start, String[] board, boolean[][] visited) {
        Queue<Node> queue = new LinkedList<>();
        visited[start.row][start.col] = true;

        // 시작 노드 넣기
        queue.add(start);
        
        // queue가 비워 질때까지 반복
        while (!queue.isEmpty()) {

            Node curr = queue.poll();
            int curRow = curr.row;
            int curCol = curr.col;

            if (board[curRow].charAt(curCol) == 'G') {
                return curr.count;
            }

            // 방향별 시작
            for (int i = 0; i < 4; i++) {

                int nextRow = curRow;
                int nextCol = curCol;

                while (true) {
                    int nxtNextRow = nextRow + dx[i];
                    int nxtNextCol = nextCol + dy[i];

                    // 범위에서 벗어나거나 벽에 부딪히면 방향전환
                    if (nxtNextRow < 0 || nxtNextRow >= r || nxtNextCol < 0 || nxtNextCol >= c || board[nxtNextRow].charAt(nxtNextCol) == 'D') {
                        break;
                    }

                    nextRow = nxtNextRow;
                    nextCol = nxtNextCol;
                }

                if (!visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    Node next = new Node(nextRow, nextCol, curr.count + 1);
                    queue.add(next);
                }

            }
        }

        return -1;
    }


    public class Node {
        int row;
        int col;
        int count;

        public Node(int r, int c, int count) {
            this.row = r;
            this.col = c;
            this.count = count;
        }

    }
}