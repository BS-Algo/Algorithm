import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int[][] sudoku = new int[9][9];
    static ArrayList<int[]> points = new ArrayList<>();

    static StringBuilder answer = new StringBuilder();
    static boolean isSolved = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String nums = br.readLine();
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(String.valueOf(nums.charAt(j)));
                sudoku[i][j] = num;

                if (num == 0) {
                    points.add(new int[] {i, j});
                }
            }
        }

        dfs(0);

        System.out.println(answer.toString());
    }


    private static void dfs(int depth) {
        boolean[] check = new boolean[10];

        if (depth == points.size()) {
            isSolved = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    answer.append(sudoku[i][j]);
                }
                answer.append("\n");
            }

            return;
        }

        int[] point = points.get(depth);
        int x = point[0];
        int y = point[1];


        // 가로, 세로
        for (int i = 0; i < 9; i++) {
            check[sudoku[i][y]] = true;
            check[sudoku[x][i]] = true;
        }

        // 3 * 3
        for (int i = (x / 3) * 3; i < ((x / 3) * 3) + 3; i++) {
            for (int j = (y / 3) * 3; j < ((y / 3) * 3) + 3; j++) {
                check[sudoku[i][j]] = true;
            }
        }

        for (int i = 1; i < 10; i++) {
            if (!check[i]) {
                sudoku[x][y] = i;
                dfs(depth + 1);
                if (isSolved) return;
                sudoku[x][y] = 0;
            }
        }
    }
}