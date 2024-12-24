import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] AP = br.readLine().split(" ");
        int A = Integer.parseInt(AP[0]);
        int P = Integer.parseInt(AP[1]);

        // 해쉬셋이 아니라 해쉬 맵을 써서 추가되는 수마다 번호를 부여하면 될 듯
        HashMap<Integer, Integer> nums = new HashMap<>();
        int index = 1;

        while (!nums.containsKey(A)) { // A가 더이상 해쉬셋에 포함되어있지 않을 때까지
//            System.out.printf("%d: %d\n", A, index);
            nums.put(A, index);
            index++;

            int nextA = 0;
            while (A > 0) {
                int rest = A % 10; // 나머지를 저장
                A /= 10; // A에서 1의 자리수를 제거
                nextA += (int) Math.pow(rest, P); // 나머지의 P제곱수를 누적합
            }
            A = nextA;
        }
        System.out.println(nums.get(A) - 1);
    }
}