import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 우선순위 큐를 이용한 방법
class Main {
    
    // 우선순위 큐
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] == b[1]) ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
    // 결과로 출력할 변순
    static int result = 0;
    // 현재 시작시간
    static int startTime = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 회의실의 갯수
        int N = Integer.parseInt(br.readLine());

        // 회의 시간을 큐에 넣기
        for (int i = 0; i < N; i++) {
            StringTokenizer time = new StringTokenizer(br.readLine());
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(time.nextToken());
            arr[1] = Integer.parseInt(time.nextToken());
            pq.offer(arr);
        }

        result++;
        int[] firstTime =  pq.poll();
        startTime = firstTime[1];

        while (!pq.isEmpty()) {
            int[] time = pq.poll();

            if (startTime <= time[0]) {
                startTime = time[1];
                result++;
            }
        }

        System.out.println(result);
    }
}