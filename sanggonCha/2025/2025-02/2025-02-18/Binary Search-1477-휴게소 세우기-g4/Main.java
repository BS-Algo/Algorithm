import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, L;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N ,M, L 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 현재 휴게소의 개수
        M = Integer.parseInt(st.nextToken()); // 더 지으려고 하는 휴게소의 개수
        L = Integer.parseInt(st.nextToken()); // 고속도로의 길이

        // 휴게소 위치 입력 받기
        arr = new int[N + 1];
        arr[N] = L;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        // 초기값 설정
        int min = 1, max = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i + 1] - arr[i] > max) max = arr[i + 1] - arr[i];
        }
        if (N == 0) max = L;

        // 탐색
        while (min <= max) {
            int dis = (min + max) / 2;

            if (check(dis) < 0) {
                min = dis + 1;
            } else {
                max = dis - 1;
            }
        }

        System.out.println(max + 1);
    }

    private static int check(int dis) {

        int cnt = M;
        int before = 0;

        for (int i = 0; i < N + 1; i++) {
            while (before + dis < arr[i]) {
                cnt--; // 설치
                before += dis;
            }
            before = arr[i];
        }

        return cnt;
    }
}
