import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        // 판에 초기 세팅
        board = new int[count][count];

        // 판에 값넣기
        for (int i = 0; i < count; i++) {
            StringTokenizer nums = new StringTokenizer(br.readLine());
            for (int j = 0; j < count; j++) {
                board[i][j] = Integer.parseInt(nums.nextToken());
            }
        }

        // 재귀로 풀기
        System.out.println(recur(0, 0, count));

    }

    public static int recur(int row, int col, int count) {

        if (count == 2) {
            int[] checkArr1 = new int[4];

            int index = 0;
            for (int i = row; i < row + 2; i++) {
                for (int j = col; j < col + 2; j++) {
                    checkArr1[index] = board[i][j];
                    index++;
                }
            }

            Arrays.sort(checkArr1);
            return checkArr1[2];

        } else {
            count /= 2;

            int[] checkArr2 = new int[4];

            checkArr2[0] = recur(row, col, count);
            checkArr2[1] = recur(row, col + count, count);
            checkArr2[2] = recur(row + count, col, count);
            checkArr2[3] = recur(row + count, col + count, count);

            Arrays.sort(checkArr2);
            return checkArr2[2];
        }
    }


}