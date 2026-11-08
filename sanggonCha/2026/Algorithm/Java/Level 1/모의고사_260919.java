import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int problem_length = answers.length;
        
        // 수포자1
        int[] spj1 = new int[problem_length];
        for (int i = 0; i < problem_length; i++) {
            spj1[i] = (i % 5) + 1;
        }
        
        // 수포자2
        int[] spj2_method = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1};
        int[] spj2 = new int[problem_length];
        for (int i = 0; i < problem_length; i++) {
            spj2[i] = spj2_method[i % 8];
        }
        
        // 수포자3
        int[] spj3_method = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] spj3 = new int[problem_length];
        for (int i = 0; i < problem_length; i++) {
            spj3[i] = spj3_method[i % 10];
        }
        
        // 맞힌 문제 카운트
        int spj1Count = 0;
        int spj2Count = 0;
        int spj3Count = 0;
        for (int i = 0; i < problem_length; i++) {
            if (answers[i] == spj1[i]) spj1Count++;
            if (answers[i] == spj2[i]) spj2Count++;
            if (answers[i] == spj3[i]) spj3Count++;
        }
        
        // 가장 많은 문제를 맞힌 사람 찾기
        int maxCount = Math.max(Math.max(spj1Count, spj2Count), spj3Count);
        int winnerCount = 0;
        
        List<Integer> winner = new ArrayList<>();
        
        if (maxCount == spj1Count) {
            winner.add(1);
            winnerCount++;
        }
        if (maxCount == spj2Count) {
            winner.add(2);
            winnerCount++;
        }
        if (maxCount == spj3Count) {
            winner.add(3);
            winnerCount++;
        }
        
        // 정답 배열에 winner 리스트를 옮겨 담기
        int idxCount = 0;
        int[] answer = new int[winnerCount];
        for (int w: winner) {
            answer[idxCount++] = w;
        }
        
        // 제출
        return answer;
    }
}