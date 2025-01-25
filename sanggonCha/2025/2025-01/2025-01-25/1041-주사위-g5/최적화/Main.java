import java.io.*;
import java.util.*;

public class Main {
    static int sum, maxNum, minNum, minTwoSum, minThreeSum;
    static int[] dice, twoSum, threeSum;

    // 최소값 찾기
    private static void findMin() {
        minNum = 50;
        for (int num : dice) {
            minNum = Math.min(num, minNum);
        }
    }

    // 인접한 두 면의 합의 최소합 찾기
    private static void findMinTwoSum() {
        minTwoSum = 100;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                // 두 면이 평행한 면이면 인접하지 못 한다.
                // 평행한 면들의 인덱스의 합은 5가 된다.
                if (i + j != 5) {
                    minTwoSum = Math.min(dice[i] + dice[j], minTwoSum);
                }
            }
        }
    }

    // 인접한 세 면의 최소합 찾기
    private static void findMinThreeSum() {
        minThreeSum = 0;
        for (int i = 0; i < 3; i++) {
            // 평행한 두 면 중에서 무엇을 선택하든, 선택된 세 면은 인접한다.
            // 따라서 평행한 두 면 중에서 더 작은 값을 사용하면 된다.
            minThreeSum += Math.min(dice[i], dice[5 - i]);
        }
    }

    // 메인 함수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        dice = new int[6];
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            sum = 0;
            maxNum = 0;
            for (int num : dice) {
                sum += num;
                maxNum = Math.max(num, maxNum);
            }
            System.out.println(sum - maxNum);
            return;
        }

        findMin(); // 최소값 찾기
        findMinTwoSum(); // 인접한 두 면의 최소합 찾기
        findMinThreeSum(); // 인접한 세 면의 최소합 찾기

        if (N == 2) {
            // 3합 * 4 + 2합 * 4
            System.out.println(minTwoSum * 4 + minThreeSum * 4);
        } else {
            // 3합 * 4
            // + 1합 * (N-2)^2 * 5
            // + 1합 * (N-2) * 4
            // + 2합 * (8N-12)
            // 매우 큰 값이 될 수도 있어서 long 타입 변수로 처리
            long ans = (long) minThreeSum * 4
                    + (long) minNum * (N - 2) * (N - 2) * 5
                    + (long) minNum * (N - 2) * 4
                    + (long) minTwoSum * (8L * N - 12); // 8L은 8과 같지만 오버플로우가 발생하지 않도록 해준다
            System.out.println(ans);
        }
    }
}