import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


class Main {
    static int N;
    static int M;

    static ArrayList<Integer> arr = new ArrayList<>();
    static int[] visited;

    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        M = Integer.parseInt(info.nextToken());

        // 숫자들을 담으면서 중복 제거하기
        StringTokenizer nums = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(nums.nextToken());

            if (!arr.contains(num)) {
                arr.add(num);
            }
        }

        // 정렬하기 - 오름 차순
        Collections.sort(arr);
        
        // 방문 리스트 생성
        visited = new int[M];

        // 담은 후 dfs로 길이만큼 조합하기 - 길이는 M만큼이다.
        dfs(0);

        System.out.println(result.toString());
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                result.append(visited[i]).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            visited[depth] = arr.get(i);
            dfs(depth + 1);
        }
    }

}