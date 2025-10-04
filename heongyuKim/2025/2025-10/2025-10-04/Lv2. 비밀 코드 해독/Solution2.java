import java.util.*;


// Set으로 푸는 방법
public class Solution2 {

    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        for (int a = 1; a <= n - 4; a++) {
            for (int b = a + 1; b <= n - 3; b++) {
                for (int c = b + 1; c <= n - 2; c++) {
                    for (int d = c + 1; d <= n - 1; d++) {
                        for (int e = d + 1; e <= n; e++) {
                            set.clear();
                            set.add(a);
                            set.add(b);
                            set.add(c);
                            set.add(d);
                            set.add(e);
                            
                            boolean isCheck = true;
                            for (int i = 0; i < q.length; i++) {
                                int[] qList = q[i];
                                int num = 0;

                                for (int j = 0; j < qList.length; j++) {
                                    if (set.contains(qList[j])) {
                                        num++;
                                    }
                                }

                                if (ans[i] != num) {
                                    isCheck = false;
                                    break;
                                }
                            }

                            if (isCheck) {
                                answer++;
                            }
                        }
                    }
                }
            } 
        }
        return answer;
    }

    
}
