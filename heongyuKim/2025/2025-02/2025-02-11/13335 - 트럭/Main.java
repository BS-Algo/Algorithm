import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
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
        
        
        // 다리 길이만큼 0을 채워 넣기
        for (int i = 0; i < bridgeLength; i++) {
            bridgeQueue.add(0);
        }

        while (!bridgeQueue.isEmpty()) {
            // 시간 추가
            result++;
            
            // 다리의 맨 앞의 것을 제거하기
            currentBridgeWeight -= bridgeQueue.poll();

            // 만약 트럭 큐가 비어있지 않다면
            if (!truckQueue.isEmpty()) {
                // 다음 트럭이 최대하중을 넘지 않으면 추가
                if (currentBridgeWeight + truckQueue.peek() <= maxWeight) {
                    currentBridgeWeight += truckQueue.peek();
                    bridgeQueue.add(truckQueue.poll());
                } else {
                    // 최대 하중을 넘으면 0을 추가
                    bridgeQueue.add(0);
                }
            }
        }

        System.out.println(result);


    }
}