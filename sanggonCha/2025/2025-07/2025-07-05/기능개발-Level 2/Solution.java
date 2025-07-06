import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i =  0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                stack.push(c);
            } else if (stack.peek() == '(') {
                stack.pop();
            }
        }
        
        boolean answer = true;
        if (stack.isEmpty()) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }
}