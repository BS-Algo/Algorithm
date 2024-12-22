import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n < 10) {
            System.out.println(n);
        } else {

            // 1     ->     9        : 9    * 1 = 9
            // 10    ->     99       : 90   * 2 = 180
            // 100    ->    999      : 900  * 3 = 2700

            // n = 55
            // i = 1, a = 9 -> ans = 9
            // b = n - a = 55 - 9 = 46
            int ans = 0;
            int powN = 9;
            int c = 0;
            int d = 0;
            for (int i = 1; i < String.valueOf(n).length(); i++) {
                powN = 9 * (int) Math.pow(10, i - 1);
                ans += powN * i;
                c = n - ((int) Math.pow(10, i) - 1);
                d = i + 1;
            }

            ans += c * d;

            System.out.println(ans);
        }
    }
}