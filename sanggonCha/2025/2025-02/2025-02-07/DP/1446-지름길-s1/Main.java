import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());


        // 지름길 입력
        int[][] shortCut = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            shortCut[i][0] = Integer.parseInt(st.nextToken());
            shortCut[i][1] = Integer.parseInt(st.nextToken());
            shortCut[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(shortCut, Comparator.comparingInt(a -> a[0]));

        // 기본 거리 입력
        int[] expressWay = new int[D + 1];
        for (int i = 1; i < D + 1; i++) {
            expressWay[i] = i;
        }

        // 지름길 고려
        for (int i = 0; i < N; i++) {
            if (shortCut[i][1] <= D) { // 고속도로 길이보다 긴 도착지는 무시
                int start = shortCut[i][0];
                int end = shortCut[i][1];
                int length = shortCut[i][2];

                expressWay[end] = Math.min(expressWay[start] + length, expressWay[end]); // 지름길을 고려해서 더 빠른 길을 선택
                for (int j = end; j < D; j++) { // 지름길이 반영된 새로운 길이 계산
                    expressWay[j + 1] = Math.min(expressWay[j] + 1, expressWay[j + 1]);
                }
            }
        }

        System.out.println(expressWay[D]);
    }
}