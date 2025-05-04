import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 방문처리를 잘못해주어 조금 해맸음 ㅋㅋ
class Main {
    static int N;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    static int min = Integer.MAX_VALUE;
    static ArrayList<int[]> list = new ArrayList<>();

    // 회장 후보 정보
    static int candidateScore = 0;
    static int candidateCount = 0;
    static ArrayList<Integer> candidateList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());

        // 그래프 생성 및 방문 리스트 생성
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];

        // 그래프 연결
        while (true) {
            StringTokenizer link = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(link.nextToken());
            int b = Integer.parseInt(link.nextToken());

            if (a == -1 && b == -1) {
                break;
            }

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // bfs
        for (int i = 1; i < N + 1; i++) {
            int result = bfs(i);
            min = Math.min(min, result);
            list.add(new int[] {i, result});
            visited = new boolean[N + 1];
        }

        candidateScore = min;
        
        // 결과 도출
        for (int[] node : list) {
            int num = node[0];
            int level = node[1];

            if (level == min) {
                candidateCount++;
                candidateList.add(num);
            }
        }
        
        // 결과 출력
        StringBuilder result = new StringBuilder();
        result.append(candidateScore).append(" ").append(candidateCount).append("\n");

        for (int candidate : candidateList) {
            result.append(candidate).append(" ");
        }

        System.out.println(result);
    }

    private static int bfs(int R) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {R, 0});
        int maxLevel = Integer.MIN_VALUE;
        visited[R] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int level = cur[1];
            maxLevel = Math.max(maxLevel, level);

            for (int i = 0; i < graph.get(node).size(); i++) {
                int next = graph.get(node).get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[] {next, level + 1});
                }
            }
        }

        return maxLevel;
    }
}