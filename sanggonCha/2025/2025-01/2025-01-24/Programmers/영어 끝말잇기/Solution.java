import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> dictionary = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            if (i != 0) { // 첫 번째 단어는 검사 제외
                // 이전 단어의 마지막 글자와 현재 단어의 첫 글자가 일치하지 않는 다면 종료
                if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0) ||
                        dictionary.contains(words[i])) { // 중복 단어라면 종료
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;
                    break;
                }
            }
            dictionary.add(words[i]);
        }
        return answer;
    }
}