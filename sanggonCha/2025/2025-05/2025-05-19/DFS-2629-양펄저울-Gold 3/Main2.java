import java.io.*;
import java.util.*;

public class Main2 {
    static int weightN, beadN;
    static int[] weights;
    static StringTokenizer st;
    static boolean[][] visited;
    static final int OFFSET = 15000;

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
        visited = new boolean[weightN + 1][15001]; // 추의 개수는 30 이하, 추의 무게는 500g이하 -> 30 * 500 = 15000

        dfs(0, 0);

        // 구슬 입력 받기
        beadN = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < beadN; i++) {
            int bead = Integer.parseInt(st.nextToken());
            if (bead > 15000 || !visited[weightN][bead]) sb.append('N').append(' ');
            else sb.append('Y').append(' ');
        }

        // 출력
        System.out.println(sb.toString());
    }

    private static void dfs(int depth, int weight) {
        if (visited[depth][weight]) return;
        visited[depth][weight] = true;

        if (depth == weightN) return;


        // 구슬은 오른쪽만 둔다고
        dfs(depth + 1, weight + weights[depth]); // 추를 왼쪽에 놓기
        dfs(depth + 1, Math.abs(weight - weights[depth])); // 추를 오른쪽에 놓기
        dfs(depth + 1, weight); // 추를 사용하지 않기
    }
}
