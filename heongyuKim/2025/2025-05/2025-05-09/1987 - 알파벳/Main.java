import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// dfs와 백트래킹을 사용하는 방식
class Main {
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int R;
    static int C;

    static char[][] graph;
    static boolean[][] visited;
    static Set<Character> list = new HashSet<>();

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        R = Integer.parseInt(info.nextToken());
        C = Integer.parseInt(info.nextToken());

        // 그래프와 방문 리스트 생성
        graph = new char[R][C];
        visited = new boolean[R][C];

        // 그래프에 값 넣기
        for (int i = 0; i < R; i++) {
            String alphabets = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = alphabets.charAt(j);
            }
        }

        // dfs
        dfs(0, 0, 1);
    
        // 결과 출력
        System.out.println(result);
    }

    private static void dfs(int x, int y, int count) {
        result = Math.max(result, count);
        visited[x][y] = true;
        list.add(graph[x][y]);
        
        // 모든 알파벳의 길이에 도달한다면 더이상 답을 체크해주지 않아도 됨
        if (result == 26) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0 <= nx && nx < R) && (0 <= ny && ny < C) && !visited[nx][ny] && !list.contains(graph[nx][ny])) {
                dfs(nx, ny, count + 1);

                // 백트래킹
                visited[nx][ny] = false;
                list.remove(graph[nx][ny]);
            }
        }
    }
}