import java.io.*;
import java.util.*;

class Info {
    int node, depth;

    public Info(int node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

public class Main {
    static int N, from, to, minScore = Integer.MAX_VALUE, candidateCount;
    static int[] scores;
    static int[][] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        N = Integer.parseInt(br.readLine());
        friends = new int[N + 1][N + 1];
        scores = new int[N + 1];

        // 회원 번호 입력 받기
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            if (from == -1) break;
            friends[from][to] = friends[to][from] = 1; // 양방향 연결
        }

        findScores();
        printResult();
    }

    private static void findScores() {
        for (int start = 1; start <= N; start++) {
            scores[start] = bfs(start);
            minScore = Math.min(minScore, scores[start]);
        }
    }

    private static int bfs(int start) {
        Queue<Info> queue = new LinkedList<>();
        int[] depth = new int[N + 1];
        Arrays.fill(depth, -1); // -1로 초기화

        queue.add(new Info(start, 0));
        depth[start] = 0;

        int maxDepth = 0;

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            int node = info.node, d = info.depth;

            for (int next = 1; next <= N; next++) {
                if (friends[node][next] == 1 && depth[next] == -1) {
                    depth[next] = d + 1; // 거리 기록
                    maxDepth = Math.max(maxDepth, depth[next]);
                    queue.add(new Info(next, d + 1)); // 다음 방문 대상 추가
                }
            }
        }

        return maxDepth;
    }


    private static void printResult() {
        List<Integer> candidates = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            if (scores[i] == minScore) {
                candidates.add(i);
            }
        }

        System.out.println(minScore + " " + candidates.size());
        for (int candidate : candidates) {
            System.out.print(candidate + " ");
        }
    }
}