class Solution {
    int length_global;
    int target_global;
    int answer_global = 0;
    int[] numbers_global;
    
    
    public int solution(int[] numbers, int target) {        
        // 전역 변수에 옮겨 담기
        length_global = numbers.length;
        target_global = target;
        numbers_global = new int[length_global];
        for (int i = 0; i < length_global; i++) {
            numbers_global[i] = numbers[i];
        }
        
        // dfs
        dfs(0, 0);
        
        // 제출
        return answer_global;
    }
    
    public void dfs(int now, int depth) {
        // 종료 조건
        if (depth == length_global) {
            if (now == target_global)  {
                answer_global++;
            }
        } else {
            dfs(now + numbers_global[depth], depth + 1);
            dfs(now - numbers_global[depth], depth + 1);
        }
    }
}