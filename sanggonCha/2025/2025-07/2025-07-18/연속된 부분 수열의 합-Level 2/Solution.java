class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int left = 0, right = 0;
        int sum = sequence[0];
        int len = sequence.length;
        int minLen = len + 1;
        int[] answer = new int[2];
        
        while (true) {
            if (sum < k) { // 1. k보다 작으면, right 값을 추가
                if (right == len - 1) break; // 종료 조건: 더 이상 right를 증가시킬 수 없을 때
                else sum += sequence[++right]; 
            } else if (sum > k) sum -= sequence[left++]; // 2. k보다 크면, left 값을 제거\
              else { // 3. k와 일치하는 경우
                if (right - left + 1 < minLen) { // 기존 최대 길이보다 짧으면
                    answer[0] = left; // 반환값 갱신
                    answer[1] = right;
                    minLen = right - left + 1; // 최소 길이 갱신
                }
                
                sum -= sequence[left++]; // left
                if (right < len - 1) sum+= sequence[++right]; // right
            }
        }
        
        return answer;
    }
}