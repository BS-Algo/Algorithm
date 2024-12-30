import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int range = Integer.parseInt(br.readLine());
        int result = 0;
        int length = 1;
        int devisor = 10;

        for (int i = 1; i <= range; i++) {
            if (i % devisor == 0) {
                length++;
                devisor *= 10;
            }
            result += length;
        }

        System.out.println(result);
    }
}
