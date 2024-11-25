import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) { // 무한 루프
            int total = 0;

            String S = br.readLine().toUpperCase();

            if (S.equals("#")) {
                break; // 루프 종료
            }

            for (char s : S.toCharArray()) {
                if (s == 'A' || s == 'E' || s == 'I' || s == 'O' || s == 'U') {
                    total += 1;
                }
            }

            System.out.println(total);
        }
    }
}
