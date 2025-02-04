import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    static Stack<int[]> stack = new Stack<>();
    
    // 탐색에 사용할 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 출력을 위한 변수
    static int minHeight = 11;
    static int maxHeight;
    static int minWidth = 11;
    static int maxWidth;

    // 결과로 출력하기 위한 StringBuilder
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 섬 받기
        char[][] island = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] particular = br.readLine().toCharArray();
            island[i] = particular;
        }

        // 4방향 탐색을 하면서 바다에 잠길 섬이면 스택에 정보를 저장
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int check = 0;
                for (int e = 0; e < 4; e++) {
                    
                    // 범위 안에 있을 때
                    if (i + dx[e] > -1 && i + dx[e] < R && j + dy[e] > -1 && j + dy[e] < C) {
                        if ((island[i][j] == 'X') && (island[i + dx[e]][j + dy[e]] == '.')) {
                            check++;
                        }
                    } else {
                        if ((island[i][j] == 'X')) {
                            check++;
                        }
                    }
                }

                if (check > 2) {
                    stack.push(new int[]{i, j});
                }
            }
        }

        // 저장해 둔 정보를 처리하기
        while (!stack.isEmpty()) {
            int[] info = stack.pop();
            int x = info[0];
            int y = info[1];

            island[x][y] = '.';
        }

        // 출력에 필요한 변수에 값 넣기
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (island[i][j] == 'X') {
                    minHeight = Math.min(minHeight, i);
                    maxHeight = Math.max(maxHeight, i);
                    minWidth = Math.min(minWidth, j);
                    maxWidth = Math.max(maxWidth, j);
                }
            }
        }

        for (int i = minHeight; i <= maxHeight; i++) {
            for (int j = minWidth; j <= maxWidth; j++) {
                sb.append(island[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}