import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // M년 주기
            int N = Integer.parseInt(st.nextToken()); // N년 주기
            int x = Integer.parseInt(st.nextToken()); // 목표 x
            int y = Integer.parseInt(st.nextToken()); // 목표 y

            int lcm = lcm(M, N); // 최대 해: 최소공배수
            boolean found = false;

            // x를 기준으로, x + M * i 형태로 탐색
            for (int i = 0; x + M * i <= lcm; i++) {
                int year = x + M * i;
                // year에서의 y값이 실제 y와 맞는지 확인
                int curY = year % N == 0 ? N : year % N;

                if (curY == y) {
                    sb.append(year).append('\n');
                    found = true;
                    break;
                }
            }

            if (!found) {
                sb.append(-1).append('\n');
            }
        }

        System.out.print(sb);
    }

    // 최대공약수 (유클리드 호제법)
    private static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    // 최소공배수
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
