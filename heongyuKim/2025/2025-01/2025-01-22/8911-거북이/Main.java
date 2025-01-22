import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 거북이가 가로로 얼마나 갔는지 변수
    static int turtleMaxWidth;
    static int turtleMinWidth;

    // 거북이가 세로로 얼마나 갔는지 변수
    static int turtleMaxHeight;
    static int turtleMinHeight;

    // 거북이의 현재 위치
    static int currentRow;
    static int currentCol;

    // 현재 방향을 정하는 변수
    static int currentDirection;

    // 테스트 케이스 수
    static int testCase;

    // 현재 테스트 케이스에 대한 컨트롤
    static String currentTestCase;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 받기
        testCase = Integer.parseInt(br.readLine());

        // 테스트 케이스 수만큼 반복
        for (int i = 0; i < testCase; i++) {
            currentTestCase = br.readLine();

            currentRow = 0;
            currentCol = 0;
            turtleMaxWidth = 0;
            turtleMinWidth = 0;
            turtleMaxHeight = 0;
            turtleMinHeight = 0;

            for (int j = 0; j < currentTestCase.length(); j++) {
                switch (currentTestCase.charAt(j)) {
                    case 'F':
                        directionMove(1);
                        break;
                    case 'B':
                        directionMove(-1);
                        break;
                    case 'L':
                        changeDirection(-1);
                        break;
                    case 'R':
                        changeDirection(1);
                        break;
                }
            }

            // 결과 출력
            if (i != testCase - 1) {
                System.out.println((turtleMaxWidth - turtleMinWidth) * (turtleMaxHeight - turtleMinHeight));
            } else {
                System.out.println((turtleMaxWidth - turtleMinWidth) * (turtleMaxHeight - turtleMinHeight));
            }
        }
    }

    static void directionMove(int distance) {

        switch (currentDirection) {
            case 0:
                currentRow += distance;
                break;
            case 1:
                currentCol += distance;
                break;
            case 2:
                currentRow -= distance;
                break;
            case 3:
                currentCol -= distance;
                break;
        }

        turtleMinWidth = Math.min(turtleMinWidth, currentRow);
        turtleMaxWidth = Math.max(turtleMaxWidth, currentRow);
        turtleMinHeight = Math.min(turtleMinHeight, currentCol);
        turtleMaxHeight = Math.max(turtleMaxHeight, currentCol);

    }

    static void changeDirection(int change) {
        currentDirection = (currentDirection + change + 4) % 4;
    }


}