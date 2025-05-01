import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        // greedy
        int cnt = 1;
        while (N >= cnt) {
            N -= cnt;
            cnt++;
        }

        System.out.println(cnt - 1);
    }
}
