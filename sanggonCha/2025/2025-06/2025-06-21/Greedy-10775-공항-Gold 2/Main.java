import java.io.*;
import java.util.*;

public class Main {
    private static int[] gates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine()); // 게이트 수 입력

        // 게이트 생성 및 초기화
        gates = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            gates[i] = i;
        }

        int P = Integer.parseInt(br.readLine()); // 비행기 수 입력

        int dockingCount = 0;
        while (P-- > 0) {
            int plane = Integer.parseInt(br.readLine()); // 비행기 입력

            int availableGate = find(plane);

            if (availableGate != 0) { // 0번을 가리키지 않으면, 게이트를 할당 가능한 상태
                dockingCount++;

                // greedy하게 높은 번호 게이트부터 차례로 할당
                // availableGate은 사용했으므로 사용 가능한 gate를 바로 전으로 수정
                gates[availableGate] = availableGate - 1;
//                System.out.println("plane = " + plane + "availableGate = " + availableGate);
            } else {
                System.out.println(dockingCount); // 현재까지 도킹한 게이트 수 출력
                return;
            }
        }

        // 모든 게이트를 할당했을 경우
        System.out.println(dockingCount);
    }

    /**
     * 유니온-파인드 함수
     **/
    private static int find(int plane) {
        if (gates[plane] != plane) { // 현재 자기 번호의 게이트 할당이 불가능하다면
            gates[plane] = find(gates[plane]); // 가능한 번호를 추가 탐색(번호가 감소하는 방향으로)
        }
        return gates[plane];
    }
}