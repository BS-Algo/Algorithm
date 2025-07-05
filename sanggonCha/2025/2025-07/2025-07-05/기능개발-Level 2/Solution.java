import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++) {
            days[i] = (100 - progresses[i] - 1 + speeds[i]) / speeds[i];
        }
        
        List<Integer> list = new ArrayList<>();
        int maxDay = days[0], count = 1;
        for(int i = 1; i < progresses.length; i++) {
            if (maxDay < days[i]) {
                list.add(count);
                maxDay = days[i];
                count = 1;
            } else {
                count++;
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}