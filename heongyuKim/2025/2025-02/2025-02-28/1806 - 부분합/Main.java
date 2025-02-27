import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 처음에 2중 배열을 이용하여 누적합 배열을 이용하려고 했으나 시간초과가 발생하였다.
// 그래서 힌트의 힘을 빌렸더니 투 포인터라는 것을 이용해야 한다는 것을 알게 되었다.
// 기존 이중 배열은 시간 복잡도 O(N제곱)이라서 시간 초과가 발생하였으며 아래 코드에서 작성한 투 포인터는 O(N)이므로 제한 시간 안에 해결이 가능한 것이다.
class Main {

    // 누적합 배열
    static int[] prefixArr;

    // S
    static int S;

    // 시작 인덱스
    static int startIdx = 0;

    // 끝 인덱스
    static int endIdx = 1;
    
    // 결과
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N과 S 받기
        StringTokenizer info = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(info.nextToken());
        S = Integer.parseInt(info.nextToken());

        // 누적합 배열 생성
        prefixArr = new int[N + 1];

        // 누적합 계산 후 넣기
        StringTokenizer nums = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            int num = Integer.parseInt(nums.nextToken());
            prefixArr[i] = prefixArr[i - 1] + num;
        }

        // 제일 긴 길이부터 1까지의 길이에 대해서 S를 넘는지 계산 후 결과에 적용 - 투포인터 이용
        while (startIdx < N + 1 && endIdx < N + 1) {
            int sum = prefixArr[endIdx] - prefixArr[startIdx];

            if (sum < S) {
                endIdx++;
            } else {
                result = Math.min(result, endIdx - startIdx);
                startIdx++;
            }
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }

    }
}