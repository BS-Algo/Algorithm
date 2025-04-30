import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 다시 풀어보자 거의 다 풀었는데 너무 헷갈린듯 그리고 문제도 제대로 안읽어서 틀린 것도 있음....
class Main {

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    // 방문하지 말아야 할 노드
    static int notVisitNode = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int root = 0;

        // 노드 생성
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer parents = new StringTokenizer(br.readLine());

        // 그래프 연결
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(parents.nextToken());
            if (parent != -1) {
                tree.get(parent).add(i);
            } else {
                root = i;
            }
        }

        notVisitNode = Integer.parseInt(br.readLine());

        if (notVisitNode == root) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(result);
        }
    }

    private static void dfs(int num) {
        if (tree.get(num).contains(notVisitNode)) {
            tree.get(num).remove(Integer.valueOf(notVisitNode));
        }

        if (tree.get(num).isEmpty()) {
            result++;
            return;
        }

        for (int child : tree.get(num)) {
            dfs(child);
        }
    }
}