import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nums = br.readLine();
        StringTokenizer first = new StringTokenizer(nums, "0");
        StringTokenizer second = new StringTokenizer(nums, "1");


        System.out.println(Math.min(first.countTokens(), second.countTokens()));
    }
}