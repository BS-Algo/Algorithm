import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 수 입력
        Map<Character, Long> weightMap = new HashMap<>(); // 가중치를 저장할 맵
        Set<Character> firstChars = new HashSet<>(); // 맨 앞자리에 오는 문자를 저장할 셋

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            firstChars.add(input.charAt(0)); // 제일 앞 문자 기록

            int numLength = input.length();

            for (int j = 0; j < numLength; j++) {
                Character ch = input.charAt(j); // 현재 문자
                Long weight = (long) Math.pow(10, numLength - 1 - j); // 자리수를 고려한 가중치

                weightMap.put(ch, weightMap.getOrDefault(ch, 0L) + weight); // 맵에 가중치 누적합 저장
            }
        }

        // greedy - 가중치 내림차순 정렬
        List<Character> chars = new ArrayList<>(weightMap.keySet());
        chars.sort((a, b) -> Long.compare(weightMap.get(b), weightMap.get(a))); // 가중치 내림차순 정렬

        // 10개 알파벳이 모두 사용된 경우: 반드시 0이 사용되므로 예외처리 필요!!
        if (chars.size() == 10) {
            for (int idx = chars.size() - 1; idx >= 0; idx--) { // 가중치 작은 것부터 확인
                Character ch = chars.get(idx);
                if (!firstChars.contains(ch)) { // 첫 번째 문자에 포함되지 않았다면
                    chars.remove(ch); // 제거 후
                    chars.add(ch); // 제일 뒤로 이동(가중치는 더 크지만 얘가 0을 할당 받을 예정)
                    break;
                }
            }
        }

        // 주어진 순서대로 수(9->0)를 할당
        long ans = 0;
        int allocateDigit = 9;
        for (Character ch : chars) {
            ans += allocateDigit-- * weightMap.get(ch);
        }

        // 출력
        System.out.println(ans);
    }
}