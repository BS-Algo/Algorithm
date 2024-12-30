import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // map 입력 받기
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] mapString = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(mapString[j]);
            }
        }

        navigate(map, N);
    }

    public static void navigate(int[][] map, int N) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int i = current[0];
            int j = current[1];

            // 도착 여부 체크
            if (i == N - 1 && j == N - 1) {
                System.out.println("HaruHaru");
                return;
            }

            // 다음 좌표 추가
            if (map[i][j] != 0 && i + map[i][j] < N) {
                stack.push(new int[]{i + map[i][j], j});
            }

            if (map[i][j] != 0 && j + map[i][j] < N) {
                stack.push(new int[]{i, j + map[i][j]});
            }
        }

        System.out.println("Hing");
    }
}