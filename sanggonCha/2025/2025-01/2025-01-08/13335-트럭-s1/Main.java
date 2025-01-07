import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nwL = br.readLine().split(" ");
        int n = Integer.parseInt(nwL[0]); // n은 다리를 건너는 트럭의 수
        int w = Integer.parseInt(nwL[1]); // w는 다리의 길이,
        int L = Integer.parseInt(nwL[2]); // L은 다리의 최대하중

        //  ai는 i번째 트럭의 무게
//        String[] an = br.readLine().split(" ");
//        int[] trucks = new int[n];
//        for (int i = 0; i < n; i++) {
//            trucks[i] = Integer.parseInt(an[i]);
//        }
        int[] trucks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] bridge = new int[w]; // 다리 상태를 저장할 배열
        int bridgeWeight = 0; // 다리 위의 총 무게
        int time = 0; // 시간
        int index = 0; // 트럭 인덱스

        // 모든 트럭이 다리를 지나가서, 다리 위의 트럭의 무게가 0이 될 때까지
        while (index < n || bridgeWeight > 0) {
            time++; // 시간은 계속 증가

            // 첫 번째 트럭이 빠져나간 만큼 다리의 무게 감소
            bridgeWeight -= bridge[0];

            // 트럭은 1만큼 이동
            for (int i = 0; i < w - 1; i++) {
                bridge[i] = bridge[i + 1];
            }

            // 새로운 트럭이 올라올 수 있는지 체크
            // index < n이 필요한 이유: 마지막 트럭이 올라가 있을 때도 시간을 카운트 해야함
            if (index < n && bridgeWeight + trucks[index] <= L) {
                bridgeWeight += trucks[index]; // 다리의 하중 반영
                bridge[w - 1] = trucks[index]; // 다리의 시작 부분에 트럭을 기록
                index++;
            } else {
                bridge[w - 1] = 0; // 새로운 트럭이 없으므로 비우기
            }
        }

        System.out.println(time);
    }
}