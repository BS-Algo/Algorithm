// https://github.com/BS-Algo/Algorithm
// https://velog.io/@yg9618/greedy-Baekjoon-11000번-강의실-배정하기-Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[][] lectures = new int[N][2];

        // N개의 강의 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        // 강의를 시간시간 기준으로 정렬
        Arrays.sort(lectures, Comparator.comparingInt(a -> a[0]));

        // 진행중인 강의의 종료 시간을 관리할 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0][1]); // 제일 빨리 시작하는 강의의 종료 시간을 추가

        // 두 번째 강의부터 살펴보기
        for (int i = 1; i < N; i++) {
            int start = lectures[i][0];
            int end = lectures[i][1];

            // 제일 빨리 종료되는 강의 종료 시간 < 현재 강의 시작 시간
            if(pq.peek() <= start) {
                pq.poll(); // 강의실 재사용
            }

            // 제일 빨리 종료되는 강의실을 사용할 수 없다면, 강의실을 새로 배정한 경우
            // 사용할 수 있었다면, 기존의 강의실을 재사용하는 경우
            pq.offer(end);
        }

        System.out.println(pq.size());
    }
}