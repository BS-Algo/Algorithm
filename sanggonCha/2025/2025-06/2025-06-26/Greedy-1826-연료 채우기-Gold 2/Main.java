import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 주유소의 개수

        int[][] gasStations = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            gasStations[i][0] = Integer.parseInt(st.nextToken()); // 거리
            gasStations[i][1] = Integer.parseInt(st.nextToken()); // 주유량
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int distanceToTheVillage = Integer.parseInt(st.nextToken()); // 마을까지의 거리
        int remainingFuel = Integer.parseInt(st.nextToken()); // 남은 연료량

        // 정렬
        Arrays.sort(gasStations, (a, b) -> {
            return a[0] - b[0]; // 거리 오름차순
        });

        // ------------------ 입력 ------------------

        // greedy
        int nowDistance = 0;
        int chargeCount = 0;
        int stationsIndex = 0;
        PriorityQueue<Integer> canCharge =
                new PriorityQueue<>(Collections.reverseOrder()); // 충전량 내림차순 정렬

        while (nowDistance + remainingFuel < distanceToTheVillage) { // 도달할 때까지
            while (stationsIndex < N && gasStations[stationsIndex][0] <= nowDistance + remainingFuel) { // 도달 가능한 거리의
                canCharge.offer(gasStations[stationsIndex][1]); // 충전량 추가
                stationsIndex++;
            }

            if (canCharge.isEmpty()) { // 충전 가능한 주유소가 없다면
                System.out.println(-1); // -1을 출력하고
                return; // 즉시 종료
            }

            int chargeAmount = canCharge.poll();
            nowDistance += chargeAmount;
            chargeCount++;
        }

        // 출력
        System.out.println(chargeCount);
    }
}