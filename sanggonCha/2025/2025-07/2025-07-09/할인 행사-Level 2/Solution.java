import java.util.*;

class Solution {
    static int answer = 0;
    static Map<String, Integer> wantMap = new HashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {
        // 1. wantMap 등록
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        // 2. nowMap 등록
        Map<String, Integer> nowMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            nowMap.put(discount[i], nowMap.getOrDefault(discount[i], 0) + 1);
        }
        
        // 3. 슬라이딩 윈도우
        int left = 0, right = 10;
        int diff = discount.length - 10;
        check(nowMap);
        while (diff-- > 0) {
            nowMap.put(discount[left], nowMap.getOrDefault(discount[left], 1) - 1);
            nowMap.put(discount[right], nowMap.getOrDefault(discount[right], 0) + 1);
            left++; right++;
            check(nowMap);
        }
        
        return answer;
    }
    
    private static void check(Map<String, Integer> nowMap) {
        for (String key: wantMap.keySet()) {
            int nowCount = nowMap.getOrDefault(key, 0);
            int wantCount = wantMap.get(key);
            if (nowCount < wantCount) {
                return;
            }
        }
        answer++;
    }
}