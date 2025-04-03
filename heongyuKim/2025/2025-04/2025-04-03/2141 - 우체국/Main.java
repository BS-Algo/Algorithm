import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// 처음에는 가장 많은 사람이 있는 마을 위주로 생각을 했었지만 그렇게 계산하게 되면 시간초과가 나게 됨.
// 결국은 사람수의 중간값을 넘어서는 순간이 각 사람과의 거리가 제일 최소이다.
class Main {

    // 우선순위 큐
    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    });

    // 총거리
    static long total = 0;
    
    // 결과로 출력할 변수
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N
        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐와 큐에 값넣기
        for (int i = 0; i < N; i++) {
            StringTokenizer info = new StringTokenizer(br.readLine());
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(info.nextToken());
            arr[1] = Integer.parseInt(info.nextToken());
            total += arr[1];
            pq.offer(arr);
        }

        long sum = 0;

        while (!pq.isEmpty()) {

            int[] arr = pq.poll();
            int town = arr[0];
            long people = arr[1];

            sum += people;

            if ((total + 1) / 2 <= sum) {
                result = town;
                break;
            }
        }


        System.out.println(result);
    }
}