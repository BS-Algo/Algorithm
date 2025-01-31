import java.util.*;

// 직접 그려보면 세 과정으로 나눌 수 있다
// n일 경우에, 
// 1. (제일 큰 원판을 제외한) n-1개의 원판을 보조 기둥으로 옮기는 과정
// 2. 제일 큰 원판을 목표 기둥으로 옮기는 과정
// 3. n-1개의 원판을 보조 기둥에서 목표 기둥으로 옮기는 과정

class Solution {
    List<int[]> moves = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2); // 1: 현재 기둥, 2: 보조 기둥, 3: 목표 기둥
        return moves.toArray(new int[moves.size()][]); // List -> 2차원 배열로 형 변환
    }

    // from: 현재 기둥, to: 목표 기둥, via: 보조 기둥
    private void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            moves.add(new int[]{from, to}); // 기저 조건: 원판 1개를 옮김
            return;
        }
        hanoi(n - 1, from, via, to);     // n-1개의 원판을 보조 기둥으로 이동
        moves.add(new int[]{from, to});  // 가장 큰 원판을 목표 기둥으로 이동
        hanoi(n - 1, via, to, from);     // n-1개 원판을 보조 기둥에서 목표 기둥으로 이동
    }
}
