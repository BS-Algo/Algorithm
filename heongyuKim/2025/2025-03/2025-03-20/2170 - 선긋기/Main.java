import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


// 처음에 풀었던 코드 큐를 2개를 사용하는 로직
class Main {

    // 연산에 사용할 우선순위 큐
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]));

    // 결과에 활용할 큐
    static Queue<int[]> queue = new LinkedList<>();

    // 현재 x와 y
    static int currentX = 0;
    static int currentY = 0;

    // 결과
    static long result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N
        int N = Integer.parseInt(br.readLine());
        
        // 우선순위 큐에 넣기
        for (int i = 0; i < N; i++) {
            StringTokenizer info = new StringTokenizer(br.readLine());

            int[] line = new int[2];
            line[0] = Integer.parseInt(info.nextToken());
            line[1] = Integer.parseInt(info.nextToken());

            pq.offer(line);
        }

        int[] peek = pq.peek();
        currentX = peek[0];
        currentY = peek[1];

        while (!pq.isEmpty()) {
            int[] line = pq.poll();
            int x = line[0];
            int y = line[1];

            if (currentX <= x && x <= currentY) {
                currentY = Math.max(currentY, y);

                if (pq.isEmpty()) {
                    int[] last = new int[2];
                    last[0] = currentX;
                    last[1] = currentY;
                    queue.offer(last);
                }

            } else {
                int[] add = new int[2];
                add[0] = currentX;
                add[1] = currentY;
                queue.offer(add);

                currentX = x;
                currentY = y;

                if (pq.isEmpty()) {
                    int[] last = new int[2];
                    last[0] = x;
                    last[1] = y;
                    queue.offer(last);
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] line = queue.poll();
            result += line[1] - line[0];
        }

        System.out.println(result);
    }
}