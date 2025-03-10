import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이 방식은 그리디로 푸는 방식이 아니다... 운이 좋게도 풀린 것이다.
// 그리디로 풀려고 하는 방법은 Main1 파일에 있다.
class Main {

    static boolean flag = false;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nums = br.readLine();
        
        // 현재 수와 그 다음 수를 비교하기
        for (int i = 0; i < nums.length() - 1; i++) {

            // 만약 플래그가 false이면
            if (!flag && nums.charAt(i) != nums.charAt(i + 1)) {
                // result에 1 더하고 플래그 true처리
                result++;
                flag = true;
            } else if (flag && nums.charAt(i) != nums.charAt(i + 1)) {
                flag = false;
            }

        }

        System.out.println(result);
    }
}