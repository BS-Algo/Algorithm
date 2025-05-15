import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


class Main {
    static int N;
    static int M;

    static ArrayList<Integer> list = new ArrayList<>();
    static int[] visited;

    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        StringTokenizer nums = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(nums.nextToken());
            if (!list.contains(num)) {
                list.add(num);
            }
        }

        // 오름 차순 정렬
        Collections.sort(list);

        // 방문 리스트 생성
        visited = new int[M];

        dfs(0, 0);

        System.out.println(result.toString());
    }

    private static void dfs(int index, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                result.append(visited[i]).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = index; i < list.size(); i++) {
            visited[depth] = list.get(i);
            dfs(i, depth + 1);
        }
    }
}