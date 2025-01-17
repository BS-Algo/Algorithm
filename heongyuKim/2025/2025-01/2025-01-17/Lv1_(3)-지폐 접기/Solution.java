import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        // 지갑의 가로 길이
        int walletWidth = wallet[0];
        
        // 지갑의 세로 길이
        int walletHeight = wallet[1];
        
        // 지폐의 가로 길이
        int billWidth = bill[0];
        
        // 지폐의 세로 길이 
        int billHeight = bill[1];
        
        // 지폐 접는 로직
        while (Math.min(billWidth, billHeight) >  Math.min(walletWidth, walletHeight) || Math.max(billWidth, billHeight) > Math.max(walletWidth, walletHeight)) {
            if (billWidth > billHeight) {
                billWidth /= 2;
            } else {
                billHeight /= 2;
            }
            
            answer++;
        }
        
        
        return answer;
    }
}