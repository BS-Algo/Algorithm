import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // pq 생성
        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> big = new PriorityQueue<>();

        while (N-- > 0) {
            small.add(Integer.parseInt(br.readLine())); // 일단 small에 넣기

            if (!big.isEmpty() && small.peek() > big.peek()) { // 보정
                small.add(big.poll()); // swap
                big.add(small.poll());
            }

            if (small.size() > big.size() + 1) { // small이 한 개 더 많아야함
                big.add(small.poll());
            }

            sb.append(small.peek()).append("\n"); // 항상 small의 peek를 출력
        }

        System.out.println(sb.toString());
    }
}
