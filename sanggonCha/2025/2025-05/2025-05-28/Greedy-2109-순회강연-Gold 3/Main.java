import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] lectures;
    ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        lectures = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken()); // 강연료(fee)
            lectures[i][1] = Integer.parseInt(st.nextToken()); // 기한(deadline)
        }

        Arrays.sort(lectures, (a, b) -> a[1] - b[1]); // deadline 기준 오름차순 정렬

        // 디버깅
//        for (int i = 0; i < N; i++) {
//            System.out.println(lectures[i][0] + " " + lectures[i][1]);
//        }
//        System.out.println();

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 강의료를 저장할 pq
        int lectureIdx = 0;
        while (lectureIdx < N) {
            if (pq.size() < lectures[lectureIdx][1]) { // day 보다 pq가 작다면 그냥 추가
                pq.add(lectures[lectureIdx][0]); // 강의료 추가
            } else if (pq.peek() < lectures[lectureIdx][0]) { // 이 강의가 기존 강의보다 강의료가 크다면
                pq.poll();
                pq.add(lectures[lectureIdx][0]); // 현재 강의로 대체
            }
            lectureIdx++;
        }

        // 출력
        int totalFee = 0;
        for (int fee : pq) {
            totalFee += fee;
        }
        System.out.println(totalFee);
    }
}