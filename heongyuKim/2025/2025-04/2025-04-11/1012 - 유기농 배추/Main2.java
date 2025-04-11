import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    
    // 그래프의 가로길이와 세로길이
    static int rowLength;
    static int colLength;

    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 그래프와 방문리스트
    static int[][] graph;
    static int[][] visited;

    private static void dfs(int row, int col) {

        // 방문체크
        visited[row][col] = 1;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            
            // 다음 노드가 그래프 범위안에 있고
            if ((-1 < nextRow && nextRow < rowLength) && (-1 < nextCol && nextCol < colLength)) {
                // 배추와 그 배추를 방문하지 않았으면
                if (graph[nextRow][nextCol] == 1 && visited[nextRow][nextCol] == 0) {
                    dfs(nextRow, nextCol);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            // 결과로 사용할 변수
            int count = 0;

            // 가로길이, 세로 길이
            StringTokenizer info = new StringTokenizer(br.readLine());
            rowLength = Integer.parseInt(info.nextToken());
            colLength = Integer.parseInt(info.nextToken());
            
            // 배추의 갯수
            int K = Integer.parseInt(info.nextToken());

            // 그래프 생성
            graph = new int[rowLength][colLength];

            // 방문 리스트 생성
            visited = new int[rowLength][colLength];
            
            // 그래프에 배추 정보 심기
            for (int j = 0; j < K; j++) {
                StringTokenizer point = new StringTokenizer(br.readLine());

                int row = Integer.parseInt(point.nextToken());
                int col = Integer.parseInt(point.nextToken());

                graph[row][col] = 1;
            }

            // 그래프에 있는 배추들을 순회하면서 dfs하기
            for (int j = 0; j < rowLength; j++) {
                for (int k = 0; k < colLength; k++) {
                    if (graph[j][k] == 1 && visited[j][k] == 0) {
                        count++;
                        dfs(j, k);
                    }
                }
            }

            // 결과 출력하기
            System.out.println(count);

        }
    }
}
