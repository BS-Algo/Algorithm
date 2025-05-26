import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 입력
        int N = Integer.parseInt(br.readLine());
        int[][] course = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            course[i][0] = Integer.parseInt(st.nextToken());
            course[i][1] = Integer.parseInt(st.nextToken());
        }

        // ----------------------------------
        // 로직

        // 강의를 빨리 시작하는 순으로 정렬
        Arrays.sort(course, Comparator.comparingInt(a -> a[0]));

//        for (int i = 0; i < N; i++) {
//            System.out.println(course[i][0] + " " + course[i][1]);
//        }

        int cnt = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 강의 종료 시간을 빨리 끝나는 순으로 저장
        pq.offer(course[0][1]);
        for (int i = 1; i < N; i++) {
            // 제일 빠른 종료 시간 <= 현재 강의 시작 시간
            if (pq.peek() <= course[i][0]) pq.poll();
            else cnt++; // 강의실 추가

            pq.offer(course[i][1]);
        }

        System.out.println(cnt);
    }
}