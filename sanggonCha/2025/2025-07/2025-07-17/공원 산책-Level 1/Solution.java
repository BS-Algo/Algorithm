import java.util.*;

class Solution {
    private static int i, j, parkI, parkJ;
    
    public int[] solution(String[] park, String[] routes) {
        
        // 0. park의 크기 구하기
        parkI = park.length;
        parkJ = park[0].length();
        
        // 1. S의 시작 좌표 구하기
        int[] info = findS(park);
        i = info[0];
        j = info[1];

        // 2. 이동 명령 실행
        for (String route: routes) {
            
            StringTokenizer st = new StringTokenizer(route);
            String op = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            
            move(op, n, park);
        }
        
        int[] answer = {i, j};
        return answer;
    }
    
    private static void move(String op, int n, String[] park) {
        if (op.equals("N")) { // 1. N
            
            for (int di = 1; di <= n; di++) {
                if (i - di < 0 || park[i - di].charAt(j) == 'X') { // 범위를 벗어났거나, 장애물을 만나면
                    return; // 즉시 종료
                }
            }
            
            i -= n; // 이동에 문제가 없다면 좌표 변경
        } else if (op.equals("E"))  { // 2. E
            
            for (int dj = 1; dj <= n; dj++) {
                if (j + dj >= parkJ || park[i].charAt(j + dj) == 'X') { // 범위를 벗어났거나, 장애물을 만나면
                    return; // 즉시 종료
                }
            }
            j += n; // 이동에 문제가 없다면 좌표 변경
        } else if (op.equals("W"))  { // 3. W
            
            for (int dj = 1; dj <= n; dj++) {
                if (j - dj < 0 || park[i].charAt(j - dj) == 'X') { // 범위를 벗어났거나, 장애물을 만나면
                    return; // 즉시 종료
                }
            }
            j -= n; // 이동에 문제가 없다면 좌표 변경
        } else { // 4. S
            
            for (int di = 1; di <= n; di++) {
                if (i + di >= parkI || park[i + di].charAt(j) == 'X') { // 범위를 벗어났거나, 장애물을 만나면
                    return; // 즉시 종료
                }
            }
            
            i += n; // 이동에 문제가 없다면 좌표 변경
        }
    }
    
    private static int[] findS(String[] park) {
        for (int row = 0; row < park.length; row++) {
            for (int col = 0; col < park[row].length(); col++) {
                if (park[row].charAt(col) == 'S') {
                    int[] info = new int[2];
                    
                    info[0] = row;
                    info[1] = col;
                    
                    return info;
                }
            }
        }
        
        return new int[]{-1, -1};
    }
}