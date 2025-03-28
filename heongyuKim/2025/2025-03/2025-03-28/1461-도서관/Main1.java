import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// 깔끔한 코드
class Main1 {
    
    // 음의 우선순위 큐
    static PriorityQueue<Integer> minusPq = new PriorityQueue<>((o1, o2) -> o2 - o1);

    // 양의 우선순위 큐
    static PriorityQueue<Integer> plusPq = new PriorityQueue<>((o1, o2) -> o2 - o1);

    // 절댓값 기준 최대값이 있는 곳
    static int max = 0;
    
    // 결과로 사용할 변수
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N과 M
        StringTokenizer info = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(info.nextToken());
        int M = Integer.parseInt(info.nextToken());

        StringTokenizer nums = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(nums.nextToken());
            if (num < 0) {
                minusPq.offer(Math.abs(num));
            } else {
                plusPq.offer(num);
            }
        }

        if (plusPq.isEmpty()) {
            max = minusPq.peek();
        } else if (minusPq.isEmpty()) {
            max = plusPq.peek();
        } else {
            max = Math.max(minusPq.peek(), plusPq.peek());
        }

        while (!plusPq.isEmpty()) {
            int num = plusPq.poll();
            
            for (int i = 0; i < M - 1; i++) {
                plusPq.poll();

                if (plusPq.isEmpty()) {
                    break;
                }
            }

            result += num * 2;
        }

        while (!minusPq.isEmpty()) {
            int num = minusPq.poll();

            for (int i = 0; i < M - 1; i++) {
                minusPq.poll();

                if (minusPq.isEmpty()) {
                    break;
                }
            }

            result += num * 2;
        }

        result -= max;

        System.out.println(result);
    }
}