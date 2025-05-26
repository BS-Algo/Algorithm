import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 조합으로 푸는 문제였다. 감소하는 수를 모두 list에 저장한 다음에 N번째의 수를 출력하는 문제였다.
// DFS로 모든 감소하는 수를 만든 다음 출력.
public class Main {
    static int N;
    static ArrayList<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if (N < 10) {
            System.out.println(N);
            return;
        } else if (N >= 1023) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 10; i++) {
            dfs(i);
        }

        Collections.sort(list);
        System.out.println(list.get(N));
    }

    // 모든 감소하는 수를 만들기
    private static void dfs(long num) {
        list.add(num);
        long mod = num % 10;
        if (mod == 0) {
            return;
        }

        for (long i = mod - 1; i >= 0; i--) {
            long value = num * 10 + i;
            dfs(value);
        }
    }
}