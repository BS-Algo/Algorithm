import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 결과로 출력할 배열
        StringBuilder result = new StringBuilder();

        // stack 생성
        Stack<Character> stack = new Stack<>();

        // Stringbuilder로 뒤집기
        StringBuilder sb = new StringBuilder();

        // 리버스 여부
        boolean isReverse = true;

        // stack에 넣기
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // >, <, " " 여부에 따라서 분기
        for (int i = 0; i < input.length(); i++) {
            char last = stack.pop();

            if (last == '>') {
                if (!sb.isEmpty()) {
                    result.append(sb.reverse());
                    sb.setLength(0);
                }

                isReverse = false;
                sb.append(last);

            } else if (last == '<') {
                isReverse = true;
                sb.append(last);
                result.append(sb);
                sb.setLength(0);
            } else if (last == ' ') {
                if (isReverse) {
                    result.append(sb.reverse());
                } else {
                    result.append(sb);
                }

                result.append(last);
                sb.setLength(0);
            } else {
                sb.append(last);
            }

            if (stack.isEmpty()) {
                if (isReverse) {
                    result.append(sb.reverse());
                } else {
                    result.append(sb);
                }
            }
        }

        System.out.println(result.reverse().toString());

    }
}