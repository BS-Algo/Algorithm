import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int cnt = 0;
        for (int[] command: commands) {
            int start = command[0] - 1;
            int end = command[1];
            int idx = command[2] - 1;
            
            int[] now_arr = Arrays.copyOfRange(array, start, end);
            
            Arrays.sort(now_arr);
            answer[cnt++] = now_arr[idx];
        }
        
        return answer;
    }
}