import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int s: scoville) {
            queue.offer(s);
        }
        
        int count = 0;
        while(true) {
            int s1 = queue.poll(); // 가장 맵지 않은 음식의 스코빌 지수
            if (s1 >= K) {
                return count;
            }
            
            if (queue.isEmpty()) {
                return -1;
            }
            int s2 = queue.poll(); // 두 번째로 맵지 않은 음식의 스코빌 지수
            int mixedS = s1 + s2 * 2;
            queue.offer(mixedS);
            
            count++;
        }
    }
}