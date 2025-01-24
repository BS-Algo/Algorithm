import java.io.*;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static int virus, N, K, S, X, Y, i, j, ni, nj;
    private static int[] di = {1, -1, 0, 0};
    private static int[] dj = {0, 0, 1, -1};
    private static int[] coordinates;
    private static int[][] testTube;
    private static Queue<int[]> virusCoordinates, tempVirueCoordinates; // 메모리 효율성을 위해 클래스 생성없이 배열 자료형 사용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, K 입력 받기
        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]); // NxN 크기의 시험관
        K = Integer.parseInt(NK[1]); // 바이러스의 번호는 K이하의 자연수

        // 시험관 입력 받기
        // 좌표를 저장할 Queue(처음에는 바이러스의 우선순위대로 실행해야하므로 우선순위 Queue를 사용)
        virusCoordinates = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // a와 b는 좌표 (i, j) 형태
                // testTube[a[0]][a[1]]와 testTube[b[0]][b[1]]를 비교하여 우선순위 결정
                return Integer.compare(testTube[a[0]][a[1]], testTube[b[0]][b[1]]);
            }
        });
        testTube = new int[N][N];
        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < N; j++) {
                virus = Integer.parseInt(st.nextToken());
                testTube[i][j] = virus;
                if (virus > 0) {
                    virusCoordinates.offer(new int[]{i, j});
                }
            }
        }

        // S, X, Y 입력 받기
        String[] SXY = br.readLine().split(" ");
        S = Integer.parseInt(SXY[0]);
        X = Integer.parseInt(SXY[1]);
        Y = Integer.parseInt(SXY[2]);

        // S초 실행
        tempVirueCoordinates = new LinkedList<>(); // 1초 동안의 실행을 위해 임시 저장용 Queue
        while (S > 0) {
            while (!virusCoordinates.isEmpty()) {
                coordinates = virusCoordinates.poll();
                i = coordinates[0];
                j = coordinates[1];
                for (int k = 0; k < 4; k++) {
                    ni = i + di[k];
                    nj = j + dj[k];
                    if (indexCheck(ni, nj) && testTube[ni][nj] == 0) {
                        testTube[ni][nj] = testTube[i][j]; // 전염
                        tempVirueCoordinates.offer(new int[]{ni, nj}); // 추가
                    }
                }
            }
            // 첫 실행 이후부터는 우선순위 Queue 사용하지 않아도 된다.
            // 처음에 우선순위를 사용해서 바이러스를 전염시켰으므로
            // 이후부터는 순서대로 꺼내기만 해도 우선순위대로 꺼내진다.
            // 우선순위 큐는 O(logN) > 링크드리스트는 O(1)
            // 따라서 시간복잡도가 높은 우선순위 큐를 굳이 계속 사용할 이유가 없다
            virusCoordinates = new LinkedList<>();
            while (!tempVirueCoordinates.isEmpty()) {
                virusCoordinates.offer(tempVirueCoordinates.poll());
            }
            S--;
        }

        System.out.println(testTube[X - 1][Y - 1]);

    }

    private static boolean indexCheck(int ni, int nj) {
        return 0 <= ni && ni < N && 0 <= nj && nj < N;
    }
}