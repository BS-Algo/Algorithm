import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        // 결과 배열
        int[] result = new int[10];

        for (int i = 0; i < input.length(); i++) {
            int checkNum = Integer.parseInt(String.valueOf(input.charAt(i)));

            // 만약 6이나 9이면 중복 처리 해줘야 함.
            if (checkNum == 6 || checkNum == 9) {
                result[9]++;
            } else {
                result[checkNum]++;
            }
        }

        if (result[9] > 1) {
            result[9] = (result[9] / 2) + (result[9] % 2);
        }


        System.out.println(Arrays.stream(result).max().getAsInt());
    }
}
