import java.io.*;

public class Main {
    static int N, K;
    static int[] durability;
    static boolean[] robots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, K 입력 받기
        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]); // 길이가 2N인 벨트
        K = Integer.parseInt(NK[1]); // 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다

        // 벨트의 내구도 입력 받기
        durability = new int[2 * N];
        String[] An = br.readLine().split(" ");
        for (int i = 0; i < 2 * N; i++) {
            durability[i] = Integer.parseInt(An[i]);
        }

        // 로봇 위치 배열
        robots = new boolean[2 * N];

        conveyorOperation();
    }

    private static void conveyorOperation() {
        int stage = 0; // 단계를 저장할 변수

        while (countZeroDurability()) {
            stage++;

            // 1. 컨베이어 벨트 회전
            rotateBelt();

            // 2. 로봇 이동
            moveRobots();

            // 3. 올리는 위치에 로봇 올리기
            placeRobot();
        }

        // 출력
        System.out.println(stage);
    }

    // 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다
    private static boolean countZeroDurability() {
        int cnt = 0;
        for (int dur : durability) {
            if (dur == 0) {
                cnt++;
            }
        }
        return cnt < K;
    }

    // 컨베이어 벨트 회전
    private static void rotateBelt() {
        int lastDurability = durability[2 * N - 1];
        boolean lastRobot = robots[2 * N - 1];

        for (int i = 2 * N - 1; i > 0; i--) {
            durability[i] = durability[i - 1];
            robots[i] = robots[i - 1];
        }
        durability[0] = lastDurability;
        robots[0] = lastRobot;

        // 내리는 위치
        robots[N - 1] = false;
    }

    private static void moveRobots() {
        for (int i = N - 1; i > 0; i--) {
            if (robots[i - 1] && !robots[i] && durability[i] > 0) {
                robots[i] = true;
                robots[i - 1] = false;
                durability[i]--;
            }

        }

        robots[N - 1] = false; // 내리는 위치에서 로봇 내리기
    }

    // 올리는 위치에서 로봇 올리기
    private static void placeRobot() {
        if (durability[0] > 0) {
            robots[0] = true;
            durability[0]--;
        }
    }
}

