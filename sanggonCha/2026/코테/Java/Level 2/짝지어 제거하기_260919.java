import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        // 스택 생성
        Stack<Character> stack = new Stack<>();
        
        // 초기값 투입
        stack.push(s.charAt(0));
        
        // 문자열 순회
        for (int i = 1; i < s.length(); i++) 
        {
            Character target = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));    
            }
        }

        // 비었으면 성공
        if (stack.isEmpty()) {
            answer = 1;
        }
        
        return answer;
    }
}