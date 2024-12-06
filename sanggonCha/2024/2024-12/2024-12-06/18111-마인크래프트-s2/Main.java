import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 크기와 인벤토리 개수 입력
        String[] nmb = br.readLine().split(" ");
        int n = Integer.parseInt(nmb[0]);
        int m = Integer.parseInt(nmb[1]);
        int inventory = Integer.parseInt(nmb[2]);

        // 각 높이의 블록 개수 저장
        int[] countList = new int[257];

        // 최대, 최소 높이 초기화
        int maxHeight = 0;
        int minHeight = 256;

        // 블록 데이터 입력 및 최대/최소 높이 계산
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int height = Integer.parseInt(inputs[j]);
                countList[height]++;
                maxHeight = Math.max(maxHeight, height);
                minHeight = Math.min(minHeight, height);
            }

        }

        int minCost = Integer.MAX_VALUE; // 최소 비용
        int ansHeight = 0; // 결과로 출력할 최적의 높이
        // 블록이 존재하는 구간만을 탐색
        for (int nowHeight = minHeight; nowHeight <= maxHeight; nowHeight++) {
            int remainingInventory = inventory;
            int cost = 0;

            // 모든 높이에 대해 비용 계산
            for (int targetHeight = maxHeight; targetHeight >= minHeight; targetHeight--) {
                // 현재의 비용이 최소비용보다 크다면 고려할 필요 없음(최적화)
                if (cost > minCost) {
                    break;
                }

                // 블록을 쌓아야 하는 경우
                if (nowHeight > targetHeight) {
                    // 인벤토리에 블록이 충분하다면
                    int neededBlocks = (nowHeight - targetHeight) * countList[targetHeight];
                    if (neededBlocks <= remainingInventory) {
                        remainingInventory -= neededBlocks; // 인벤토리 개수 반영(감소)
                        cost += (nowHeight - targetHeight) * countList[targetHeight]; // 1의 시간 만큼 추가
                    }
                    // 블록이 충분하지 않다면 불가능하므로 고려할 필요 없음
                    else {
                        cost = Integer.MAX_VALUE;
                        break;
                    }
                } else {
                    // 블록을 제거해야 하는 경우, 인벤토리에 블록을 추가
                    int removedBlocks = (targetHeight - nowHeight) * countList[targetHeight];
                    remainingInventory += removedBlocks; // 인벤토리 개수 반영(증가)
                    cost += removedBlocks * 2; // 블록을 제거하는 데는 2의 시간 만큼 추가
                }
            }
            
            // 같은 비용일 때 더 높은 높이를 고려해야 하므로 "같거나" 작을 때를 고려
            if (cost <= minCost) {
                minCost = cost;
                ansHeight = nowHeight;
            }
        }

        // 정답 출력
        System.out.printf("%d %d", minCost, ansHeight);
    }
}