import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answerCount = Integer.parseInt(br.readLine());

        // 결과
        int result = 0;

        // 숫자와 스트라이크와 볼을 담을 배열 생성
        int[][] info = new int[answerCount][3];

        // 값을 담기
        for (int i = 0; i < answerCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 3; j++) {
                info[i][0] = num;
                info[i][1] = strike;
                info[i][2] = ball;
            }
        }

        // 123부터 999까지 체크하면서 숫자에 대한 스트라이크와 볼에 대한 조건을 만족하면 result에 1 더하기
        for (int i = 123; i < 1000; i++) {
            String compareNum = String.valueOf(i);
            // 맞는 조건의 갯수
            int check = 0;
            
            if (compareNum.charAt(0) == compareNum.charAt(1) || compareNum.charAt(0) == compareNum.charAt(2) || compareNum.charAt(1) == compareNum.charAt(2) || compareNum.charAt(0) == '0' || compareNum.charAt(1) == '0' || compareNum.charAt(2) == '0') {
                continue;
            }

            for (int j = 0; j < answerCount; j++) {
                String currentNum = String.valueOf(info[j][0]);
                // 스트라이크 및 볼 갯수
                int strike = 0;
                int ball = 0;
                for (int q = 0; q < 3; q++) {
                    // 스트라이크 및 볼 판별
                    if (compareNum.charAt(q) == currentNum.charAt(q)) {
                        strike++;
                    } else if (compareNum.indexOf(currentNum.charAt(q)) != -1) {
                        ball++;
                    }
                }

                if (info[j][1] == strike && info[j][2] == ball) {
                    check++;
                }
            }

            if (check == answerCount) {
                result++;
            }
        }
        System.out.println(result);
    }
}