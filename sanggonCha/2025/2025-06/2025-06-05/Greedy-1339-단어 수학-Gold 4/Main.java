import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 단어 입력
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine(); // 단어 입력
            int length = word.length();

            for (int j = 0; j < length; j++) {
                char c = word.charAt(j); // 앞자리부터 추출
                int weight = (int) Math.pow(10, length - j - 1); // 자릿수만큼 가중치 계산

                map.put(c, map.getOrDefault(c, 0) + weight); // map에 추가
            }
        }

        // 가중치 내림차순 정렬
        List<Integer> weights = new ArrayList<>(map.values());
        weights.sort((a, b) -> b - a);

        // greedy
        int num = 9;
        int maxSum = 0;
        for(int weight:weights) {
            maxSum += weight * num; // 가장 큰 가중치부터 9 ~ 0로 할당
            num--;
        }

        // 출력
        System.out.println(maxSum);
    }
}