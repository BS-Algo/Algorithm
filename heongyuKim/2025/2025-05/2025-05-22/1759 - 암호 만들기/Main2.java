import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 이 코드는 모든 조합으로 만든 단어가 유효한지 체크하는 로직이다.
public class Main2 {
    static int L;
    static int C;

    static ArrayList<String> alphabets = new ArrayList<>();
    static boolean[] visited;

    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        L = Integer.parseInt(info.nextToken());
        C = Integer.parseInt(info.nextToken());

        StringTokenizer words = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabets.add(words.nextToken());
        }

        Collections.sort(alphabets);

        visited = new boolean[C];

        dfs(0,"");

        System.out.println(result.toString());

    }

    private static void dfs(int index, String words) {
        if (words.length() == L) {
            if (isValid(words)) {
                result.append(words).append("\n");    
            } 
            return;
        }

        for (int i = index; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, words + alphabets.get(i));
                visited[i] = false;
            }
        }
    }

    private static boolean isValid(String words) {
        int consonant = 0;
        int vowel = 0;

        for (int i = 0; i < words.length(); i++) {
            if (words.charAt(i) == 'a' || words.charAt(i) == 'e' || words.charAt(i) == 'i' || words.charAt(i) == 'o' || words.charAt(i) == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }

        if (consonant >= 2 && vowel >= 1) {
            return true;
        }
        return false;
    }
}