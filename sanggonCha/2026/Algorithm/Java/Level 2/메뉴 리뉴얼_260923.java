import java.util.*;

class Solution {
    String targetString;
    int endDepth, endSize;
    Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        // course 개수만큼 수행
        for (int size: course) {
            // 카운트할 map 생성
            map = new HashMap<>(); 
            
            // 모든 조합 생성
            for(String order: orders) {
                // order를 오름차순 정렬
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                targetString = new String(chars);
                
                // 변수 세팅
                endSize = size;
                endDepth = order.length();
                
                // dfs
                dfs("", 0, 0); // nowString, nowSize, nowDepth
            }
            
            // 최대 주문 조합 구하기
            int maxOrder = 2; // 최소 2명 이상의 손님에게서 주문된 구성만
            for (String k: map.keySet()) {
                if (map.get(k) > maxOrder) {
                    maxOrder = map.get(k);
                }
            }
            
            // 최대 주문 조합 answer에 추가
            for (String k: map.keySet()) {
                if (map.get(k) == maxOrder) {
                    answer.add(k);
                }
            }
        }
        
        // 정렬
        Collections.sort(answer);
        
        // 제출
        return answer.toArray(new String[0]);
    }
    
    public void dfs(String nowString, int nowSize, int nowDepth) {
        if (nowSize == endSize) {
            map.put(nowString, map.getOrDefault(nowString, 0) + 1);
            return;
        }
        
        if (nowDepth == endDepth) {
            return;
        }
        
        dfs(nowString, 
            nowSize,
            nowDepth + 1
           );
        
        dfs(nowString + targetString.charAt(nowDepth),
            nowSize + 1,
            nowDepth + 1
           );
    }
}