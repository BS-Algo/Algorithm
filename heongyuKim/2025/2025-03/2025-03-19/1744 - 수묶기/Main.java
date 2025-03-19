import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 처음에는 하나의 배열에서 해결하려고 했으나 -1, 0, 1의 부분을 처리하기에 어렵다고 판단하여 양수와 음수의 배열로 나누어 저장하여 해결하였다.
// 문제를 작게 쪼개어 해결한다는 부분에서 그리디 방식에 부합하다.
// 아래는 처음 맞출때 사용한 코드 
class Main {

    // 양수만 담을 수열
    static Integer[] positiveNums;
    
    // 음수만 담을 수열
    static Integer[] negativeNums;
    
    // 0의 유무
    static boolean isZero = false;

    // 결과
    static long result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열의 크기
        int N = Integer.parseInt(br.readLine());

        // 수열 생성
        positiveNums = new Integer[N];
        negativeNums = new Integer[N];

        // 수열에 수 넣기
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (0 < num) {
                positiveNums[i] = num;
                negativeNums[i] = 0;
            } else if (0 > num){
                negativeNums[i] = num;
                positiveNums[i] = 0;
            } else {
                isZero = true;
                positiveNums[i] = 0;
                negativeNums[i] = 0;
            }
        }

        // 각 배열을 정렬하기
        // 오름차순
        Arrays.sort(negativeNums);

        // 내림차순
        Arrays.sort(positiveNums, Comparator.reverseOrder());

        // 양수 계산
        for (int i = 0; i < N; i += 2) {
            if (i == N - 1) {
                result += positiveNums[i];
            } else {
                if (positiveNums[i] > 0 && positiveNums[i + 1] > 0) {
                    long sum = 0;
                    long mul = 0;

                    sum = (long) positiveNums[i] + positiveNums[i + 1];
                    mul = (long) positiveNums[i] * positiveNums[i + 1];

                    result += Math.max(sum, mul);
                } else {
                    result += positiveNums[i];
                    break;
                }
            }
        }

        // 음수 계산
        for (int i = 0; i < N; i += 2) {
            if (i == N - 1) {
                if (!isZero) {
                    result += negativeNums[i];
                }
            } else {
                if (negativeNums[i] < 0 && negativeNums[i + 1] < 0) {
                    long sum = 0;
                    long mul = 0;

                    sum = (long) negativeNums[i] + negativeNums[i + 1];
                    mul = (long) negativeNums[i] * negativeNums[i + 1];

                    result += Math.max(sum, mul);
                } else {
                    if (!isZero) {
                        result += negativeNums[i];
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}