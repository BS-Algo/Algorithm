import java.io.*;
import java.util.*;

public class Main {
    private static int N, ans = 0;
    private static char[] from1, from2, to;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        N = Integer.parseInt(br.readLine());

        // 초기 전구 입력
        from1 = new char[N];
        from2 = new char[N];

        String line = br.readLine();

        for (int i = 0; i < N; i++) {
            from1[i] = line.charAt(i);
            from2[i] = line.charAt(i);
        }

        // 완성할 전구 입력
        to = new char[N];
        line = br.readLine();
        for (int i = 0; i < N; i++) {
            to[i] = line.charAt(i);
        }

        // greedy
        int cnt1 = greedy(from1, 0);
        toggle(from2, 0);
        int cnt2 = greedy(from2, 1);

        // 출력
        if (check(from1) && check(from2)) {
            System.out.println(Math.min(cnt1, cnt2));
        } else if (check(from1)) {
            System.out.println(cnt1);
        } else if (check(from2)) {
            System.out.println(cnt2);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean check(char[] from) {
        for (int i = 0; i < N; i++) {
            if (from[i] != to[i]) {
                return false;
            }
        }
        return true;
    }

    private static void toggle(char[] from, int i) {
        for (int j = i - 1; j <= i + 1; j++) {
            if (j >= 0 && j < N) {
                from[j] = from[j] == '0' ? '1' : '0';
            }
        }
    }

    private static int greedy(char[] from, int cnt) {

        for (int i = 1; i < N; i++) {
            if (from[i - 1] != to[i - 1]) {
                toggle(from, i);
                cnt++;
            }
        }
        return cnt;
    }
}