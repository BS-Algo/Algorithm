import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputs = br.readLine();

        if (isJavaFormat(inputs)) { // java 형식인지 체크
            System.out.println(convertToCpp(inputs)); // java -> c++ 형식 변환
        } else if (isCppFormat(inputs)) { // c++ 형식인지 체크
            System.out.println(convertToJava(inputs)); // c++ -> java 형식 변환
        } else {
            System.out.println("Error!");
        }
    }

    // 첫 단어는 소문자로 쓰고, 다음 단어부터는 첫 문자만 대문자로 쓴다
    private static boolean isJavaFormat(String inputs) {
        return inputs.matches("^[a-z][a-zA-Z]*$");
    }
    /*
    ^            : 문자열의 시작
    [a-z]        : 첫 글자는 소문자 (a부터 z)
    [a-zA-Z]*    : 그 뒤에 0개 이상의 소문자 또는 대문자가 올 수 있음
    $            : 문자열의 끝
    */

    // C++에서는 변수명에 소문자만 사용한다. 단어와 단어를 구분하기 위해서 밑줄('_')을 이용한다.
    private static boolean isCppFormat(String inputs) {
        return inputs.matches("^[a-z]+(_[a-z]+)*$*");
    }
    /*
    ^            : 문자열의 시작
    [a-z]+       : 소문자(a-z)가 1개 이상 등장
    (_[a-z]+)*   : 밑줄(_)이 있고 그 뒤에 소문자(a-z)가 1개 이상 등장하는 패턴이 0개 이상 반복됨
    $            : 문자열의 끝
    */


    private static String convertToJava(String inputs) {
        StringBuilder result = new StringBuilder();
        boolean toUpper = false;

        for (char ch : inputs.toCharArray()) {
            if (ch == '_') { // 밑줄을 만나면
                toUpper = true; // 대문자 변환 변수만 true로 변경
            } else {
                if (toUpper) { // 대문자 변환 변수가 true라면 = 이전에 밑줄을 만났다면
                    result.append(Character.toUpperCase((ch))); // 현재 문자를 대문자로 변환하고
                    toUpper = false; // 대문자 변환 변수를 다시 false로 복구
                } else {
                    result.append(ch); // 소문자 그대로 붙이기
                }
            }
        }

        return result.toString();
    }

    private static String convertToCpp(String inputs) {
        StringBuilder result = new StringBuilder();

        for (char ch : inputs.toCharArray()) {
            if (Character.isUpperCase(ch)) { // 현재 문자가 대문자라면
                result.append('_'); // 밑줄을 붙이고
                result.append(Character.toLowerCase(ch)); // 소문자로 변환해서 붙이기
            } else { // 현재 문자가 대문자가 아니라면
                result.append(ch); // 그냥 붙이기
            }
        }

        return result.toString();
    }
}