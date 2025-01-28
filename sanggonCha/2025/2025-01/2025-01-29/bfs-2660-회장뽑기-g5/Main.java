import java.io.*;
import java.util.*;

class Info {
    int v, dis;

    public Info(int v, int dis) {
        this.v = v;
        this.dis = dis;
    }
}


public class Main {
    static int N, count, now, from, to, minScore;
    static int[] visited, distance;
    static int[][] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        N = Integer.parseInt(br.readLine());
        minScore = N;
        distance = new int[N + 1];
        friends = new int[N + 1][N + 1];

        // 회원 번호 입력 받기
        from = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            if (from == -1) break;
            friends[from][to] = 1; // 양방향 그래프
            friends[to][from] = 1;
        }

        // bfs
        solve();
    }

    private static void solve() {
        // 탐색
        for (int start = 1; start < N + 1; start++) { // 모든 번호 출발
            visited = new int[N + 1]; // 생성
            visited[start] = -1; // 시작점 방문 체크
            Queue<Info> q = new LinkedList<>();
            q.add(new Info(start, 1));
            while (!q.isEmpty()) {
                Info info = q.poll();
                for (int next = 1; next < N + 1; next++) {
                    if (friends[info.v][next] == 1 && visited[next] == 0) {
                        visited[next] = info.dis; // 거리 기록
                        q.add(new Info(next, info.dis + 1)); // 다음 방문 대상 추가
                    }
                }
            }
            record(start); // bfs 거리 기록
        }

        // 출력
        count = 0;
        print();
    }

    private static void record(int i) {
        int maxScore = 1;
        for (int j = 1; j < N + 1; j++) {
            maxScore = Math.max(maxScore, visited[j]);
        }

        distance[i] = maxScore;
    }

    private static void print() {
        minScore = N;

        for (int i = 1; i < N + 1; i++) {
            minScore = Math.min(minScore, distance[i]);
        }

        for (int i = 1; i < N + 1; i++) {
            if (distance[i] == minScore) {
                count++;
            }
        }
        System.out.println(minScore + " " + count);

        for (int i = 0; i < N + 1; i++) {
            if (distance[i] == minScore) {
                System.out.print(i + " ");
            }
        }
    }
}