import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 초과 난 코드 하지만 답을 내는데 이상은 없음.
class Main {
    static int N;
    static int M;

    // 그래프
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // 방문 리스트
    static int[] visited;
    
    // 최대값
    static int max = 0;
    // 해킹할 수 있는 컴퓨터의 수
    static int count = 0;

    // 결과를 담을 배열
    static int[] resultArr;

    // 결과를 출력할 StringBuilder
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        // 방문 리스트 생성
        visited = new int[N + 1];

        // 결과를 담을 배열 생성
        resultArr = new int[N + 1];

        // 그래프 생성 후 연결하기
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer link = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(link.nextToken());
            int B = Integer.parseInt(link.nextToken());
            
            // 단방향 연결
            graph.get(B).add(A);
        }

        // 노드 별로 dfs 돌리기
        for (int i = 1; i < N + 1; i++) {
            max = Math.max(count, max);

            count = 0;
            Arrays.fill(visited, 0);
            dfs(i);

            resultArr[i] = count;
        }

        for (int i = 1; i < N + 1; i++) {
            if (resultArr[i] == max) {
                result.append(i).append(" ");
            }
        }

        System.out.println(result.toString());
    }

    private static void dfs(int R) {
        visited[R] = 1;
        count++;

        for (int i = 0; i < graph.get(R).size(); i++) {
            int next = graph.get(R).get(i);
            if (visited[next] == 0) {
                dfs(next);
            }
        }

    }


}