import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] alphabets = new int[26];

    static StringBuilder left = new StringBuilder();
    static StringBuilder middle = new StringBuilder();
    static StringBuilder result = new StringBuilder();

    static int isOdd;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            alphabets[word.charAt(i) - 'A']++;
        }

        // 팰린드롬 여부 확인
        for (int i = 0; i < 26; i++) {

            if (alphabets[i] % 2 == 1) {
                isOdd++;
            }

            if (isOdd > 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        // 왼쪽
        for (int i = 0; i < 26; i++) {

            int count = alphabets[i] / 2;

            for (int j = 0; j < count; j++) {
                left.append((char) (i + 'A'));
            }

            if (alphabets[i] % 2 == 1) {
                middle.append((char) (i + 'A'));
            }

        }

        result.append(left).append(middle).append(left.reverse());

        System.out.println(result);

    }
}