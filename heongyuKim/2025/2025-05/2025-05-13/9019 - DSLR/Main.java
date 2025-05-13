import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {
    static int T;

    static String[] command;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer info = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(info.nextToken());
            int goal = Integer.parseInt(info.nextToken());

            command = new String[10000];
            Arrays.fill(command, "");

            visited = new boolean[10000];
            String result = bfs(start, goal);

            System.out.println(result);
        }
    }

    private static String bfs(int start, int goal) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        String result = "";

        while (!q.isEmpty()) {
            int node = q.poll();

            if (node == goal) {
                result = command[node];
                break;
            }
            
            // D 연산
            int numD = D(node);
            if (!visited[numD]) {
                visited[numD] = true;
                command[numD] = command[node] + "D";
                q.offer(numD);
            }

            // S 연산
            int numS = S(node);
            if (!visited[numS]) {
                visited[numS] = true;
                command[numS] = command[node] + "S";
                q.offer(numS);
            }

            // L 연산
            int numL = L(node);
            if (!visited[numL]) {
                visited[numL] = true;
                command[numL] = command[node] + "L";
                q.offer(numL);
            }

            // R 연산
            int numR = R(node);
            if (!visited[numR]) {
                visited[numR] = true;
                command[numR] = command[node] + "R";
                q.offer(numR);
            }
            
        }

        return result;
    }

    private static int D(int n) {
        return (2 * n) % 10000;
    }

    private static int S(int n) {
        return n == 0 ? 9999 : n - 1;
    }

    private static int L(int n) {
        return (n % 1000) * 10 + n / 1000;
    }

    private static int R(int n) {
        return (n % 10) * 1000 + n / 10;
    }
}