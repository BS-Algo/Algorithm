import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        // '-'를 기준으로 문자열 분리
        String[] parts = expression.split("-");

        // 첫 번째 그룹의 합은 그대로 사용
        // 만약 -35+12 처럼 앞부분이 -로 시작했다면 그 앞의 빈 문자만 남게 되므로 0으로 처리한다
        // 35+23-41 처럼 앞부분이 숫자로 시작했다면, 35+23 부분만 잘리게 된다.
        int result = sum(parts[0]);

        // 나머지 그룹들의 합은 모두 뺀다
        // - 부터 다음 - 를 만날 때까지를 모두 괄호로 묶어준다고 생각하면 된다.
        // 그 사이의 값들을 괄호로 묶어서 모두 더한 다음에 빼면 항상 최대값을 빼게 되므로
        // 그리디하게 최소값이 된다.
        for (int i = 1; i < parts.length; i++) {
            result -= sum(parts[i]);
        }

        System.out.println(result);
    }

    // '+'를 기준으로 숫자를 분리한 후 총합을 반환하는 메서드
    public static int sum(String s) {
        if(s.equals("")) {
            return 0;
        }

        int total = 0;
        String[] numbers = s.split("\\+");
        for (String num : numbers) {
            total += Integer.parseInt(num);
        }
        return total;
    }
}
