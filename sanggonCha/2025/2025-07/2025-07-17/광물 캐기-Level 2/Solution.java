import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {

        // 1. 내가 가진 총 곡괭이 수 계산
        int totalPicks = picks[0] + picks[1] + picks[2];
        
        // 2. 채광 가능한 덩어리들만 리스트에 추가
        int[][] mineralCount = new int[(minerals.length - 1) / 5 + 1][5];
        for (int i = 0; i < minerals.length && i < totalPicks * 5; i++) {
            if (minerals[i].equals("diamond")) mineralCount[i / 5][0]++;
            else if (minerals[i].equals("iron")) mineralCount[i / 5][1]++;
            else mineralCount[i / 5][2]++;
        }
        
        // 3. 채광 가능한 덩어리들 내에서 정렬
        Arrays.sort(mineralCount, (a, b) -> {
            if (a[0] != b[0])  return b[0] - a[0];
            return b[1] - a[1];
        });
        
        // 4. 피로도 계산
        int answer = 0;
        for (int i = 0; i < mineralCount.length; i++) {
            if (picks[0] > 0) {
                picks[0]--;
                answer += mineralCount[i][0] + mineralCount[i][1] + mineralCount[i][2];
            } else if (picks[1] > 0) {
                picks[1]--;
                answer += mineralCount[i][0] * 5 + mineralCount[i][1] + mineralCount[i][2];
            } else if (picks[2] > 0) {
                picks[2]--;
                answer += mineralCount[i][0] * 25 + mineralCount[i][1] * 5 + mineralCount[i][2];
            }
        }
        
        return answer;
    }
}