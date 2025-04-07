import java.io.*;
import java.util.*;


public class Main {
    static int A, B;

    static class Node {
        int num;
        String commands;

        Node(int num, String commands) {
            this.num = num;
            this.commands = commands;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T 입력받기
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 입력 받기
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            // BFS
            bfs();
        }

    }

    //** BFS를 통해서 B를 찾아가는 최소 횟수를 출력하고 종료하는 함수 **/
    private static void bfs() {
        boolean[] visited = new boolean[10000]; // 수는 최대 네 자릿수 -> 10000개의 배열로 체크 가능
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(A, ""));
        visited[A] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int num = node.num;
            String commands = node.commands;

            // 종료 조건
            if (num == B) {
                System.out.println(commands);
                return;
            }


            // D: *2 (+ % 10000)
            int d = num * 2;
            if (d > 9999) d %= 10000;
            if (!visited[d]) {
                visited[d] = true;
                queue.offer(new Node(d, commands + "D"));
            }
            // S: -1 (0 -> 9999)
            int s = num - 1;
            if (s == -1) s = 9999;
            if (!visited[s]) {
                visited[s] = true;
                queue.offer(new Node(s, commands + "S"));
            }

            // L: ←
            int l = (num % 1000) * 10 + (num / 1000);
            if (!visited[l]) {
                visited[l] = true;
                queue.offer(new Node(l, commands + "L"));
            }

            // R: →
            int r = (num % 10) * 1000 + (num / 10);
            if (!visited[r]) {
                visited[r] = true;
                queue.offer(new Node(r, commands + "R"));
            }
        }
    }
}