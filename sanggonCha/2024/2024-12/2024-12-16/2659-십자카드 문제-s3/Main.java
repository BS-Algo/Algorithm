import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        int num3 = Integer.parseInt(numbers[2]);
        int num4 = Integer.parseInt(numbers[3]);

        int timeNum = calculateTimeNumber(num1, num2, num3, num4);


        int[] countList = new int[10000];
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        countList[calculateTimeNumber(i, j, k, l)] = 1;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1111; i < 10000; i++) {
            if (countList[i] == 1) {
                ans++;
                if (i == timeNum) {
                    System.out.println(ans);
                    break;
                }
            }
        }
        }

    public static int calculateTimeNumber(int num1, int num2, int num3, int num4) {
        int timeNum = 1000 * num1 + 100 * num2 + 10 * num3 + 1 * num4;
        timeNum = Math.min(timeNum, 1000 * num2 + 100 * num3 + 10 * num4 + 1 * num1);
        timeNum = Math.min(timeNum, 1000 * num3 + 100 * num4 + 10 * num1 + 1 * num2);
        timeNum = Math.min(timeNum, 1000 * num4 + 100 * num1 + 10 * num2 + 1 * num3);

        return timeNum;
    }
}