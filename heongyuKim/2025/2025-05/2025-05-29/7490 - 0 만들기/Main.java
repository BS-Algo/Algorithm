import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static List<String> result;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            result = new ArrayList<>();

            dfs(1, "1");
            // ASCII 순서에 따라서 결과를 출력해야하기 때문에 사전순으로 정렬
            Collections.sort(result);

            for (String ans : result) {
                System.out.println(ans);
            }
            System.out.println();
        }
    }

    private static void dfs(int depth, String expression) {

        if (depth == N) {
            // 계산하기 전 공백을 제거해서 계산하기
            if (calculate(expression.replaceAll(" ", "")) == 0) {
                result.add(expression);
            }
            return;
        }

        for (String operator : new String[] {"+", "-", " "}) {
            String next = String.valueOf(depth + 1);
            dfs(depth + 1, expression + operator + next);
        }
    }

    private static int calculate(String expression) {
        // +와 - 연산자를 기준으로 나누지만 + -도 결과에 같이 넣기
        StringTokenizer st = new StringTokenizer(expression, "+|-", true);
        int sum = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            String s = st.nextToken();

            if (s.equals("+")) {
                sum += Integer.parseInt(st.nextToken());
            } else {
                sum -= Integer.parseInt(st.nextToken());
            }
        }

        return sum;
    }
}