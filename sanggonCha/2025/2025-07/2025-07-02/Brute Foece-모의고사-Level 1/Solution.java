import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] count = new int[3];
        int[] arr2 = {1, 3, 4, 5};
        int[] arr3 = {3, 1, 2, 4, 5};
        for(int i = 0; i < answers.length; i++) {
            if (i % 5 + 1 == answers[i]) {
                count[0]++;
            }
            
            if (i % 2 == 0) {
                if (answers[i] == 2) {
                    count[1]++;
                }
            } else {
                if (arr2[(i / 2) % 4] == answers[i]) {
                    count[1]++;
                }
            }
            
            if (arr3[(i / 2) % 5] == answers[i]) {
                count[2]++;
            }
        }
        
        
        int maxCount = Math.max(count[0], Math.max(count[1], count[2]));
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if(count[i] == maxCount) {
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}