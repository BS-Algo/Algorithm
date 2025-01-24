import java.io.*;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static int size, N, K, S, X, Y, i, j, ni, nj;
    private static int[][] testTube;
    private static final int[][] dij = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static Queue<int[]> coordinates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, K 입력 받기
        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]); // NxN 크기의 시험관
        K = Integer.parseInt(NK[1]); // 바이러스의 번호는 K이하의 자연수

        // 시험관 입력 받기
        testTube = new int[N][N];
        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < N; j++) {
                testTube[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // S, X, Y 입력 받기
        String[] SXY = br.readLine().split(" ");
        S = Integer.parseInt(SXY[0]);
        X = Integer.parseInt(SXY[1]);
        Y = Integer.parseInt(SXY[2]);

        if (testTube[X-1][Y-1] > 0) {
            System.out.println(testTube[X-1][Y-1]);
            return;
        }

        // 실행
        ArrayList<Integer> result = new ArrayList<>();
        coordinates = new LinkedList<>();
        coordinates.offer(new int[]{X - 1, Y - 1}); // 관심 대상 좌표에서 역으로 출발
        testTube[X - 1][Y - 1] = -1;

        while (S-- > 0) { // S초 실행
            size = coordinates.size();
            while (size-- > 0) { // while문이 모두 실행될 때마다 1초
                int[] now = coordinates.poll();
                for (int[] d : dij) {
                    ni = now[0] + d[0];
                    nj = now[1] + d[1];
                    if (indexCheck(ni, nj)) {
                        if (testTube[ni][nj] == 0) { // 아직 감염되지 않았다면
                            testTube[ni][nj] = -1; // 지나온 것을 기록
                            coordinates.offer(new int[]{ni, nj}); // 추가
                        } else if (testTube[ni][nj] > 0) { // 바이러스가 존재한다면 -> 해당 위치에서 출발한 바이러스가 목표 지점을 감염 시킬 수 있다는 것
                            result.add(testTube[ni][nj]); // 바이러스 번호를 추가
                        }
                    }

                }
            }

            // 1초가 지날 때 마다 조기 종료 체크
            if (result.size() > 0) {
                int min = 1001; // 바이러스는 1 ~ 1000번
                for (int a : result) {
                    min = Math.min(a, min);
                }
                System.out.println(min);
                return;
            }
        }

        // 전염디지 않았으면 0을 출력
        System.out.println(0);
    }

    private static boolean indexCheck(int ni, int nj) {
        return 0 <= ni && ni < N && 0 <= nj && nj < N;
    }
}