import java.io.*;

public class Main {
    public static int[] di = {1, -1, 0, 0};
    public static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // R, C, N 입력 받기
        String[] RCN = br.readLine().split(" ");
        int R = Integer.parseInt(RCN[0]);
        int C = Integer.parseInt(RCN[1]);
        int N = Integer.parseInt(RCN[2]);

        // 격자판 입력 받기
        char[][] charMap = new char[R][C];
        for (int i = 0; i < R; i++) {
            charMap[i] = br.readLine().toCharArray();
        }

        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (charMap[i][j] == '.') map[i][j] = -1;
                else map[i][j] = 3;
            }
        }

        // 다음 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다.
        // 1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발한다.
        // 0(설치) -> 2(설치) -> 3(폭발) -> 4(설치) -> 5(폭발) -> 6(설치) -> 7(폭발)

        // 시물레이션
        if (N != 1) {
            for (int i = 1; i <= N; i++) {
                timePass(map, R, C);
                if (i % 2 == 0) {
                    installation(map, R, C);
                }
                else if (i != 1) {
                    explosion(map, R, C);
                }
            }
        }

        // 출력
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) System.out.print('.');
                else System.out.print('O');
            }
            System.out.println();
        }
    }

    // 폭발
    private static void explosion(int[][] map, int R, int C) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = -1;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + di[k];
                        int nj = j + dj[k];
                        if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] != 0) map[ni][nj] = -1;
                    }
                }
            }
        }
    }

    // 폭탄 설치
    private static void installation(int[][] map, int R, int C) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 3;
                }
            }
        }
    }

    // 폭탄 설치
    private static void timePass(int[][] map, int R, int C) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    map[i][j]--;
                }
            }
        }
    }
}