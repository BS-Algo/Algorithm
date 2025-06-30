import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        
        int numberLength = number.length();
        for(int numberIndex = 0; numberIndex < numberLength; numberIndex++) {
            int current = number.charAt(numberIndex) - '0';
            
            // 스택이 비어있지 않고, 현재 숫자가 스택 맨 위보다 크고, 아직 제거할 수 있다면
            while (!stack.isEmpty() && stack.peek() < current && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(current);
        }

        // 아직 제거할 수 있는 횟수가 남아있다면
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        String answer = "";
        while(!stack.isEmpty()) {
            answer = stack.pop() + answer;
        }
        
        return answer;
    }
}