import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;

    static String[] words;
    static boolean[] visited;

    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        K = Integer.parseInt(info.nextToken());

        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // 기본적으로 anta와 tica로 끝나는 말만 존재하기 때문에 a, n, t, i, c를 무조건 포함해야한다.
        // 그러므로 K가 5보다 작으면 0을 출력한다. 또한 K가 26이면 모든 단어를 만들 수 있기 때문에 N개로 출력하기
        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;

        dfs(0, 0);

        System.out.println(result);
    }


    private static void dfs(int depth, int index) {

        if (depth == K - 5) {
            int count = 0;

            for (int i = 0; i < N; i++) {
                String word = words[i];
                boolean isRead = true;
                for (int j = 0; j < word.length(); j++) {
                    if (!visited[word.charAt(j) - 'a']) {
                        isRead = false;
                        break;
                    }
                }
                if (isRead)
                    count++;
            }

            result = Math.max(count, result);
            return;
        }

        for (int i = index; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}