import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int result;

    static int[] alphabets = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 주어지는 단어의 갯수
        int words = Integer.parseInt(br.readLine());

        char[] standard = br.readLine().toCharArray();

        for (int i = 0; i < words - 1; i++) {
            int count = 0;

            char[] compare = br.readLine().toCharArray();

            // 처음 단어의 구성을 저장하기
            for (int e = 0; e < standard.length; e++) {
                alphabets[standard[e] - 'A']++;
            }

            for (int j = 0; j < compare.length; j++) {
                if (alphabets[compare[j] - 'A'] > 0) {
                    count++;
                    alphabets[compare[j] - 'A']--;
                }

            }

            if (standard.length == compare.length && (standard.length == count || standard.length - 1 == count)) {
                result++;
            }

            if (standard.length == compare.length - 1 && compare.length - 1 == count) {
                result++;
            }

            if (standard.length == compare.length + 1 && compare.length == count) {
                result++;
            }
        }

        System.out.println(result);
    }
}