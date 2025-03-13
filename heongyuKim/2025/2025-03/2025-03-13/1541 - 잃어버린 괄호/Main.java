import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 덧셈을 먼저 처리한 후 마지막에 뺄셈을 처리하는 것이 핵심
class Main {

    // 결과로 출력할 변수
    static int result = 0;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String form = br.readLine();

        // -를 제외
        String[] plusNums = form.split("[-]");

        // 덧셈을 처리한 결과를 담을 배열
        int[] addNums = new int[plusNums.length];
        
        // 더하기부터 처리하기
        for (int i = 0; i < plusNums.length; i++) {
            int sum = 0;
            String[] nums = plusNums[i].split("[+]");

            for (int j = 0; j < nums.length; j++) {
                sum += Integer.parseInt(nums[j]);
            }

            addNums[i] = sum;
        }

        // 뺄셈 처리
        result = addNums[0]; // 첫번째 수를 먼저 결과에 할당하여 뺄셈을 계산하기
        for (int i = 1; i < addNums.length; i++) {
            result -= addNums[i];
        }

        System.out.println(result);

    }
}