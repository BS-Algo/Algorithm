import java.io.*;
import java.util.*;

public class Main {
    static boolean isMeetTeacher;
    static int N;
    static int[] di = {0, 0, 1, -1}, dj = {1, -1, 0, 0};
    static String[][] map;
    static List<int[]> nothing = new ArrayList<>(), students = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, K 입력 받기
        N = Integer.parseInt(br.readLine());

        // X를 저장할 어레이 리스트

        // 복도 정보 입력 받기
        StringTokenizer st;
        map = new String[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String temp = st.nextToken();
                map[i][j] = temp;
                if (temp.equals("X")) {
                    nothing.add(new int[]{i, j});
                } else if (temp.equals("S")) {
                    students.add(new int[]{i, j});
                }
            }
        }

        // 브루트포스
        bruteForce();

    }

    private static boolean bfs() {
        for (int[] student : students) {
            int i = student[0];
            int j = student[1];

            for (int d = 0; d < 4; d++) {
                int ni = i;
                int nj = j;

                while (true) {
                    ni += di[d];
                    nj += dj[d];

                    if (ni < 0 || nj < 0 || ni >= N || nj >= N) break;

                    // 학생을 만나면 계속 탐색
                    if (map[ni][nj].equals("O")) break; // 장애물을 만나면 종료
                    if (map[ni][nj].equals("T")) return false; // 선생님을 만나면 false 반환
                }
            }

        }
        return true; // 선생님을 만나지 않았으면 true 반환
    }

    private static void bruteForce() {
        // 완전 탐색(브루트포스)
        int size = nothing.size();
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    isMeetTeacher = false;

                    int[] ij1 = nothing.get(i);
                    int[] ij2 = nothing.get(j);
                    int[] ij3 = nothing.get(k);
                    map[ij1[0]][ij1[1]] = "O";
                    map[ij2[0]][ij2[1]] = "O";
                    map[ij3[0]][ij3[1]] = "O";

                    if (bfs()) {
                        System.out.println("YES");
                        return;
                    }

                    map[ij1[0]][ij1[1]] = "X";
                    map[ij2[0]][ij2[1]] = "X";
                    map[ij3[0]][ij3[1]] = "X";
                }
            }
        }
        System.out.println("NO");
    }
}