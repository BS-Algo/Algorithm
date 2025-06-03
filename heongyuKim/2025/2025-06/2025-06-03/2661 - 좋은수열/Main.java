import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// dfs는 단순히 모든 조합을 위한 로직이고
// 거기에 추가적인 로직으로 가지치기를 하는 문제였다...
// 처음에는 1,2,3으로 만들 수 있는 모든 조합을 생각하여 배열에 그 값을 저장한 후 그것을 활용해서 dfs를 하고
// 좋은 수열인지 판별하려고 했는데 너무 복잡하게 되어서 생각이 꼬여 버렸음...
// 이 방법으로는 안되는 이유가 블록으로 처리가 되기 때문에 1, 2, 3을 하나씩 붙였을 경우처럼 처리가 안되기 때문이다. 그래서 중간에 좋은 순열이 있어서 체크가 안된다.
// 그러므로 답이 틀리다는 것이다.
// 좋은 수열들에서 가장 작은 수를 나타내는 수열만 출력하는 것에서 isSolved로 잘 처리하였으나
// 조합과 가지치기 조건을 제대로 생각하지 못했음.
// 복습 필요!
public class Main {
    static int N;

    static boolean isSolved = false;
    static String result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(0, "");
        System.out.println(result);
    }

    private static void dfs(int depth, String cur) {
        // 가지치기
        if (!checkGood(cur)) return;

        if (depth == N) {
            isSolved = true;
            result = cur;
            return;
        }

        for (int i = 1; i < 4; i++) {
            dfs(depth + 1, cur + i);
            if (isSolved) return;
        }
    }


    private static boolean checkGood(String cur) {
        int len = cur.length();

        for (int i = 1; i <= len / 2; i++) {
            String last = cur.substring(len - i); // 마지막
            String beforeLast = cur.substring(len - 2 * i, len - i); // 마지막 전

            if (last.equals(beforeLast)) return false;
        }

        return true;
    }
}