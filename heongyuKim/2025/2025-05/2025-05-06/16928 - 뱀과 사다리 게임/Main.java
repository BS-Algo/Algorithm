import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 좀 쉽게 생각했으면 됐는데 생각이 많았는지 처음에는 주사위를 굴리는 상황, 뱀과 사다리를 통해 이동하는 상황을 나눠서 처리하니까 너무 복잡하기도하고
// 정답이 안나오기도 했었다. 결국은 주사위를 굴렸을 때 다음 위치가 뱀과 사다리면 이동한 후 count해주고 일반 칸이면 그냥 count했으면 됐어서 이를 조건문으로 한번에 처리하면 됐었다.
class Main {
    // 사다리와 뱀의 갯수
    static int N;
    static int M;

    // 그래프와 방문리스트
    static int[] graph;
    static int[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        // 그래프 생성
        graph = new int[101];

        // 그래프 연결
        for (int i = 0; i < N + M; i++) {
            StringTokenizer move = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(move.nextToken());
            int b = Integer.parseInt(move.nextToken());

            graph[a] = b;
        }

        // 방문 리스트 생성
        visited = new int[101];

        // 1부터 시작
        bfs();
        
        // 결과 출력
        System.out.println(visited[100]);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            
            // 100에 도달하면 종료
            if (cur == 100) return;

            // 주사위 굴리기
            for (int i = 1; i <= 6; i++) {
                int next = cur + i;

                // 다음 위치가 100이 넘으면 안됨.
                if (next > 100) {
                    continue;
                }
                
                // 사다리나 뱀이냐 아니면 그냥 일반 칸이냐 여부 따지기
                int destination = (graph[next] != 0) ? graph[next] : next;

                // 다음 부분 방문 안했으면 방문처리후 q에 넣기
                if (visited[destination] == 0) {
                    visited[destination] = visited[cur] + 1;
                    q.offer(destination);
                }

            }
        }
    }
}