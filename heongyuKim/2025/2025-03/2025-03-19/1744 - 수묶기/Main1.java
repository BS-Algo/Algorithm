import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// 음수는 양수와 달리 모두 곱하여 계산하는 것이 합보다 무조건 크기 때문에 양수처럼 두 수 모두가 특정 값보다 크지 않아도 된다.
class Main1 {
    // 양수만 담을 수열
    static List<Integer> positiveNums = new ArrayList<>();
    
    // 음수만 담을 수열
    static List<Integer> negativeNums = new ArrayList<>();

    // 결과
    static long result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열의 크기
        int N = Integer.parseInt(br.readLine());

        // 수열에 수 넣기
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (0 >= num) {
                negativeNums.add(num);
            } else {
                positiveNums.add(num);
            }
        }

        // 각 배열을 정렬하기
        // 오름차순
        Collections.sort(negativeNums);

        // 내림차순
        // Collections.sort(positiveNums, Collections.reverseOrder());
        positiveNums.sort(Collections.reverseOrder());

        // 양수 계산
        for (int i = 0; i < positiveNums.size(); i += 2) {
            if (i == positiveNums.size() - 1) {
                result += positiveNums.get(i);
            } else {
                // 두 수가 1이거나 둘 중 하나가 1이면 곱보다 합이 더 크므로 이에 대해서는 합으로 처리함.
                if (positiveNums.get(i) > 1 && positiveNums.get(i + 1) > 1) {
                    result += (long) positiveNums.get(i) * positiveNums.get(i + 1);
                } else {
                    result += positiveNums.get(i) + positiveNums.get(i + 1);
                }
            }
        }

        // 음수 계산
        for (int i = 0; i < negativeNums.size(); i += 2) {
            if (i == negativeNums.size() - 1) {
                result += negativeNums.get(i);
            } else {
                result += (long) negativeNums.get(i) * negativeNums.get(i + 1);
            }
        }

        System.out.println(result);
    }
}