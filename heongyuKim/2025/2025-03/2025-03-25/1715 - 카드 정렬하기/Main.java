import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


// 처음에는 그냥 정렬해서 답을 바로 도출하는 간단한 문제인줄 알았으나
// 반례로 합이 나머지 값들보다 클경우 일반적인 오름차순 정렬로는 최소를 도출할 수 없기 때문에 우선순위 큐를 사용해야 함.
class Main {

    static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });

    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }


        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int sum = first + second;
            result += sum;
            pq.offer(sum);
        }

        System.out.println(result);
    }
}