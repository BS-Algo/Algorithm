import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[][] xy = new int[N][2];


        // 선 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xy[i][0] = Integer.parseInt(st.nextToken());
            xy[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(xy, Comparator.comparingInt(a -> a[0]));

        int ans = 0;
        int[] before = {xy[0][0], xy[0][1]};
        for (int i = 1; i < N; i++) {
            int front = xy[i][0];
            int end = xy[i][1];

            if (before[1] < front) { // 끊기는 경우
                ans += (before[1] - before[0]); // 지금까지의 길이 누적합
                before[0] = front;
                before[1] = end;
            } else { // 이어지는 경우
                before[1] = Math.max(end, before[1]);
            }
        }

        System.out.println(ans + before[1] - before[0]);
    }
}