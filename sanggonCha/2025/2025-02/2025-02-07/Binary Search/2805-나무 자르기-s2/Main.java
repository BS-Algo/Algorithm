import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무의 길이

        // 나무 입력 받기
        int right = 0;
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tree = Integer.parseInt(st.nextToken());
            trees[i] = tree;
            right = Math.max(right, tree);
        }

        // 이분 탐색
        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) {
                    sum += trees[i] - mid;
                }
            }

            if (sum >= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left - 1);
    }
}