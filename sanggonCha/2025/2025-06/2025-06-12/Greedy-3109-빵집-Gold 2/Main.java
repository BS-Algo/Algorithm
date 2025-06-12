import java.io.*;
import java.util.*;

public class Main {
    private static int R, C, ans = 0;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 맵 입력
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 모든 행에서 출발
        for (int r = 0; r < R; r++) {
            greedyDfs(r, 0);
        }

        // 출력
        System.out.println(ans);
    }

    private static boolean greedyDfs(int r, int c) {
        map[r][c] = 'p'; // 중복 탐색 방지를 위해 경로 표시(한 번 가본 경로는 더 이상 갈 필요 없으므로 복구 X)

        if (c == C - 1) { // 종료 조건(가장 먼저 끝 열에 도달하면 종료)
            ans++;
            return true;
        }


        // 경로 찾기
        for (int dr = -1; dr <= 1; dr++) {
            // 다음 좌표 생성
            int nr = r + dr;
            int nc = c + 1;
            if (nr >= 0 && nr < R && map[nr][nc] == '.' && greedyDfs(nr, nc)) {
                return true;
            }
        }
        return false;
    }
}