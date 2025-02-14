import java.io.*;
import java.util.*;

public class Main {
    private static long cnt = 0;
    private static int N, mid;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        N = Integer.parseInt(br.readLine());

        // 코딩 실력 입력 받기
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        // 탐색
        for (int i = 0; i < N - 2; i++) {
            check(arr[i], i + 1);
        }

        System.out.println(cnt);
    }

    private static void check(int num, int l) {
        int r = N - 1;

        // 이분 탐색
        while (l < r) { // 투 포인터라서 "<" 주의
            int sum = num + arr[l] + arr[r];

            if (sum > 0) {
                r--;
            } else if (sum < 0) {
                l++;
            } else { // 합이 0이 되는 상황
                if (arr[l] == arr[r]) { // 두 수가 같다면, 그 사이 모든 수가 같다는 의미
                    cnt += (r - l + 1) * (r - l) / 2; // nC2 조합만큼 가능
                    return;
                } else { // 그렇지 않다면, 근처에 같은 값을 찾는 만큼 조합 가능
                    int additionalL = l;
                    int additionalR = r;

                    while (arr[l] == arr[additionalL]) { // 어차피 인덱스를 벗어나지 않음
                        additionalL++;
                    }


                    while (arr[additionalR] == arr[r]) {
                        additionalR--;
                    }

                    cnt += (additionalL - l) * (r - additionalR); // a * b 만큼 조합 가능
                    l = additionalL;
                    r = additionalR;
                }
            }
        }

    }
}