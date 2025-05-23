import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static int N;
    
    // 최대힙
    static PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    // 최소힙
    static PriorityQueue<Integer> right = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            // 1. 먼저 최대힙에 넣기
            left.offer(num);

            // 2. 정렬 조건 : left의 최대값 -> right의 최소값이 되도록 조정
            if (!right.isEmpty() && left.peek() > right.peek()) {
                right.offer(left.poll());
            }

            // 3. 힙 균형 유지 (left는 항상 right보다 크거나 같아야 함)
            if (left.size() > right.size() + 1) {
                right.offer(left.poll());
            } else if (right.size() > left.size()) {
                left.offer(right.poll());
            }

            // 4. 중간값 출력
            System.out.println(left.peek());
        }
    }
}