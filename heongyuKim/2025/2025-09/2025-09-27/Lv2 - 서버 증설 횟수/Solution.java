import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 증설된 서버가 언제 종료되는지 알려주기 위한 큐
    static Queue<int[]> q = new LinkedList<>();

    public int solution(int[] players, int m, int k) {
        int answer = 0;

        // 현재 가용되고 있는 서버의 갯수
        int servers = 0;

        // players 리스트를 순회하면서 계산
        for (int i = 0; i < players.length; i++) {
            int count = players[i];
            int addServer = count / m;

            // 첫시간의 경우 증설 여부만 확인
            if (i == 0) {
                if (addServer > 0) {
                    servers += addServer;
                    answer += addServer;
                    // 서버 증설 종료 시간, 증설한 서버 갯수
                    q.offer(new int[] {i + k, addServer});
                }

            } else {
                // 증설한 서버를 종료 해야하는지
                int[] check = q.peek();

                if (!q.isEmpty() && check[0] == i) {
                    servers -= check[1];
                    q.poll();
                }

                // players 수를 확인하여 다시 증설하기
                // 현재 player 수를 기존 서버 갯수가 수용할 수 있다면 증설 X
                // 아니면 증설 처리
                if (addServer > servers) {
                    int needServer = addServer - servers;
                    answer += needServer;
                    servers = addServer;
                    q.offer(new int[] {i + k, needServer});
                }
            }
        }

        return answer;
    }
}