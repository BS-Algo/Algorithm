import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 결국은 싸이클이 있는 조합을 찾으면 되는 문제였다.
class Main {
    static int N;

    static int[] graph;
    static boolean[] visited;

    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        
        // 그래프 생성
        graph = new int[N + 1];

        // 방문 리스트 생성
        visited = new boolean[N + 1];

        // 그래프 연결
        for (int i = 1; i < N + 1; i++) {
            int num = Integer.parseInt(br.readLine());
            graph[i] = num;
        }

        // dfs
        for (int i = 1; i < N + 1; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());

        for (int num : list) {
            System.out.println(num);
        }
    }

    private static void dfs(int node, int target) {
        // 이런식으로 false를 처리하면 굳이 새로운 boolean[]을 만들어 할당하지 않아도 됨.
        // 다만 내가 평소 쓰던 방식은 ArrayList를 활용한 방법이었기 때문에 로직이 조금 달랐던 이유도 있음.
        if (!visited[graph[node]]) {
            visited[graph[node]] = true;
            dfs(graph[node], target);
            visited[graph[node]] = false;
        }

        if (target == graph[node]) {
            list.add(target);
        }
    }
}