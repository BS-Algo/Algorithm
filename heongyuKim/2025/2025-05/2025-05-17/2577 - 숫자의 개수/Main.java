import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 브론즈 출첵 ㅎㅎ...
class Main {
    static int A;
    static int B;
    static int C;

    static int[] result = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        int mul = A * B * C;
        String strMul = String.valueOf(mul);

        for (int i = 0; i < strMul.length(); i++) {
            int num = Integer.parseInt(String.valueOf(strMul.charAt(i)));
            result[num]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(result[i]);
        }

    }
}
