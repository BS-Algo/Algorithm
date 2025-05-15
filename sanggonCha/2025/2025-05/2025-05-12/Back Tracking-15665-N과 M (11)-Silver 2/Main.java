import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력 받기
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로

        // 수열 입력 받기
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        // dfs
        int depth = 0;
        dfs(depth, "");

        // 출력
        System.out.println(sb.toString());
    }

    private static void dfs(int depth, String s) {
        // 종료 조건
        if (depth == M) {
            if (map.get(s) == null) {
                map.put(s, 1);
                sb.append(s).append("\n");
            }
            return;
        }

        // 순회 조건
        for (int i = 0; i < N; i++) {
            if (depth == 0) dfs(depth + 1, Integer.toString(arr[i]));
            else dfs(depth + 1, s + " " + Integer.toString(arr[i]));
        }
    }
}