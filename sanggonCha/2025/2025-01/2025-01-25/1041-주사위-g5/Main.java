import java.io.*;
import java.util.*;

public class Main {
    static int sum, maxNum, minNum, minTwoSum, minThreeSum;
    static int[] dice, twoSum, threeSum;

    // 최소값 찾기
    private static void findMin() {
        minNum = 50;
        for (int num : dice) {
            sum += num;
            minNum = Math.min(num, minNum);
        }
    }

    // 인접한 두 면의 합의 최소합 찾기
    private static void findMinTwoSum() {
        minTwoSum = 100; // 쓰여 있는 수는 50보다 작거나 같은 자연수

        twoSum = new int[12];

        // dice A B C D E F
        //      0 1 2 3 4 5
        twoSum[0] = dice[0] + dice[1];  // 1.  A B
        twoSum[1] = dice[0] + dice[2];  // 2.  A C
        twoSum[2] = dice[0] + dice[3];  // 3.  A D
        twoSum[3] = dice[0] + dice[4];  // 4.  A E
        twoSum[4] = dice[1] + dice[2];  // 5.  B C
        twoSum[5] = dice[1] + dice[3];  // 6.  B D
        twoSum[6] = dice[1] + dice[5];  // 7.  B F
        twoSum[7] = dice[2] + dice[4];  // 8.  C E
        twoSum[8] = dice[2] + dice[5];  // 9.  C F
        twoSum[9] = dice[3] + dice[4];  // 10. D E
        twoSum[10] = dice[3] + dice[5]; // 11. D F
        twoSum[11] = dice[4] + dice[5]; // 12. E F

        for (int t : twoSum) if (t < minTwoSum) minTwoSum = t;
    }

    // 인접한 세 면의 최소합 찾기
    private static void findMinThreeSum() {
        minThreeSum = 150; // 쓰여 있는 수는 50보다 작거나 같은 자연수

        threeSum = new int[8];

        // dice A B C D E F
        //      0 1 2 3 4 5
        threeSum[0] = dice[0] + dice[1] + dice[2];  // 1.  A B C
        threeSum[1] = dice[0] + dice[1] + dice[3];  // 2.  A B D
        threeSum[2] = dice[0] + dice[2] + dice[4];  // 3.  A C E
        threeSum[3] = dice[0] + dice[3] + dice[4];  // 4.  A D E
        threeSum[4] = dice[1] + dice[2] + dice[5];  // 5.  B C F
        threeSum[5] = dice[1] + dice[3] + dice[5];  // 6.  B D F
        threeSum[6] = dice[2] + dice[4] + dice[5];  // 7.  C E F
        threeSum[7] = dice[3] + dice[4] + dice[5];  // 8.  D E F

        for (int t : threeSum) if (t < minThreeSum) minThreeSum = t;
    }

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