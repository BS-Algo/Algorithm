import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // 새로운 숫자 배열을 생성
        ArrayList<Integer> nums = new ArrayList<>();

        // 첫번째에 A를 넣기
        nums.add(A);

        // 반복이 시작되는 인덱스
        int repeatIndex = 0;

        // 반복문을 통해 처음부터 끝까지 계산을 하기
        while (true) {
            int value = 0;
            String numsToStr = String.valueOf(nums.get(nums.size() - 1));
            for (int j = 0; j < numsToStr.length(); j++) {
                int base = Character.getNumericValue(numsToStr.charAt(j));
                value += (int) Math.pow(base, P);
            }

            if (nums.contains(value)) {
                repeatIndex = nums.indexOf(value);
                break;
            } else {
                nums.add(value);
            }
        }

        System.out.println(repeatIndex);
    }
}