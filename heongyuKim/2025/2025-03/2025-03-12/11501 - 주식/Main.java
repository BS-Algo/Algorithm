import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 처음에 순방향으로 해서 커지다가 작아지는 부분이 나오면 주식을 팔아서 계산을 하려고 했지만 최댓값이 아닌 경우는
// 최댓값이 아니라서 순방향으로 처리하기에는 조금 복잡하다고 판단하여(여러가지 조건 분기) 역방향으로 편하게 처리했다.
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            long result = 0;

            // N
            int N = Integer.parseInt(br.readLine());

            // 숫자를 담을 배열 생성
            int[] nums = new int[N];
            
            // 배열에 숫자 담기
            StringTokenizer info = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(info.nextToken());
                nums[j] = num;
            }

            int max = nums[N-1];

            for (int j = N - 2; j > -1; j--) {
                // 만약 start보다 end가 작으면
                if (nums[j] < max) {
                    result += max - nums[j];
                } else if (nums[j] > max) {
                    max = nums[j];
                }
            }

            System.out.println(result);

        }
    }
}