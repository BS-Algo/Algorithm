class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        // 행의 길이
        int row = board.length;
            
        // 열의 길이
        int col = board[0].length;
        
        // 상 하 좌 우
        int[] directionRow = {-1, 1, 0, 0};
        int[] directionCol = {0, 0, -1, 1};
        
        for (int i = 0; i < 4; i++) {
            if ((-1 < h + directionRow[i] && h + directionRow[i] < row) && (-1 < w + directionCol[i] && w+ directionCol[i] < col)) {
                if (board[h][w].equals(board[h + directionRow[i]][w + directionCol[i]])) {
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
}