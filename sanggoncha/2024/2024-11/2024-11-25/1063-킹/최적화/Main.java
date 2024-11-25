import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 읽기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 킹과 돌의 초기 위치 및 이동 횟수 읽기
        String king = st.nextToken();
        String stone = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        // 킹과 돌의 초기 위치를 숫자 좌표로 변환
        int kingC = king.charAt(0) - 64; // 'A'~'H' -> 1~8
        int kingR = king.charAt(1) - '0'; // '1'~'8' -> 1~8
        int stoneC = stone.charAt(0) - 64;
        int stoneR = stone.charAt(1) - '0';

        // 방향 이동 정의 (명령어를 키로, (열 이동, 행 이동) 벡터를 값으로 저장)
        Map<String, int[]> directions = new HashMap<>();
        directions.put("R", new int[]{1, 0});  // 오른쪽
        directions.put("L", new int[]{-1, 0}); // 왼쪽
        directions.put("B", new int[]{0, -1}); // 아래
        directions.put("T", new int[]{0, 1});  // 위
        directions.put("RT", new int[]{1, 1}); // 오른쪽 위 대각선
        directions.put("LT", new int[]{-1, 1}); // 왼쪽 위 대각선
        directions.put("RB", new int[]{1, -1}); // 오른쪽 아래 대각선
        directions.put("LB", new int[]{-1, -1}); // 왼쪽 아래 대각선

        // 명령어를 하나씩 처리
        for (int i = 0; i < n; i++) {
            String move = br.readLine(); // 명령어 입력받기
            int[] dir = directions.get(move); // 해당 명령어에 대한 이동 벡터 가져오기

            // 킹의 다음 위치 계산
            int nextKingC = kingC + dir[0];
            int nextKingR = kingR + dir[1];

            // 킹이 이동하려는 위치가 돌과 겹친다면 돌도 같이 이동
            if (nextKingC == stoneC && nextKingR == stoneR) {
                int nextStoneC = stoneC + dir[0];
                int nextStoneR = stoneR + dir[1];

                // 돌이 체스판을 벗어나지 않으면 이동
                if (nextStoneC >= 1 && nextStoneC <= 8 && nextStoneR >= 1 && nextStoneR <= 8) {
                    stoneC = nextStoneC;
                    stoneR = nextStoneR;
                    kingC = nextKingC;
                    kingR = nextKingR;
                }
            } else {
                // 킹이 체스판 안에 있을 경우에만 이동
                if (nextKingC >= 1 && nextKingC <= 8 && nextKingR >= 1 && nextKingR <= 8) {
                    kingC = nextKingC;
                    kingR = nextKingR;
                }
            }
        }

        // 결과 출력 (숫자 좌표를 다시 체스판 형식으로 변환)
        System.out.println(String.format("%c%d", kingC + 64, kingR)); // 열을 알파벳으로 변환
        System.out.println(String.format("%c%d", stoneC + 64, stoneR));
    }
}
