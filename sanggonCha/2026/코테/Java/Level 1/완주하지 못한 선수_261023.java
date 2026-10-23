import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 참가자 등록
        Map<String, Integer> map = new HashMap<>();
        for (String p: participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 완주자 제거
        for (String c: completion) {
            map.put(c, map.get(c) - 1);
        }
        
        // 미완주자 찾기
        for (String k: map.keySet()) {
            if (map.get(k) == 1) {
                answer = k;
                break;
            }
        }
        
        return answer;
    }
}