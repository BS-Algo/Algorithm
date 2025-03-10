import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이 문제에서는 연속된 부분을 0인 부분과 1인 부분을 카운트하여 더 작은 부분으로 결과를 출력하면 되는 문제였다.
class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nums = br.readLine();
        StringTokenizer first = new StringTokenizer(nums, "0");
        StringTokenizer second = new StringTokenizer(nums, "1");


        System.out.println(Math.min(first.countTokens(), second.countTokens()));
    }
}