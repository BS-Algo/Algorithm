import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        boolean[] haveToBorrow = new boolean[n + 1]; // 빌려야 하는 사람
        for (int l : lost) haveToBorrow[l] = true;

        boolean[] canLand = new boolean[n + 1];
        for (int r : reserve) canLand[r] = true; // 빌려줄 수 있는 사람

        for (int i = 1; i <= n; i++) {
            if (canLand[i] && haveToBorrow[i]) { // 빌려야하는 사람 중에서, 여벌 체육복을 갖고 온 사람이 있다면
                canLand[i] = false; // 빌려야하는 사람에서 제외
                haveToBorrow[i] = false; // 빌려줄 수 있는 사람에서 제외
                answer++; // 체육복 입을 수 있는 사람 + 1
            }
        }

        // 진짜 여벌 체육복을 갖고 있는 사람만 검사
        for (int i = 1; i <= n; i++) {
            if (canLand[i]) { // 빌려줄 수 있다면
                if (i > 1 && haveToBorrow[i - 1]) { // 앞번호 검사
                    haveToBorrow[i - 1] = false;
                    answer++;
                } else if (i < n && haveToBorrow[i + 1]) { // 뒷번호 검사
                    haveToBorrow[i + 1] = false;
                    answer++;
                }
            }
        }

        return answer;
    }
}