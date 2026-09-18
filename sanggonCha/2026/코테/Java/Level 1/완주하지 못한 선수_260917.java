import java.util.*;

class Solution {
    // 마라톤에 참여한 선수들의 이름이 담긴 배열 participant 
    // 완주한 선수들의 이름이 담긴 배열 completion
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>(); // 해쉬맵 생성
        
        for (String p: participant) { // 모든 참가자에 대하여
            map.put(p, map.getOrDefault(p, 0) + 1); // 조회값(없으면 0) + 1 해서 저장
        }
        
        for (String c: completion) { // 모든 완주자에 대하여
            map.put(c, map.get(c) - 1); // -1
        }
        
        String answer = "";
        
        for (String name: map.keySet()) {
            if (map.get(name) == 1) { // 값이 1이면 완주하지 못한 선수
                answer = name;
            }
        }        
        
        //완주하지 못한 선수의 이름
        return answer; 
    }
}