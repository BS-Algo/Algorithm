import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        // dp 배열에는 현재까지 A가 남긴 흔적을 기록
        // 행의 개수 -> 물건의 개수만큼 행이 존재
        // 열의 개수 -> 현재까지 B가 남긴 흔적을 기록 -> 0 ~ m-1 칸까지 존재
        int[][] dp = new int[info.length + 1][m];
        
        for (int i = 1; i <= info.length; i++) {
            Arrays.fill(dp[i], n); // 우선은 A가 남길 수 없는 흔적의 최솟값인 n으로 모두 채우기
        }
        
        for (int i = 0; i < info.length; i++) {
            int traceA = info[i][0]; // A가 남길 흔적
            int traceB = info[i][1]; // B가 남길 흔적
            
            for (int j = 0; j < m; j++) {
                // i 번 째 물건을 A가 훔치는 경우
                if (dp[i][j] != n) {
                    dp[i + 1][j] = Math.min(dp[i][j] + traceA, dp[i + 1][j]);
                }
                
                // i 번 째 물건을 B가 훔치는 경우
                if (j + traceB < m) { // B가 남긴 흔적이 m 이상이라면 불가능함!
                    dp[i + 1][j + traceB] = Math.min(dp[i][j], dp[i + 1][j + traceB]);
                }
            }
        }
        
        int answer = n;
        for (int j = 0; j < m; j++) {
            answer = Math.min(answer, dp[info.length][j]);
        }
        
        if (answer == n) return -1;
        else return answer;
    }
}