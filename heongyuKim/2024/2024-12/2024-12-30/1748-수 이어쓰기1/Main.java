import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int range = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 1; i <= range; i++) {
            int numerator = i;
            int length = 0;
            while (numerator != 0) {
                numerator /= 10;
                length++;
            }

            result += length;
        }

        System.out.println(result);
    }
}
