import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] student = new int[n + 1];
        Arrays.fill(student, 1);
        
        for (int l: lost) {
            student[l] -= 1;
        }
        
        for (int r: reserve) {
            student[r] += 1;
        }
        
        for (int i = 1; i <= n; i++) {
            if (student[i] >= 1) {
                answer++;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (student[i] == 2) {
                if (i  - 1 >= 1 && student[i - 1] == 0) {
                    student[i - 1]++;
                    student[i]--;
                    answer++;
                } else if (i + 1 <= n && student[i + 1] == 0) {
                    student[i + 1]++;
                    student[i]--;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}