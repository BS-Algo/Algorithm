import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // R C 입력 받기
        String[] RC = br.readLine().split(" ");

        // 정수 변환
        int R = Integer.parseInt(RC[0]);
        int C = Integer.parseInt(RC[1]);

        // 맵 배열 생성
        char[][] map = new char[R][C];

        // 맵 입력 받기
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 탐색 변수 생성
        int[] di = {1, -1, 0, 0};
        int[] dj = {0, 0, 1, -1};

        int submergedCnt = 0;
        int[] submergedI = new int[100];
        int[] submergedJ = new int[100];

        // 탐색
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 땅(X)일 경우 탐색
                if (map[i][j] == 'X') {
                    int cnt = 0; // 인접한 바다의 개수를 저장할 변수
                    for (int k = 0; k < 4; k++) {
                        int ni = i + di[k];
                        int nj = j + dj[k];

                        // 지도의 범위를 벗어나지 않고, 바다라면
                        if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
                            if (map[ni][nj] == '.') {
                                cnt++; // 인접한 것이 바다면 cnt 변수 ++
                            }
                        } else { // 지도의 범위를 벗어나면 모두 바다
                            cnt++;
                        }
                        if (cnt >= 3) { // 인접한 바다가 세 칸 이상이라면
//                        map[i][j] = '.'; // 바다에 잠긴다
                            submergedI[submergedCnt] = i;
                            submergedJ[submergedCnt] = j;
                            submergedCnt++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < submergedCnt; i++) {
            map[submergedI[i]][submergedJ[i]] = '.';
        }

        int maxI = 0, minI = R - 1, maxJ = 0, minJ = C - 1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') {
                    maxI = Math.max(maxI, i);
                    minI = Math.min(minI, i);
                    maxJ = Math.max(maxJ, j);
                    minJ = Math.min(minJ, j);
                }
            }
        }

        for (int i = minI; i <= maxI; i++) {
            for (int j = minJ; j <= maxJ; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}