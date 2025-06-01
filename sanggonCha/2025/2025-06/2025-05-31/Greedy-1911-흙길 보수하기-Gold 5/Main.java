import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, L 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물 웅덩이 수
        int L = Integer.parseInt(st.nextToken()); // 널빤지 길이

        // 물 웅덩이 입력
        int[][] puddle = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            puddle[i][0] = Integer.parseInt(st.nextToken());
            puddle[i][1] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(puddle, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        // greedy
        int cnt = 0;
        int lastCovered = 0;

        for (int i = 0; i < N; i++) {
            int start = Math.max(puddle[i][0], lastCovered);
            int end = puddle[i][1];

            if (start >= end) continue; // lastCovered로 이미 커버됐으면 생략

            int length = end - start;
            int need = (length + L - 1) / L; // 올림
            // L = 3일 때
            // length 1 -> 1개
            // length 2 -> 1개
            // length 3 -> 1개
            // (length + L - 1) / L -> 1개

            cnt += need;
            lastCovered = start + need * L;
        }

        // 출력
        System.out.println(cnt);
    }
}