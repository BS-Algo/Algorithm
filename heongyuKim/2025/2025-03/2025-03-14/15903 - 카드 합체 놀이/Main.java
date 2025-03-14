import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 우선순위로 푸는 방식
// 내부 요소는 힙으로 구성되어 이진트리 구조로 이루어져 있다.
// 내부구조가 힙으로 구성되어 있기에 시간 복잡도는 O(logn)이다.
// 우선순위를 중요시해야 하는 상황에서 주로 쓰인다.
// 메모리 : 15194KB, 시간 : 152ms
// 시간 복잡도 : O(nlogn)
class Main {

    // 숫자들을 받을 우선순위 큐
    static PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

    // 결과로 출력할 변수
    static long result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n과 m
        StringTokenizer info = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(info.nextToken());
        int m = Integer.parseInt(info.nextToken());


        // 숫자 받기
        StringTokenizer numbers = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            priorityQueue.add((long) Integer.parseInt(numbers.nextToken()));
        }

        for (int i = 0; i < m; i++) {

            // 첫번째 원소와 두번째 원소 더한 값을 할당 후 다시 우선순위 큐에 넣기
            long first = priorityQueue.remove();
            long second = priorityQueue.remove();

            long sum = first + second;
            priorityQueue.add(sum);
            priorityQueue.add(sum);
        }

        // 합산
        for (int i = 0; i < n; i++) {
            result += priorityQueue.remove();
        }

        System.out.println(result);

    }
}