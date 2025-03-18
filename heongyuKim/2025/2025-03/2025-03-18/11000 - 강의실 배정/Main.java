import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    // 강의 시간을 담을 우선순위 큐 - 시간이 제일 빠른 순으로
    static PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
        if (o1[0] == o2[0]) {
            return o1[1] - o2[1];
        }
        return o1[0] - o2[0];
    }));

    // 결과에 활용할 우선순위 큐
    static PriorityQueue<Integer> rooms = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수강신청한 강의의 수
        int count = Integer.parseInt(br.readLine());

        // 수강신청한 시간을 우선순위 큐에 넣기
        for (int i = 0; i < count; i++) {
            StringTokenizer info = new StringTokenizer(br.readLine());
            int[] time = new int[2];
            time[0] = Integer.parseInt(info.nextToken());
            time[1] = Integer.parseInt(info.nextToken());
            pq.offer(time);
        }

        rooms.offer(0);
        
        // rooms의 peek와 pq의 peek를 비교하여 처리
        while (!pq.isEmpty()) {
            int[] time = pq.poll();

            if (rooms.peek() <= time[0]) {
                rooms.poll();
            }

            rooms.offer(time[1]);
        }

        System.out.println(rooms.size());

    }
}