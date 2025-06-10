import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다른 행성에 바로 가는 것 보다 중간 경유지를 거쳐 가는 것이 더 빠른 경우가 있기 때문에
// 플로이드 - 워셜 알고리즘을 사용해서 최단 거리를 구해야한다.
public class Main {
    static int N; // 행성의 갯수
    static int K; // 발사되는 행성의 위치

    static int[][] arr; // 행성 간 이동시간을 표시할 배열
    static boolean[] check; // 방문 리스트

    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());

        N = Integer.parseInt(info.nextToken());
        K = Integer.parseInt(info.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer times = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(times.nextToken());
            }
        }

        // 플로이드 - 워셜
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        check = new boolean[N];
        check[K] = true;
        dfs(1, K, 0);

        System.out.println(result);
    }

    // 조합
    private static void dfs(int depth, int start, int count) {
        // 가지치기
        if (count > result) {
            return;
        }
        
        // 종료조건
        if (depth == N) {
            result = count;
            return;
        }

        // 로직
        for (int j = 0; j < N; j++) {
            if (!check[j]) {
                check[j] = true;
                dfs(depth + 1, j, count + arr[start][j]);
                check[j] = false;
            }
        }
    }
}