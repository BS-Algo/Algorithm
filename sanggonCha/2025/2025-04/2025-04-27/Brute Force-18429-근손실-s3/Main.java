import java.io.*;
import java.util.*;

public class Main {
    static int N, K, ans = 0;
    static boolean[] visited;
    static List<Integer> exerciseKit = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, K 입력 받기
        N = Integer.parseInt(st.nextToken()); // 일수
        K = Integer.parseInt(st.nextToken()); // 손실 중량

        // 운동 키트 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            exerciseKit.add(Integer.parseInt(st.nextToken()));
        }

        // 브루트포스
        visited = new boolean[N];
        int weight = 500, day = 0;
        exercise(weight, day);

        // 출력
        System.out.println(ans);
    }

    private static void exercise(int weight, int day) {
        if (day == N) {
            ans++;
            return;
        }

        for (int kitNum = 0; kitNum < N; kitNum++) {
            if (!visited[kitNum]) {

                // 증량 및 손실
                int plus = exerciseKit.get(kitNum);
                int nextWeight = weight + (plus - K);

                // 손실 조건
                if (nextWeight < 500) {
                    continue;
                }
                

                // 다음 운동
                visited[kitNum] = true;
                exercise(nextWeight, day + 1);

                // 복구
                visited[kitNum] = false;
            }
        }
    }
}