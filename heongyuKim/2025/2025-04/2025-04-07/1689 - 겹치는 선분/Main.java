import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 정렬과 스위핑 알고리즘을 이용하여 해결
class Main {
    
    // 우선순위 큐 - 시작점과 끝점을 따로 저장
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? Integer.compare(o2[1], o1[1]) : Integer.compare(o1[0], o2[0]));

    static int result = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N
        int N = Integer.parseInt(br.readLine());
        
        // 우선순위 큐에 값 넣기
        for (int i = 0; i < N; i++) {
            StringTokenizer info = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(info.nextToken());
            int e = Integer.parseInt(info.nextToken());

            int[] start = new int[2];
            start[0] = s;

            int[] end = new int[2];
            end[0] = e;
            end[1] = 1;

            pq.offer(start);
            pq.offer(end);
        }

        int nowCnt = 0;
        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            if (point[1] == 0) {
                nowCnt++;
                result = Math.max(result, nowCnt);
            } else {
                nowCnt--;
            }
        }

        System.out.println(result);
    }
}