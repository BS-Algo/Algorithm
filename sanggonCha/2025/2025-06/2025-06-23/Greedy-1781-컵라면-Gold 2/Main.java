import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 숙제 입력
        int[][] problems = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            problems[i][0] = Integer.parseInt(st.nextToken()); // 데드라인
            problems[i][1] = Integer.parseInt(st.nextToken()); // 컵라면 수
        }

        // 정렬
        Arrays.sort(problems, (a,b) -> { // 데드라인 오름차순 정렬
            return a[0] - b[0];
        });

        // Greedy
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int problemIndex = 0; problemIndex < problems.length; problemIndex++) {
            // 데드라인 만큼의 숙제를 고려
            if(pq.size() < problems[problemIndex][0]) { // 고려중인 숙제의 개수가 더 적다면
                pq.offer(problems[problemIndex][1]); // 일단 컵라면 추가
            } else if(pq.peek() < problems[problemIndex][1]) { // 현재 컵라면이 더 많다면
                pq.poll(); // 기존 컵라면 제거
                pq.offer(problems[problemIndex][1]);
            }
        }

        // 출력
        int cupNoodleSum = 0;
        for (Integer cupNoodle : pq) {
            cupNoodleSum += cupNoodle;
        }
        System.out.println(cupNoodleSum);
    }
}