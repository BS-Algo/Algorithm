import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(1, "2");
        dfs(1, "3");
        dfs(1, "5");
        dfs(1, "7");

        System.out.println(result.toString());
    }

    private static void dfs(int count, String num) {
        if (count == N) {
            result.append(num).append("\n");
            return;
        }

        for (int i = 1; i <= 9; i += 2) { // 홀수만 추가 -> 이유는 2의 배수는 모두 소수가 아니기 때문에 굳이 짝수 계산을 해줄 필요가 없기 때문.
            String next = num + i;
            if (isPrime(Integer.parseInt(next))) { // 소수면 넘기기
                dfs(count + 1, next);
            }
        }
    }
    
    // 소수인지 판별하는 메서드
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}