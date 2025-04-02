import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 반례를 너무 깊게 생각을 안한듯하다...
class Main {
    
    // 숫자 배열
    static int[] nums;

    // 결과로 출력할 StringBuilder
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N
        int N = Integer.parseInt(br.readLine());

        // 배열 생성
        nums = new int[N];

        StringTokenizer info = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(br.readLine());

        // 배열에 숫자 넣기
        for (int i = 0 ; i < N; i++) {
            nums[i] = Integer.parseInt(info.nextToken());
        }

        // 교환 가능한 범위 내에서 가장 큰 수를 앞으로 보내는 로직
        for (int i = 0;  i < N && count > 0;  i++) {

            int maxIdx = i;
            for (int j = i + 1; j < N && j <= i + count; j++) {
                if (nums[j] > nums[maxIdx]) {
                    maxIdx = j;
                }
            }

            count -= maxIdx - i;

            for (int k = maxIdx; k > i; k--) {
                int temp = nums[k];
                nums[k] = nums[k - 1];
                nums[k - 1] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            result.append(nums[i]).append(" ");
        }

        System.out.println(result.toString());
    }
}