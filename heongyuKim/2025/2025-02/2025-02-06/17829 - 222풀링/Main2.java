import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

        while (true) {
            int check = count / 2;

            // 줄어든 판
            int[][] newBoard = new int[check][check];

            // 두번째로 작은 수 저장
            ArrayList<Integer> store = new ArrayList<>();

            for (int i = 0; i < count; i += 2) {
                for (int j = 0; j < count; j += 2) {
                    int[] checkBoard = new int[4];
                    int sequence = 0;
                    for (int e = 0; e < 2; e++) {
                        for (int w = 0; w < 2; w++) {
                            checkBoard[sequence] = board[i + e][j + w];
                            sequence++;
                        }
                    }
                    Arrays.sort(checkBoard);
                    store.add(checkBoard[2]);
                }
            }

            int index = 0;
            for (int i = 0; i < check; i++) {
                for (int j = 0; j < check; j++) {
                    newBoard[i][j] = store.get(index);
                    index++;
                }
            }

            if (check > 1) {
                count = check;
                board = newBoard;
            } else {
                System.out.println(newBoard[0][0]);
                break;
            }
        }


    }
}