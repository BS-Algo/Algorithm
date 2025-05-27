import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static String[][] school;
    static boolean[][] visited;

    static ArrayList<int[]> teacherPoint = new ArrayList<>();

    static boolean result = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        school = new String[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String person = line.nextToken();

                school[i][j] = person;
                if (person.equals("T")) {
                    teacherPoint.add(new int[] {i, j});
                    visited[i][j] = true;
                }

                if (person.equals("S")) {
                    visited[i][j] = true;
                }
            }
        }

        dfs(0);

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    // 3개의 장애물을 설치하는 메서드
    private static void dfs(int depth) {
        if (depth == 3) {
            // 탐색 메서드
            boolean isWatch = search();
            if (isWatch) {
                result = true;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && school[i][j].equals("X")) {
                    school[i][j] = "O";
                    visited[i][j] = true;
                    dfs(depth + 1);
                    school[i][j] = "X";
                    visited[i][j] = false;
                }
            }
        }
    }

    // 선생님과 학생이 마주치는지 탐색하는 메서드 - 상하좌우
    private static boolean search() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int[] teacher : teacherPoint) {
            int x = teacher[0];
            int y = teacher[1];

            for (int d = 0; d < 4; d++) {
                int nx = x;
                int ny = y;

                while (true) {
                    nx += dx[d];
                    ny += dy[d];

                    // 범위 벗어나면 중단
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;

                    // 장애물 만나면 해당 방향 탐색 중단
                    if (school[nx][ny].equals("O")) break;

                    // 학생을 발견하면 실패이므로 바로 false 반환
                    if (school[nx][ny].equals("S")) {
                        return false;
                    }
                }
            }

        }
        return true;
    }
}