import java.util.*;

class Solution2 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        // 지폐 접는 로직
        while (Math.min(bill[0], bill[1]) >  Math.min(wallet[0], wallet[1]) || Math.max(bill[0], bill[1]) > Math.max(wallet[0], wallet[1])) {
            bill[bill[0] > bill[1] ? 0 : 1] /= 2;
            answer++;
        }
        
        return answer;
    }
}