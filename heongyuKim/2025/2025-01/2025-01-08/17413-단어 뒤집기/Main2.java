import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 결과로 출력할 배열
        StringBuilder result = new StringBuilder();

        // StringBuilder로 stack 생성
        StringBuilder stack = new StringBuilder();

        // Stringbuilder로 뒤집기
        StringBuilder sb = new StringBuilder();

        // 리버스 여부
        boolean isReverse = true;

        // StringBuilder로 만들어진 stack에 넣기
        for (int i = 0; i < input.length(); i++) {
            stack.append(input.charAt(i));
        }

        // >, <, " " 여부에 따라서 분기
        for (int i = 0; i < input.length(); i++) {
            char last = stack.charAt(stack.length() - 1);
            stack.deleteCharAt(stack.length() - 1);

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