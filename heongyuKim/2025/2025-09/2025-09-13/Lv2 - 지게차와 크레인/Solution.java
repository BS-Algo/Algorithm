import java.util.*;

class Solution {
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] storage, String[] requests) {
        // 행과 열
        int col = storage.length;
        int row = storage[0].length();
        
        char[][] storageChar = new char[col][row];
        
        // char배열로 바꾸기
        for (int i = 0; i < col; i++) {
            storageChar[i] = storage[i].toCharArray();
        }
        
        
        // 요청 처리
        for (int i = 0; i < requests.length; i++) {
            char request = requests[i].charAt(0);
            int requestKind = requests[i].length();
            
            requestExec(col, row, storageChar, request, requestKind);
        }
        
        // 결과 리턴
        int answer = remainContainer(col, row, storageChar);
        return answer;
    }
    
    
    // 요청이 1이면 - 접근 가능한 컨테이너만 제거하기
    // 요청이 2이면 - 요청된 종류의 알파벳을 모두 지우기
    public void requestExec(int col, int row, char[][] storage, char request, int kind) {   
        if (kind == 1) {
            
            ArrayList<int[]> list = new ArrayList<>();
            
            for (int i = 0; i < col; i++) {
                for (int  j= 0; j < row; j++) {
                    if (storage[i][j] == request) {
                        list.add(new int[] {i, j});
                    }
                }
            }
            
            boolean[] checked = new boolean[list.size()];
            for (int i = 0; i < list.size(); i++) {
                int[] index = list.get(i);
                int x = index[0];
                int y = index[1];
                
                if (bfs(x, y, col, row, storage)) {
                    checked[i] = true;
                }
            }
            
            for (int i = 0; i < checked.length; i++) {
                if (checked[i]) {
                    int[] index = list.get(i);
                    int x = index[0];
                    int y = index[1];
                    
                    storage[x][y] = ' ';
                }
            }
            
            
            
        } else {
            for (int i = 0; i < col; i++) {
                for (int  j = 0; j < row; j++) {
                    if (storage[i][j] == request) {
                        storage[i][j] = ' ';
                    }
                }
            }
        }
    }
    
    public boolean bfs(int x, int y, int col, int row, char[][] storage) {
        boolean[][] visited = new boolean[col][row];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] index = q.poll();

            int cx = index[0];
            int cy = index[1];
            
            if (cx == 0 || cx == col - 1 || cy == 0 || cy == row - 1) {
                    return true;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];    
            
                if ((nx >= 0 && nx < col && ny >= 0 && ny < row) && storage[nx][ny] == ' ' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        return false;
    }
    
    
    // 모든 요청 처리 후 남은 컨테이너의 갯수
    public int remainContainer(int col, int row, char[][] storage) {
        int count = 0;
        
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (storage[i][j] != ' ') {
                    count++;
                }
            }    
        }
        
        return count;
    }
}
