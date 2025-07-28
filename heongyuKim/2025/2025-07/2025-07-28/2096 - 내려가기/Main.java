import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// Java 15로 제출하면 메모리 제한이 안풀려 있으므로 11로 제출해야함.
public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer info = new StringTokenizer(br.readLine());

            int cur1 = Integer.parseInt(info.nextToken());
            int cur2 = Integer.parseInt(info.nextToken());
            int cur3 = Integer.parseInt(info.nextToken());

            if (i == 0) {
                maxDp[0] = minDp[0] = cur1;
                maxDp[1] = minDp[1] = cur2;
                maxDp[2] = minDp[2] = cur3;
            } else {
                int maxTemp1 = maxDp[0];
                int maxTemp2 = maxDp[1];
                int maxTemp3 = maxDp[2];

                int minTemp1 = minDp[0];
                int minTemp2 = minDp[1];
                int minTemp3 = minDp[2];

                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        maxDp[0] = cur1 + Math.max(maxTemp1, maxTemp2);
                        minDp[0] = cur1 + Math.min(minTemp1, minTemp2);
                    } else if (j == 2) {
                        maxDp[2] = cur3 + Math.max(maxTemp2, maxTemp3);
                        minDp[2] = cur3 + Math.min(minTemp2, minTemp3);
                    } else {
                        maxDp[1] = cur2 + Math.max(Math.max(maxTemp1, maxTemp2), maxTemp3);
                        minDp[1] = cur2 + Math.min(Math.min(minTemp1, minTemp2), minTemp3);
                    }
                }
            }
        }

        int max = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
        int min = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);

        System.out.println(max + " " + min);
    }
}
