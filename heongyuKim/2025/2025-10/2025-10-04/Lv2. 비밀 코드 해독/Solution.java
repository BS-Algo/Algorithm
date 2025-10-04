import java.util.*;

class Solution {

    static int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {

        ArrayList<Integer> list = new ArrayList<>();

        // dfs로 비밀코드 조합 생성 및 검증
        dfs(n, 1, list, q, ans);

        return answer;
    }

    public void dfs(int n, int start, ArrayList<Integer> list, int[][] q, int[] ans) {
        if (list.size() == 5) {
            boolean check = true;
            int[] response = new int[q.length];

            // 생성된 조합을 ans와 대조하기
            for (int i = 0; i < q.length; i++) {
                int[] qList = q[i];

                for (int j = 0; j < q[i].length; j++) {
                    int firstNum = list.get(j);

                    for (int k = 0; k < qList.length; k++) {
                        int secondNum = qList[k];
                        if (firstNum == secondNum) {
                            response[i]++;
                        }
                    }
                }
            }

            // 대조 후 일치하면 answer 증가
            for (int i = 0; i < q.length; i++) {
                if (ans[i] != response[i]) {
                    check = false;
                    break;
                }
            }

            if (check) {
                answer++;
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(n,i + 1, list, q, ans);
            list.remove(list.size() - 1);
        }
    }
}
