import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int leftCutOff = (int) Math.round(n * (3 / 20.0));
        int rightCutOff = leftCutOff;
        int div = n - leftCutOff * 2;

        int[] countList = new int[32];
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(br.readLine());
            countList[score]++;
        }

        for (int i = 1; i <= 30; i++) {
            if (leftCutOff <= 0) {
                break;
            }

            if (countList[i] > leftCutOff) {
                countList[i] -= leftCutOff;
                break;
            } else {
                leftCutOff -= countList[i];
                countList[i] = 0;
            }
        }

        for (int i = 30; i > 0; i--) {
            if (rightCutOff <= 0) {
                break;
            }

            if (countList[i] > rightCutOff) {
                countList[i] -= rightCutOff;
                break;
            } else {
                rightCutOff -= countList[i];
                countList[i] = 0;
            }
        }

        int ans = 0;
        for (int i = 0; i <= 30; i++) {
            ans += countList[i] * i;
        }
        ans = (int) Math.round(ans / (double) div);
        System.out.println(ans);
    }
}