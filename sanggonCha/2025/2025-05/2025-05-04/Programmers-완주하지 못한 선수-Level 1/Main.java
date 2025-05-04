import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) { // 참가자를 map에 모두 카운트
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) { // 완주자가 있으면 map에서 -1
            map.put(c, map.get(c) - 1);
        }

        for (String name : map.keySet()) {
            if(map.get(name) > 0) { // 0이 안 되고 남아 있다면, 동명이인이 존재하거나 완주하지 못한 것
                return name; // 한 명만 리턴하면 됨
            }
        }

        return ""; // 모두 완주했다면 여기서 빈 문자열을 리턴
    }
}