import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
           map.put(players[i], i);
        }
        
        for (String calling : callings) {
            int ranking = map.get(calling);
            String swap = players[ranking];
            
            map.replace(calling, ranking - 1);
            map.replace(players[ranking - 1], ranking);
            players[ranking] = players[ranking - 1];
            players[ranking - 1] = swap;
            
            
        }
        
        
        answer = players;
        
        return answer;
    }
}