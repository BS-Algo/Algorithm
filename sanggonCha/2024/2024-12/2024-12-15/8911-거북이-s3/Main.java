import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String moveCommand = br.readLine();
            int direction = 0; // 방향은 북쪽으로 초기화
            int[] currentLocation = {0, 0}; // 시작 좌표는 (0, 0)으로 초기화
            int minX = 0, maxX = 0, minY = 0, maxY = 0; // 직사각형의 넓이를 구하기 위한 변수 생성

            // 명령어를 하나씩 실행
            for (char move : moveCommand.toCharArray()) {
                switch (move) {
                    case 'F':
                        currentLocation[0] += dx[direction];
                        currentLocation[1] += dy[direction];
                        break;
                    case 'B':
                        currentLocation[0] += dx[(direction + 2) % 4];
                        currentLocation[1] += dy[(direction + 2) % 4];
                        break;
                    case 'L':
//                        direction = (direction - 1) % 4;
                        if (direction == 0) direction = 3;
                        else direction--;
                        break;
                    case 'R':
//                        direction = (direction + 1) % 4;
                        if (direction == 3) direction = 0;
                        else direction++;
                    default:
                        break;

                }
                minX = Math.min(currentLocation[0], minX);
                maxX = Math.max(currentLocation[0], maxX);
                minY = Math.min(currentLocation[1], minY);
                maxY = Math.max(currentLocation[1], maxY);
            }

            System.out.println((maxX - minX) * (maxY - minY));

        }
    }
}