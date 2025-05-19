import java.io.*;
import java.util.*;

public class Main {
    static int weightN, beadN;
    static int[] weights;
    static StringTokenizer st;
    static boolean[][] visited;
    static final int OFFSET = 15000;
    static Set<Integer> reachableWeights = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 추 입력 받기
        weightN = Integer.parseInt(br.readLine());
        weights = new int[weightN];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < weightN; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        // 추를 통해서 만들수 있는 모든 무게 배열 만들기
        visited = new boolean[weightN + 1][2 * OFFSET + 1]; // 추의 개수는 30 이하, 추의 무게는 500g이하 -> 15000 * 2(음수까지 고려), OFFSET: 15000

        dfs(0, 0);

        // 구슬 입력 받기
        beadN = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < beadN; i++) {
            if (reachableWeights.contains(Integer.parseInt(st.nextToken()))) sb.append('Y').append(' ');
            else sb.append('N').append(' ');
        }

        // 출력
        System.out.println(sb.toString());
    }

    private static void dfs(int depth, int weight) {
        if(visited[depth][weight + OFFSET]) return;
        visited[depth][weight + OFFSET] = true;

        if (depth == weightN) {
            if (weight > 0) reachableWeights.add(weight);
            return;
        }

        // 구슬은 오른쪽
        dfs(depth + 1, weight + weights[depth]); // 추를 왼쪽에 놓기
        dfs(depth + 1, weight - weights[depth]); // 추를 오른쪽에 놓기
        dfs(depth + 1, weight); // 추를 사용하지 않기
    }
}
