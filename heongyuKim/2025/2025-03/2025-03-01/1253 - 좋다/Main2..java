import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 투 포인터의 본질을 제대로 인지하지 않고 짠 코드인데 이렇게 작성하게 되면 성능이 너무 안좋고 테케에 의해서 운이 좋게 통과 한 것이기 때문에 다른 코드로 수정을 하였다.
class Main {

    // 숫자들을 담을 배열
    static int[] arr;

    // 결과로 출력할 변수
    static int result;
    
    // 시작점을 나타낼 인덱스
    static int startIdx = 0;

    // 끝점을 나타낼 인덱스
    static int endIdx = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자의 갯수
        int count = Integer.parseInt(br.readLine());

        // 배열 생성
        arr = new int[count];

        StringTokenizer nums = new StringTokenizer(br.readLine());
        
        // 배열에 숫자 넣기
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(nums.nextToken());
        }

        // 배열에 있는 수를 하나씩 비교하면서 좋은 수가 나오면 결과에 +1
        for (int i = 0; i < count; i++) {

            int num = arr[i];

            while (startIdx < count && endIdx < count) {

                if (num == arr[startIdx] + arr[endIdx] && (startIdx != i && endIdx != i)) {
                    result++;
                    break;
                } else {
                    if (endIdx == count - 1) {
                        startIdx++;
                        endIdx = startIdx + 1;
                    } else {
                        endIdx++;
                    }
                }
            }

            startIdx = 0;
            endIdx = 1;
        }

        System.out.println(result);
    }
}