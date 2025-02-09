import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    // 100 * 100 판을 생성
    static char[][] maze = new char[100][100];
    
    // 현재 방향 - 처음 방향은 남쪽 즉, 아래
    static int currentDirection = 0;
    
    // 최대 위
    static int maxUp = 49;
    // 최대 아래
    static int maxUnder = 49;
    // 최대 왼쪽
    static int maxLeft = 49;
    // 최대 오른쪽
    static int maxRight = 49;

    // 방향에 따른 이동 - 아래, 오른쪽, 위, 왼쪽
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    // 출력할 결과
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 홍준이가 적은 내용의 길이
        int count = Integer.parseInt(br.readLine());

        // 입력 받은 커맨드
        String command = br.readLine();

        // 판을 #으로 세팅하기
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                maze[i][j] = '#';
            }
        }

        // 현재 위치
        int x = 49;
        int y = 49;

        // 현재 위치에 점찍기
        maze[x][y] = '.';

        // 커맨드 입력을 보면서 방향을 정하거나
        for (int i = 0; i < count; i++) {

            if (command.charAt(i) == 'F') {
                x += dx[currentDirection];
                y += dy[currentDirection];

                maze[x][y] = '.';

                maxUp = Math.min(maxUp, x);
                maxUnder = Math.max(maxUnder, x);
                maxLeft = Math.min(maxLeft, y);
                maxRight = Math.max(maxRight, y);

            } else {
                switch (command.charAt(i)) {
                    case 'L':
                        currentDirection--;
                        if (currentDirection == -1) {
                            currentDirection = 3;
                        }
                        break;

                    case 'R':
                        currentDirection = (currentDirection + 1) % 4;
                        break;
                }

            }
        }

        // 출력하기
        for (int i = maxUp; i <= maxUnder; i++) {
            for (int j = maxLeft; j <= maxRight; j++) {
                result.append(maze[i][j]);
            }

            if (i != maxUnder) {
                result.append('\n');
            }

        }

        System.out.println(result.toString());
    }
}