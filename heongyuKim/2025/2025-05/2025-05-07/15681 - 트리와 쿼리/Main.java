import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 그래프를 트리로 바꾸는 방법에 대해 공부하게 되어서 좋은 문제라고 생각한다.
// 처음에 서브트리의 정점의 수를 구할 때 반복문 안에 넣어서 시간초과가 발생하였음.
class Main {

    static int N;
    static int R;
    static int Q;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] size;

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        R = Integer.parseInt(info.nextToken());
        Q = Integer.parseInt(info.nextToken());

        // 그래프와 트리 생성
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
            tree.add(new ArrayList<>());
        }

        size = new int[N + 1];

        // 간선 연결
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer link = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(link.nextToken());
            int e = Integer.parseInt(link.nextToken());

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        // R을 기준으로 한 트리 생성
        makeTree(R, R);
        countSubRoot(R);

        // 만들어진 트리를 기준으로 탐색후 결과 출력
        for (int i = 0; i < Q; i++) {
            int subRoot = Integer.parseInt(br.readLine());
            System.out.println(size[subRoot]);
        }
    }

    private static void makeTree(int current, int parent) {
        for (int node : graph.get(current)) {
            if (node != parent) {
                tree.get(current).add(node);
                makeTree(node, current);
            }
        }
    }

    private static void countSubRoot(int node) {
        size[node] = 1;
        for (int child : tree.get(node)) {
            countSubRoot(child);
            size[node] += size[child];
        }
    }
}