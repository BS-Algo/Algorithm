import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int hIndex = citations.length;
        while(true) {
            int count = 0;
            
            for (int i = citations.length - 1; i >= 0; i--) {
                if (citations[i] >= hIndex) {
                    count++;
                    
                    if (count >= hIndex) {
                        return hIndex;
                    }
                }
            }
            hIndex--;
        }
    }
}