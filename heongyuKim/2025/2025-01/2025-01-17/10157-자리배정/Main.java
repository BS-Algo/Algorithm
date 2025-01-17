import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로와 세로 받기 가로는 col 세로는 row로 생각하기
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        // 대기순서 K 받기
        int K = Integer.parseInt(br.readLine());

        // 만약 관객에게 좌석을 배정할 수 없는 경우에는 0을 출력
        if (K > col * row) {
            System.out.println(0);
            return;
        }

        // 받은 가로와 세로를 통해서 숫자 배열을 만들기
        int[][] seats = new int[row][col];

        // 결과로 나타낼 가로와 세로 변수 생성
        int x = 1;
        int y = 1;

        // 방향을 나타낼 dx, dy 생성
        // 방향 순서는 왼쪽 아래부터 시작이기 때문에 위, 오른쪽, 아래, 왼쪽 순으로 시작
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[] qx = {0, 1, 0, -1};
        int[] qy = {1, 0, -1, 0};

        int direction = 0;
        int currentRow = row - 1;
        int currentCol = 0;
        int currentNum = 1;

        seats[currentRow][currentCol] = currentNum;

        // 반복문을 통해서 돌기
        while (currentNum <= row * col) {

            if (currentNum == K) {
                System.out.println(x + " " + y);
                return;
            }

            // 만약 다음 자리가 범위를 벗어나거나 숫자가 있다면 방향을 틀기
            if (currentRow + dx[direction] >= row || currentRow + dx[direction] < 0 || currentCol + dy[direction] >= col || currentCol + dy[direction] < 0 || seats[currentRow + dx[direction]][currentCol + dy[direction]] > 0) {
                switch (direction) {
                    case 0:
                        direction = 1;
                        break;
                    case 1:
                        direction = 2;
                        break;
                    case 2:
                        direction = 3;
                        break;
                    case 3:
                        direction = 0;
                        break;
                }
            }

            // seats에서 현재 위치 바꿔주기
            currentRow += dx[direction];
            currentCol += dy[direction];

            // 결과 좌표에서의 현재 위치 바꿔주기
            x += qx[direction];
            y += qy[direction];

            // 배열에 값 입력
            seats[currentRow][currentCol] = currentNum;
            currentNum++;

        }

    }
}