import java.util.*;

class Solution {
    // 시작 지점
    static int currentRow;
    static int currentCol;

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        // 시작 지점 찾기
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    currentRow = i;
                    currentCol = j;
                }
            }
        }

        // 찾은 후 명령어를 통해서 이동하기
        for (int i = 0; i < routes.length; i++) {
            StringTokenizer command = new StringTokenizer(routes[i]);
            String direction = command.nextToken();
            int range = Integer.parseInt(command.nextToken());
            
            int tempRow = currentRow;
            int tempCol = currentCol;
            
            boolean canMove = true;
            
            for (int j = 0; j < range; j++) {
                switch (direction) {
                case "N":
                    tempRow--;
                    break;

                case "S":
                    tempRow++;
                    break;

                case "W":
                    tempCol--;
                    break;

                case "E":
                    tempCol++;
                    break;
                }
                
                if (tempRow < 0 || park.length <= tempRow || tempCol < 0 || park[0].length() <= tempCol) {
                    canMove = false;
                    break;
                }            
                
                if (park[tempRow].charAt(tempCol) == 'X') {
                    canMove = false;
                    break;
                }
            }
            
            if (canMove) {
                currentRow = tempRow;
                currentCol = tempCol;
            }
        }

        answer[0] = currentRow;
        answer[1] = currentCol;

        return answer;
    }

}