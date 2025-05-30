import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] plate = new int[19][19];
        for (int i = 0; i < 19; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 19; j++) {
                plate[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 검은 바둑알은 1, 흰 바둑알은 2, 알이 놓이지 않는 자리는 0
        checkWinner(plate);
    }

    private static boolean checkPenta(int[][] plate, int i, int j, int target) {
        // 세로
        int k = 1;
        // 가장 왼쪽에 있는 바둑알의 가로줄 번호와, 세로줄 번호를 순서대로 출력한다
        // 그래서 오른쪽 아래로 증가하는 방향으로 탐ㅅ핵
        while (i + k < 19 && plate[i + k][j] == target) k++;
        if (k == 5) { // 만약, 다섯 개가 연속한 상태라면, 혹시나 이전의 돌이 같은 돌이 아닌지 체크
            if (i - 1 >= 0) { // 인덱스부터 검사
                if (plate[i - 1][j] != target) return true; // 같은 돌이 아니라면 다섯 개만 연속하는 경우
            } else return true; // 인덱스를 벗어난다면 당연히 다섯 개만 연속
        }
        // 가로
        k = 1;
        while (j + k < 19 && plate[i][j + k] == target) k++;
        if (k == 5) {
            if (j - 1 >= 0) {
                if (plate[i][j - 1] != target) return true;
            } else return true;
        }

        // 대각선 1
        k = 1;
        while (i + k < 19 && j + k < 19 && plate[i + k][j + k] == target) k++;
        if (k == 5) {
            if (i - 1 >= 0 && j - 1 >= 0) {
                if (plate[i - 1][j - 1] != target) return true;
            } else return false;
        }

        // 대각선 2
        // 가장 왼쪽에 있는 바둑알의 가로줄 번호와, 세로줄 번호를 순서대로 출력한다
        k = 1;
        while (i - k >= 0 && j + k < 19 && plate[i - k][j + k] == target) k++;
        if (k == 5) {
            if (i + 1 < 19 && j - 1 >= 0) {
                if (plate[i + 1][j - 1] != target) return true;
            } else return true;
        }

        return false;
    }

    private static void checkWinner(int[][] plate) {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (plate[i][j] == 1) if (checkPenta(plate, i, j, 1)) {
                    System.out.println(1);
                    System.out.printf("%d %d", i + 1, j + 1);
                    return;
                }
                if (plate[i][j] == 2) if (checkPenta(plate, i, j, 2)) {
                    System.out.println(2);
                    System.out.printf("%d %d", i + 1, j + 1);
                    return;
                }
            }
        }
        System.out.println(0); // 아직 승부가 결정되지 않았을 경우에는 0을 출력한다
    }
}