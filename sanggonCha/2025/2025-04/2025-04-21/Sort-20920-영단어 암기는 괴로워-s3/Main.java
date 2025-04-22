import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordCount = new HashMap<>();

        // 단어 입력 받기
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) { // 외울 단어 길이보다 긴 단어만 외우기
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        // 단어 리스트에 담기
        List<String> words = new ArrayList<>(wordCount.keySet());

        // 정렬하기
        Collections.sort(words, (a, b) -> {
            if (!wordCount.get(a).equals(wordCount.get(b))) {
                return wordCount.get(b) - wordCount.get(a); // 1. 등장 횟수 내림차순 - a-b: 내림차순 / b-a: 오름차순
            } else if (a.length() != b.length()) {
                return b.length() - a.length();             // 2. 길이 내림차순
            } else {
                return a.compareTo(b);                      // 3. 알파벳 오름차순
            }
        });

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String word : words) {
            bw.write(word);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}