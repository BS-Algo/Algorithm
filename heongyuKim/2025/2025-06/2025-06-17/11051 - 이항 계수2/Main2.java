import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이 로직대로 작성하게 되면 / by zero 에러가 발생하게 되는데 그 이유는 1000!쯤 되는 수는 long으로도 표현하지 못하는 수가 되기 때문이다.
public class Main2 {

    static int N;
    static int K;
    static long[] arr;

    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        K = Integer.parseInt(info.nextToken());

        if (N == K) {
            System.out.println(1);
            return;
        }

        long mul = 1;

        for (int i = 1; i <= N; i++) {
            mul *= i;
        }

        arr = new long[N + 1];

        for (int i = 0; i < N + 1; i++) {
            long num = 1;
            for (int j = 1; j <= i; j++) {
                num *= j;
            }

            arr[i] = num;
        }

        long first = arr[K];
        long second = arr[N - K];

        result = (mul / first) / second;

        System.out.println(result % 10007);

    }
}