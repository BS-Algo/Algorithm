import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// 복습 - i - 1, i,  i + 1 방식이 아닌 i, i + 1, i + 2 방식으로 진행하는 코드
class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N
        int N = Integer.parseInt(br.readLine());

        String now = br.readLine();
        String want = br.readLine();

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = now.charAt(i) - '0';
        }

        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            b[i] = want.charAt(i) - '0';
        }

        int[] c = Arrays.copyOf(a, N);
        c[0] = 1 - c[0];
        c[1] = 1 - c[1];

        int answer = solve(N, a, b);
        int answer2 = solve(N, c, b);
        if (answer2 != -1) {
            answer2++;
        }

        if (answer == -1) {
            System.out.println(answer2);
        } else if (answer2 == -1) {
            System.out.println(answer);
        } else {
            System.out.println(Math.min(answer, answer2));
        }
    }

    private static int solve(int N, int[] a, int[] b) {
        int cnt = 0;

        for (int i = 0; i < N-1; i++) {
            if (a[i] != b[i]) {
                cnt++;
                a[i] = 1 - a[i];
                a[i + 1] =  1 - a[i + 1];
                if (i != N - 2) {
                    a[i + 2] = 1 - a[i + 2];
                }
            }
        }

        // 끝이 같지 않으면 -1 처리
        return a[N - 1] != b[N - 1] ? -1 : cnt;

    }
}