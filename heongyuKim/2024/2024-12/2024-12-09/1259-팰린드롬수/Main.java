import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (!(input = bf.readLine()).equals("0")) {
            StringBuilder stringBuilder = new StringBuilder(input);
            String reversed = stringBuilder.reverse().toString();

            if (input.equals(reversed)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }
}
