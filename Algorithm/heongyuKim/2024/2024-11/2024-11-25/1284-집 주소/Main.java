import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int number = scanner.nextInt(); // 숫자 입력 받기
            int result = 0; // 결과값 초기화

            // 만약 0이면 종료
            if (number == 0) break;

            // 숫자를 문자열로 변환 후 각 자리 분리
            String numberString = String.valueOf(number);
            int[] digits = new int[numberString.length()]; // 각 자리를 저장할 배열 생성


            for (int i = 0; i < numberString.length(); i++) {
                digits[i] = Character.getNumericValue(numberString.charAt(i));
            }

            // 숫자 사이의 여백은 숫자의 길이의 +1
            result += numberString.length() + 1;

            // 1이면 2cm, 0이면 4cm, 나머지는 3cm
            for (int digit : digits) {
                if (digit == 1) {
                    result += 2;
                } else if (digit == 0) {
                    result += 4;
                } else {
                    result += 3;
                }
            }

            System.out.println(result);


        }

        scanner.close();

    }
}
