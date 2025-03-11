import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    // 결과로 출력할 변수
    static int result = 0;

    // 레벨별 점수를 담을 배열
    static int[] scores;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 레벨의 수
        int level = Integer.parseInt(br.readLine());

        // 배열 생성
        scores = new int[level];

        for (int i = 0; i < level; i++) {
            int score = Integer.parseInt(br.readLine());

            scores[i] = score;
        }

        // 현재의 값이 이전 값보다 작으면 이전 값을 차감하기
        for (int i = level - 1; i > 0; i--) {

            if (scores[i - 1] >= scores[i]) {
                int subtraction = (scores[i - 1] - scores[i]) + 1;

                result += subtraction;
                scores[i - 1] -= subtraction;
            }
        }

        System.out.println(result);
    }
}