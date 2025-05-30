import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


// 아까브라...
// dfs 탐색 로직은 잘 짰으나 가지치기 조건이 잘 생각이 안나서 해맸던 문제...
// 스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다. 이 문장에서 가지치기 조건을 얻었어야 했다....
public class Main {
    static int[][] sudoku = new int[9][9];

    static ArrayList<int[]> index = new ArrayList<>();
    static StringBuilder result = new StringBuilder();

    static boolean solved = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer nums = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(nums.nextToken());
                sudoku[i][j] = num;

                if (num == 0) {
                    index.add(new int[] {i, j});
                }
            }
        }

        dfs(0);

        System.out.println(result.toString());
    }


    private static void dfs(int depth) {
        boolean[] check = new boolean[10];

        if (depth == index.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    result.append(sudoku[i][j]).append(" ");
                }
                result.append("\n");
            }
            solved = true;
            return;
        }

        int[] point = index.get(depth);
        int x = point[0];
        int y = point[1];

        // 가로
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] != 0) {
                check[sudoku[x][i]] = true;
            }
        }

        // 세로
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][y] != 0) {
                check[sudoku[i][y]] = true;
            }
        }

        // 3 * 3
        for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
            for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
                if (sudoku[i][j] != 0) {
                    check[sudoku[i][j]] = true;
                }
            }
        }

        // 탐색하고나서 되는 수를 할당하고 넘어가기
        for (int i = 1; i < 10; i++) {
            if (!check[i]) {
                sudoku[x][y] = i;
                dfs(depth + 1);
                // 가지치기 조건
                if (solved) return;
                sudoku[x][y] = 0;
            }
        }
    }
}