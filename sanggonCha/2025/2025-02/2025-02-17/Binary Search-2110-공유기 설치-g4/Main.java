import java.io.*;
import java.util.*;

public class Main {
    private static int N, C;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N ,C 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 집 좌표 입력 받기
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(arr);

        // 탐색
        int min = 1, max = arr[N - 1] / (C - 1);
        while (min <= max) {
            int length = (min + max) / 2;

            if (check(length) <= 0) {
                min = length + 1;
            } else {
                max = length - 1;
            }
        }

        System.out.println(max);
    }

    // length를 유지하면서 모두 설치가 가능한지 check
    private static int check(int length) {

        int cnt = C;
        int before = -length;

        for (int i = 0; i < N; i++)
            if (arr[i] >= before + length) {
                cnt--;
                before = arr[i];
            }

        return cnt;
    }
}
