import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int order = commands[i][2] - 1;
            
            int length = end - start + 1;
            
            int[] arr = new int[length];
            for (int j = 0; j < length; j++) {
                arr[j] = array[j + start];
            }
            
            Arrays.sort(arr);
            answer[i] = arr[order];
        }
        
        return answer;
    }
}