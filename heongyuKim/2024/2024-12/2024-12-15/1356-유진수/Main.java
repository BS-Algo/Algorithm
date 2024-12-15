import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String yooJinSooStr = bf.readLine();

        if (yooJinSooStr.length() < 2) {
            System.out.println("NO");
        } else {
            // 결과
            boolean result = false;

            int front = 1;
            int back = 1;

            // 반복문을 통해 판별
            for (int i = 0; i < yooJinSooStr.length() - 1; i++) {
                front *= Character.getNumericValue(yooJinSooStr.charAt(i));
                for (int e = i+1; e < yooJinSooStr.length(); e++) {
                    back *= Character.getNumericValue(yooJinSooStr.charAt(e));
                }

                // 판별 후 유진수면 result를 true로 바꾸기
                if (front == back) {
                    result = true;
                    break;
                }
                
                // 뒷부분 초기화
                back = 1;
            }
            
            // result 결과에 따라 출력
            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            
        }
    }
}
