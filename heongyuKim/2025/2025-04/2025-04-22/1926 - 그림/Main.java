import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs로 풀었음
class Main {
    // dx dy - 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 가로 세로
    static int N;
    static int M;

    // 그림
    static int[][] picture;
    // 방문 리스트
    static int[][] visited;

    static int size = 0;
    static int count = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        // 그림 생성
        picture = new int[N][M];

        // 방문 리스트 생성
        visited = new int[N][M];
        
        // 그림 그리기
        for (int i = 0; i < N; i++) {
            StringTokenizer nums = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(nums.nextToken());
                picture[i][j] = num;
            }
        }

        // dfs 돌리기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (picture[i][j] == 1 && visited[i][j] == 0) {
                    size = 0;
                    count++;
                    dfs(i, j);
                    max = Math.max(max, size);
                }
            }
        }

        // 결과 출력    
        System.out.println(count);
        System.out.println(max);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = 1;
        size++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (picture[nx][ny] == 1) && (visited[nx][ny] == 0)) {
                dfs(nx, ny);
            }
        }
    }
}