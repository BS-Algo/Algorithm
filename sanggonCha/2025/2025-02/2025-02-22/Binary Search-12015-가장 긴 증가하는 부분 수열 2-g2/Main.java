import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;
    private static List<Integer> LIS = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 배열 입렫 받기
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열을 모두 순회하며 LIS에 들어갈 자리 찾기
        for (int target : arr) {
            int idx = findIndex(target); // 인덱스 저장

            if (idx == LIS.size()) { // 들어갈 자리가 없다면 끝에 추가
                LIS.add(target);
            } else {
                LIS.set(idx, target); // 해당 인덱스의 값을 덮어쓰기
            }
        }

        // LIS 배열의 길이가 정답
        System.out.println(LIS.size());
    }

    /** 이분 탐색을 통하여 target이 LIS 배열에 들어갈 인덱스의 값을 반환하는 함수 **/
    private static int findIndex(int target) {
        int left = 0, right = LIS.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target <= LIS.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return left;
    }
}