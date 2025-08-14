import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;

    static int[] cookies;

    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        M = Integer.parseInt(info.nextToken());
        N = Integer.parseInt(info.nextToken());

        cookies = new int[N];

        StringTokenizer cookieLen = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cookies[i] = Integer.parseInt(cookieLen.nextToken());
        }

        Arrays.sort(cookies);

        int start = 1;
        int end = cookies[N - 1];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = 0;

            for (int i = 0; i < N; i++) {
                count += cookies[i] / mid;
            }

            if (count >= M) {
                result = Math.max(mid, result);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
