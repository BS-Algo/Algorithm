import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String S = br.readLine();
        String T = br.readLine();

        // greedy: 역방향으로 접근 - T -> S로
        // A와 B를 추가하는 방법은 한 가지밖에 안 존재함
        // 그렇기에 경로는 한 가지고, 정답도 한 가지만 존재함!
        // 그래서 이 방식으로 풀 수 있는 것
        int lenS = S.length(), lenT = T.length();
        boolean isReverse = false;

        while (lenS != lenT) {
            char lastChar;
            if (isReverse) {
                lastChar = T.charAt(0); // 역방향
            } else {
                lastChar = T.charAt(lenT - 1); // 정바향
            }

            if (lastChar == 'A') { // A 제거
                // 1. 정방향: 뒤에서 제거
                if (!isReverse) T = T.substring(0, lenT - 1);
                    // 1. 역방향: 앞에서 제거
                else T = T.substring(1, lenT);
            } else {
                // 1. 정방향: 뒤에서 제거
                if (!isReverse) T = T.substring(0, lenT - 1);
                    // 1. 역방향: 앞에서 제거
                else T = T.substring(1, lenT);

                // 2. 방향 전환
                isReverse = !isReverse;
            }

            lenT--; // 3. 길이 감소
        }

        // 방향 고려
        if (isReverse) {
            T = new StringBuilder(T).reverse().toString();
        }

        // 출력
        if (S.equals(T)) System.out.println(1);
        else System.out.println(0);

    }
}