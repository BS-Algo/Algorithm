import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 투 포인터의 핵심은 특정 조건에 따라서 start와 end를 증가시키거나 감소시키는 것이 핵심이다.
class Main {

    // 숫자들을 담을 배열
    static int[] arr;

    // 결과로 출력할 변수
    static int result;
    
    // 시작점을 나타낼 인덱스
    static int startIdx = 0;

    // 끝점을 나타낼 인덱스
    static int endIdx;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자의 갯수
        int count = Integer.parseInt(br.readLine());

        // 배열 생성
        arr = new int[count];

        // endIdx설정
        endIdx = count - 1;

        StringTokenizer nums = new StringTokenizer(br.readLine());
        
        // 배열에 숫자 넣기
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(nums.nextToken());
        }

        // 오름차순으로 정렬하기 - 왜냐하면 음수 양수 0의 숫자가 주어지기 때문
        Arrays.sort(arr);

        // 배열에 있는 수를 하나씩 비교하면서 좋은 수가 나오면 결과에 +1
        for (int i = 0; i < count; i++) {

            int num = arr[i];

            while (startIdx < endIdx) {
                
                // 두 수의 합이 num과 같을 때
                if (num == arr[startIdx] + arr[endIdx]) {
                    // 뽑은 수로 합을 하면 안되므로 제외 시키기
                    if (startIdx != i && endIdx != i) {
                        result++;
                        break;
                    } else if (startIdx == i) {
                        startIdx++;
                    } else {
                        endIdx--;
                    }
                    
                } else if (num < arr[startIdx] + arr[endIdx]) {
                    endIdx--;
                } else {
                    startIdx++;
                }

            }

            startIdx = 0;
            endIdx = count - 1;
        }

        System.out.println(result);
    }
}