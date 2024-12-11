import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N 입력 받기

        String firstWord = br.readLine(); // 첫 번째 단어
        int ans = 0; // 정답 출력용 변수

        // 두 번째 단어부터 마지막 단어까지 비교
        for (int i = 1; i < N; i++) {
            String nextWord = br.readLine();
            int cnt = 0;
            int[] firstWordList = new int[26]; // 'A' 부터 'Z'까지 각 문자 개수를 셀 리스트

            // 매번 첫 번째 단어의 각 문자의 개수를 카운트
            for (int j = 0; j < firstWord.length(); j++) {
                firstWordList[firstWord.charAt(j) - 'A']++;
            }

            // 주어진 단어의 각 문자를 확인
            for (int j = 0; j < nextWord.length(); j++) {
                // 만약 현재 문자가 첫 번째 단어에 포함되어 있다면
                if (firstWordList[nextWord.charAt(j) - 'A'] > 0) {
                    firstWordList[nextWord.charAt(j) - 'A']--; // 첫 번째 단어 리스트에서 값을 감소시키고
                    cnt++; // 일치하는 문자 개수 증가(후에 다른 문자의 개수 비교를 위해 카운트)
                }
            }

            // case 1: 같은 단어 or 구성은 같고 순서만 다른 단어 or 길이는 같은데 문자 한 개만 다른 경우
            // 두 단어의 길이가 같으면서
            // 1-1 모든 문자가 일치하는 경우(cnt의 개수가 일치하면)
            // 1- 2 한 글자만 다른 경우(cnt의 개수와 1개 차이)
            if (firstWord.length() == nextWord.length() && (firstWord.length() == cnt || firstWord.length() - 1 == cnt)) {
                ans++;
            }

            // case 2: 첫 번째 단어가 한 개 더 짧은 경우
            // 두 단어가 길이가 하나 차이나면서
            // 일치하는 단어의 개수도 1개만 차이나는 경우
            else if (firstWord.length() == nextWord.length() - 1 && nextWord.length() - 1 == cnt) {
                ans++;  // 비슷한 단어로 카운트
            }

            // case 3: 첫 번째 단어가 한 개 더 긴경우
            // 두 단어가 길이가 하나 차이나면서
            // 일치하는 단어의 개수도 1개만 차이나는 경우
            else if (firstWord.length() == nextWord.length() + 1 && nextWord.length() == cnt) {
                ans++;  // 비슷한 단어로 카운트
            }
        }
        System.out.println(ans);
    }
}
