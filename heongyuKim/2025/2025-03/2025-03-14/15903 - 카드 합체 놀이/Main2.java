import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 우선 순위 큐를 사용하지 않고 푸는 방법
// Arrays.sort를 사용하기 때문에 평균 및 최선의 경우 : O(nlogn), 최악의 경우 : O(n²)
// 메모리 : 27368KB, 시간 : 668ms
// 시간 복잡도 : O(m * n²)
class Main2 {

    // 숫자들을 받을 배열
    static long[] nums;

    // 결과로 출력할 변수
    static long result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n과 m
        StringTokenizer info = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(info.nextToken());
        int m = Integer.parseInt(info.nextToken());

        // 배열 생성
        nums = new long[n];

        // 숫자 받기
        StringTokenizer numbers = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numbers.nextToken());
        }

        for (int i = 0; i < m; i++) {
            // 오름차순 정렬
            Arrays.sort(nums);

            // 정렬 후 첫번째 원소와 두번째 원소 더한 값을 다시 할당하기
            long sum = nums[0] + nums[1];
            nums[0] = sum;
            nums[1] = sum;
        }

        // 합산
        for (int i = 0; i < n; i++) {
            result += nums[i];
        }

        System.out.println(result);

    }
}