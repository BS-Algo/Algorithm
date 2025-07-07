import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // 1. numbers배열(integer형)을 문자열로 변환
        String[] numbersString = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersString[i] = String.valueOf(numbers[i]);
        }
        
        // 2. 이어붙였을 때 크기가 큰 순으로 정렬(내림차순)
        Arrays.sort(numbersString, (a, b) -> (b + a).compareTo(a + b));
        
        // 3. 예외 처리: 맨 앞이 0이면 (즉, 전부 0이면) → "0"만 리턴
        if (numbersString[0].equals("0")) return "0";
        
        // 4. 이어붙이기
        String answer = "";
        for (String numberString: numbersString) {
            answer += numberString;
        }
        
        return answer;
    }
}