import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 이 코드는 처음에 짰던 코드이고 답은 잘 나오고 아이디어는 다리 큐에 0을 넣는 아이디어는 동일했으나 시간 초과가 났던 코드이다.
// 시간 초과가 났던 이유는 트럭 큐가 비워져 있어도 계속 0을 다리 큐에 추가를 하는 연산과 다리 위에 올리는 조건문이 너무 복잡하여 생겼던 결과다.

// 그래서 수정된 코드에서는 다리 큐에 다리 길이 만큼 0을 넣고 명료하게 하나의 시간동안 다리 큐에 넣고 빼고를 하는 것을 명확하게 표시하기 위해서 먼저 시간을 추가해주고
// 그 다음 다리의 맨 앞의 것을 먼저 제거해주고 트럭이 있으면 넣어주는 식으로 구성하였고 while 반복문의 종료조건은 다리 큐에 아무것도 없을 때 종료하도록 했다.
// 코드를 깔끔하게 짜도록 노력하자!
class ErrorCode {
    // 다리 큐
    static Queue<Integer> bridgeQueue = new LinkedList<>();

    // 트럭 큐
    static Queue<Integer> truckQueue = new LinkedList<>();

    // 결과로 출력할 시간 변수
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 주어진 정보
        StringTokenizer info = new StringTokenizer(br.readLine());

        // 다리를 건너는 트럭의 수
        int truckCount = Integer.parseInt(info.nextToken());

        // 다리의 길이
        int bridgeLength = Integer.parseInt(info.nextToken());

        // 다리의 최대하중
        int maxWeight = Integer.parseInt(info.nextToken());

        // 트럭 큐에 트럭을 넣기
        StringTokenizer truckInfo = new StringTokenizer(br.readLine());

        for (int i = 0; i < truckCount; i++) {
            int truckWeight = Integer.parseInt(truckInfo.nextToken());
            truckQueue.add(truckWeight);
        }

        // 현재 다리의 하중 무게를 측정할 변수
        int currentBridgeWeight = 0;

        while (true) {
            // 다리에 트럭 올리기
            if (bridgeQueue.isEmpty()) {
                if (!truckQueue.isEmpty()) {
                    int truck = truckQueue.poll();
                    bridgeQueue.add(truck);
                    currentBridgeWeight += truck;
                    result++;
                }
            } else {
                // 다리 큐의 사이즈가 다리 길이보다 작을 때
                if (bridgeQueue.size() < bridgeLength) {
                    // 트럭 큐가 비어 있지 않다면
                    if (!truckQueue.isEmpty()) {
                        int peekTruck = truckQueue.peek();
                        // 다음 넣을 것이 최대하중 이하이면 트럭 추가
                        if (currentBridgeWeight + peekTruck <= maxWeight) {
                            bridgeQueue.add(truckQueue.poll());
                            currentBridgeWeight += peekTruck;
                        // 최대하중보다 크면 0을 추가    
                        } else {
                            bridgeQueue.add(0);
                        }
                    // 트럭 큐가 비어 있으면 0을 추가
                    } else {
                        bridgeQueue.add(0);
                    }
                    result++;
                }
            }

            // 종료 조건 - 다리 큐가 비어 있지 않고 다리 하중이 0이면 종료
            if (!bridgeQueue.isEmpty() && currentBridgeWeight == 0) {
                break;
            }

            // 다리에서 트럭 제거하기
            if (bridgeQueue.size() == bridgeLength) {
                int removeTruck = bridgeQueue.poll();
                currentBridgeWeight -= removeTruck;
            }
        }

        System.out.println(result);


    }
}