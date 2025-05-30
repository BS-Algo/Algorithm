import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine()); // 원생의 수

        // 꽃 입력
        int[][] flowers = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            flowers[i][0] = sm * 100 + sd;
            flowers[i][1] = em * 100 + ed;
        }

        // 정렬
        Arrays.sort(flowers, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // 종료일 내림차순
            }
            return a[0] - b[0]; // 시작일 오름차순
        });

        // 정렬 디버깅
//        for (int i = 0; i < N; i++) {
//            System.out.println(flowers[i][0] + " " + flowers[i][1]);
//        }

        // 시작 날짜 설정
        int start = 301;
        int endTarget = 1201; // 12월 1일부터 꽃이 지면 종료 가능
        int cnt = 0;
        int maxEnd = 0;
        int index = 0;

        while (start < endTarget) { // 11월 30일 이후에 꽃이 져야함 -> 1130 포함 X
            boolean found = false;

            // 현재 커버된 날짜 다음을 커버할 수 있는 꽃들 중 가장 멀리까지 커버하는 꽃
            // 5월 30일에 꽃이 지면, 5월 30일부터 피는 꽃이 있어야함
            for (int i = index; i < N; i++) {
                if (flowers[i][0] > start) { // 시작일은 오름차순 - 시작일이 필요한 날짜보다 늦는다면 불가능 - 바로 종료
                    break;
                }

                if (flowers[i][1] > maxEnd) { // 시작일 조건을 만족하면서, 더 오래 핀다면
                    maxEnd = flowers[i][1]; // 갱신
                    index = i + 1;
                    found = true;
                }
            }

            if (found) {
                start = maxEnd; // 다음에 시작해야할 날짜 갱신
                cnt++;
            } else {
                break; // 중간에 끊키는 경우
            }
        }

        // 출력
        if( maxEnd < endTarget) System.out.println(0);
        else System.out.println(cnt);
    }
}