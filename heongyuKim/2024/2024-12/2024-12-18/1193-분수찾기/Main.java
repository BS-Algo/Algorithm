import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int lineCalcul = 0;
        int line = 0;
        int numerator = 0;
        int denominator = 0;

        // num이 몇번째 줄에 있는지 확인하기
        for (int i = 1; i < 10000000; i++) {
            lineCalcul += i;

            if (lineCalcul - i < num && num <= lineCalcul) {
                line = i;
                break;
            }
        }

        // 몇번째 칸
        int block = (line - (lineCalcul - num)) - 1;

        // 홀수인지 짝수인지 판별한 후 분수 계산
        if (line % 2 == 0) {
            // 분자 분모 세팅
            numerator = 1;
            denominator = line;

            // 칸의 순서만큼 계산
            numerator += block;
            denominator -= block;

        } else {
            // 분자 분모 세팅
            numerator = line;
            denominator = 1;

            // 칸의 순서만큼 계산
            numerator -= block;
            denominator += block;
        }

        System.out.println(String.valueOf(numerator) + "/" + String.valueOf(denominator));

    }
}
