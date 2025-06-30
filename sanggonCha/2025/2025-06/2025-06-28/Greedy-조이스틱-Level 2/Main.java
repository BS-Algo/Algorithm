class Solution {
    public int solution(String name) {
        int answer = 0;
        int nameLength = name.length();
        
        boolean[] controlCheck = new boolean[nameLength];
        
        for(int nameIdx = 0; nameIdx < nameLength; nameIdx++) {
            char c = name.charAt(nameIdx);
            
            int controlCount = Math.min(c - 'A', 'Z' - c + 1);
            
            if (controlCount > 0) {
                controlCheck[nameIdx] = true;
                answer += controlCount;
            }
        }
        
        // 기본: 오른쪽으로만 가는 경우
        int minMove = nameLength - 1;
        
        // 각 위치에서 되돌아가는 경우들 체크
        for(int nameIdx = 0; nameIdx < nameLength; nameIdx++) {
            // 연속된 A 구간 찾기
            int nextIdx = nameIdx + 1;
            while(nextIdx < nameLength && !controlCheck[nextIdx]) {
                nextIdx++;
            }
            
            // 오른쪽 갔다가 왼쪽으로 돌아가기
            int rightThenLeft = nameIdx * 2 + (nameLength - nextIdx);
            
            // 왼쪽 갔다가 오른쪽으로 가기  
            int leftThenRight = (nameLength - nextIdx) * 2 + nameIdx;
            
            minMove = Math.min(minMove, Math.min(rightThenLeft, leftThenRight));
        }
        
        answer += minMove;
        
        return answer;
    }
}