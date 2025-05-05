import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

// 처음에 푼 방법인데 너무 복잡하게 푼것 같다.
class Main {

    static int N;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    static HashSet<Integer> tempSet1 = new HashSet<>();
    static HashSet<Integer> tempSet2 = new HashSet<>();

    static HashSet<Integer> resultSet = new HashSet<>();

    static int count = 0;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());

        // 그래프 생성
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 방문 리스트 생성
        visited = new boolean[N + 1];

        // 그래프 연결
        for (int i = 1; i < N + 1; i++) {
            int num = Integer.parseInt(br.readLine());
            graph.get(i).add(num);
        }

        // dfs
        for (int i = 1; i < N + 1; i++) {
            dfs(i, i);

            if (tempSet1.equals(tempSet2)) {
                resultSet.addAll(tempSet1);
            }

            tempSet1.clear();
            tempSet2.clear();
            visited = new boolean[N + 1];
        }

        count = resultSet.size();
        list.addAll(resultSet);
        Collections.sort(list);

        System.out.println(count);

        for (int num : list) {
            System.out.println(num);
        }
    }

    private static void dfs(int node, int start) {

        visited[node] = true;
        tempSet1.add(node);

        for (int next : graph.get(node)) {

            if (next == start) {
                tempSet2.add(next);
                return;
            }

            if (!visited[next]) {
                tempSet2.add(next);
                dfs(next, start);
            }
        }
    }
}