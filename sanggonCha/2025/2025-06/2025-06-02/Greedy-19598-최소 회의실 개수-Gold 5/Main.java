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
            course[i][0] = Integer.parseInt(st.nextToken());
            course[i][1] = Integer.parseInt(st.nextToken());
        }

        // ----------------------------------
        // 로직

        // 정렬 - 시작 시간 오름차순, 종료 시간 오름차순
        Arrays.sort(course, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        // 정렬 디버깅
//        for (int i = 0; i < N; i++) {
//            System.out.println(course[i][0] + " " + course[i][1]);
//        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 현재 진행되는 강의 중 가장 빨리 끝나는 시간
        pq.offer(course[0][1]); // 첫 강의 넣기


        for (int i = 1; i < N; i++) {
            // 새로운 강의가, 기존 강의 끝나는 시간이나 이후에 시작한다면
            // -> 강의실 재사용 가능
            if (course[i][0] >= pq.peek()) {
                pq.poll(); // 가장 빠른 강의 제거 후
            }
                pq.offer(course[i][1]); // 새로운 강의 추가
        }

        // 출력
        System.out.println(pq.size());
    }
}