import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// Main1의 코드와의 차이점
// 해킹된 코드를 합산할 때 재귀 호출 후 resultArr에 바로 기록하여 반복 계산을 줄였고
// 매 DFS마다 새 배열 할당이 fill()보다 빠르다. - new int[N + 1]은 가비지 컬렉터가 처리하고 빠르게 새 배열 생성하고, Arrays.fill()은 내부적으로 for문을 돌며 0으로 재설정하기 때문에 상대적으로 느림.
// 그리고 코드 구조가 객체 기반 접근으로 그래프 탐색이 간결하고 빠르다.
// 이러한 차이점에 의해서 시간초과가 나지 않게 된다. 물론 이것도 시간적 성능이 좋지 않아서 차라리 BFS로 푸는 것이 좋을듯하다.
class Main {
    static int N;
    static int M;

    // 그래프
    static Computer[] computers;
    // 방문 리스트
    static int[] visited;

    // 최대값
    static int max = 0;

    // 결과를 담을 배열
    static int[] resultArr;

    // 결과를 출력할 StringBuilder
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        computers = new Computer[N + 1];
        // 결과를 담을 배열 생성
        resultArr = new int[N + 1];

        // 그래프 생성 후 연결하기
        for (int i = 0; i < N + 1; i++) {
            computers[i] = new Computer(i);
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer link = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(link.nextToken());
            int B = Integer.parseInt(link.nextToken());
            
            // 단방향 연결
            computers[B].list.add(computers[A]);
        }

        // 노드 별로 dfs 돌리기
        for (int i = 1; i < N + 1; i++) {
            visited = new int[N + 1];
            visited[i] = 1;
            dfs(i, i);
        }

        // 최댓값 설정
        for (int i = 1; i < N  + 1; i++) {
            max = Math.max(max, resultArr[i]);
        }

        for (int i = 1; i < N + 1; i++) {
            if (resultArr[i] == max) {
                result.append(i).append(" ");
            }
        }
        
        // 결과 출력
        System.out.println(result.toString());
    }

    private static void dfs(int original, int now) {

        for (Computer c : computers[now].list) {
            if (visited[c.idx] == 0) {
                visited[c.idx] = 1;
                dfs(original, c.idx);
                resultArr[original]++;
            }
        }
    }

    public static class Computer {
        int idx;
        ArrayList<Computer> list;

        public Computer(int idx) {
            this.idx = idx;
            list = new ArrayList<>();
        }
    }
}