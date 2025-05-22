import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 모음을 dfs로 먼저 한개 이상 그리고 L - 2개 이하까지 선택을 한 후
// 자음을 dfs로 돌려서 선택하여 정렬한 후 결과에 추가
public class Main {
    static int L;
    static int C;

    static ArrayList<String> consonant = new ArrayList<>();
    static ArrayList<String> vowel = new ArrayList<>();
    static boolean[] visitedConsonant;
    static boolean[] visitedVowel;

    static ArrayList<String> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        L = Integer.parseInt(info.nextToken());
        C = Integer.parseInt(info.nextToken());

        StringTokenizer words = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            String word = words.nextToken();
            if (word.equals("a") || word.equals("e") || word.equals("i") || word.equals("o") || word.equals("u")) {
                vowel.add(word);
            } else {
                consonant.add(word);
            }
        }

        Collections.sort(consonant);
        Collections.sort(vowel);

        visitedConsonant = new boolean[C];
        visitedVowel = new boolean[C];

        for (int i = 1; i <= L - 2; i++) {
            dfsGather(0, i, "");
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for (String word : result) {
            sb.append(word).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dfsConsonant(int index, String words) {
        if (words.length() == L) {
            char[] chars = words.toCharArray();
            Arrays.sort(chars);
            String sortWords = new String(chars);
            result.add(sortWords);
            return;
        }

        for (int i = index; i < consonant.size(); i++) {
            if (!visitedConsonant[i]) {
                visitedConsonant[i] = true;
                dfsConsonant(i, words + consonant.get(i));
                visitedConsonant[i] = false;
            }
        }
    }

    private static void dfsGather(int index, int length, String words) {
        if (words.length() == length) {
            dfsConsonant(0, words);
            return;
        }

        for (int i = index; i < vowel.size(); i++) {
            if (!visitedVowel[i]) {
                visitedVowel[i] = true;
                dfsGather(i, length, words + vowel.get(i));
                visitedVowel[i] = false;
            }
        }
    }
}