import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// 너무 단순하게 생각하는 경향이 있어서 많이 해매는 듯하다...
// 높은 자리 순으로 단순히 정렬하는 것이 아닌 각 알파벳마다 총합을 구해서 정렬해야하는 문제였다...
class Main {

    static int[] arr = new int[26];

    static long result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                arr[ch - 'A'] += (int) Math.pow(10, word.length() - j - 1);
            }
        }

        Arrays.sort(arr);

        int rank = 9;
        for (int i = 25; i > -1; i--) {
            if (arr[i] == 0) {
                break;
            }

            result += (long) arr[i] * rank;
            rank--;
        }

        System.out.println(result);
    }
}