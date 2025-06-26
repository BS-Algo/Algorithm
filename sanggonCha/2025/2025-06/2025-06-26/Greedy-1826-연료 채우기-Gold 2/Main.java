import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 주유소 입력
        int[][] gasStations = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            gasStations[i][0] = Integer.parseInt(st.nextToken()); // 거리
            gasStations[i][1] = Integer.parseInt(st.nextToken()); // 연료
        }

        // 문제의 함정: 항상 거리순으로 주어지는 것이 아님.. -> 정렬 필요
        Arrays.sort(gasStations, (a, b) -> a[0] - b[0]); // 거리 오름차순 정렬

        // 도착지 거리와 현재 연료 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int destinationDistance = Integer.parseInt(st.nextToken()); // 도착지 거리
        int currentFuel = Integer.parseInt(st.nextToken()); // 현재 연료

        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder()); // 주유 가능한 주유량을 저장(내림차순)
        int rechableDistance = currentFuel; // 도달 가능 거리
        int stationIndex = 0; // 주유소 배열 접근 변수
        int refuelCount = 0; // 주유 횟수

        // greedy
        while (rechableDistance < destinationDistance) { // 모든 주유소를 살펴볼 때까지 실행
            // 현재 도달 가능한 거리의 모든 주유소의 주유량을 available에 추가
            while (stationIndex < N && gasStations[stationIndex][0] <= rechableDistance) {
                available.offer(gasStations[stationIndex][1]); // 주유량을 추가
                stationIndex++;
            }

            // 가능한 주유량이 있다면
            if (!available.isEmpty()) {
                rechableDistance += available.poll(); // 가장 큰 주유랑을 주유
                refuelCount++; // 주유 횟수 카운트
            } else { // 더 이상 주유 가능한 주유소가 없다면(더 이상 도달이 불가)
                System.out.println(-1); // -1 출력
                return; // 바로 종료
            }
        }

        // 출력
        System.out.println(refuelCount);
    }
}