import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 추 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        // 추 오름차순 정렬
        Arrays.sort(weights);

        // greedy
        int maxWeight = 1;

        if (weights[0] != 1) { // 1. 첫 번째 추가 1이 아닌 경우
            System.out.println(1); // 1에서 바로 끊어짐
        } else { // 2. 첫 번째 추가 1인 경우
            if (N == 1) { // 2-1. 추가 1개인 경우
                System.out.println(2);
            } else { // 2-2. 추가 여러 개인 경우
                boolean disconnected = false;
                for (int i = 1; i < N; i++) {
                    if (weights[i] <= maxWeight + 1) { // 새로운 추가 기존 최댓값 이하라면
                        maxWeight += weights[i]; // "기존 최댓값 + 새로운 추의 무게" 구간까지 이어짐
                    } else { // 새로운 추가 기존 최댓값보다 크다면
                        maxWeight++; // "기존 최댓값 + 1" = 끊어진 곳
                        disconnected = true;
                        break; // 종료
                    }
                }
                if (!disconnected) { // 끊어지지 않았으면 모든 추를 합한 무게보다 1 큰 곳에서 끊어지는 경우
                    maxWeight++;
                }
                System.out.println(maxWeight);
            }
        }
    }
}