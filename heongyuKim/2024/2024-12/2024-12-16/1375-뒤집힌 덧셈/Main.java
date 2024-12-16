import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String first = st.nextToken();
        String second = st.nextToken();

        // first 뒤집기
        StringBuilder firstSB = new StringBuilder(first);
        String newFirst = firstSB.reverse().toString();

        // second 뒤집기
        StringBuilder secondSB = new StringBuilder(second);
        String newSecond = secondSB.reverse().toString();

        // 숫자로 바꿔서 합치기
        int firstInt = Integer.parseInt(newFirst);
        int secondInt = Integer.parseInt(newSecond);
        int resultInt = firstInt + secondInt;
        String resultStr = String.valueOf(resultInt);

        StringBuilder resultDB = new StringBuilder(resultStr);
        String result = resultDB.reverse().toString();


        System.out.println(Integer.parseInt(result));
    }
}
