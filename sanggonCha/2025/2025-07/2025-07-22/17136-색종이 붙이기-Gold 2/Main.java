import java.io.*;
import java.util.*;

public class Main {
    private static int[] leftPaper = {0, 5, 5, 5, 5, 5};
    private static int[][] arr = new int[10][10];
    private static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 최소 횟수 구하기
        findMinCount(0, 0, 0);

        // 3. 출력
        if (minCount == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCount);
        }
    }
    
    // 복구
    private static void unCover(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                arr[i][j] = 1;
            }
        }
    }

    // 색종이 덮기
    private static void cover(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                arr[i][j] = 0;
            }
        }
    }

    private static boolean isCanCover(int row, int col, int size) {
        // 인덱스 범위 체크
        if (row + size > 10 || col + size > 10) {
            return false;
        }

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void findMinCount(int row, int col, int count) {
        // 1-1. 기저 조건 1
        if (col == 10) {
            col = 0;
            row++; // 다음 줄 진행
        }

        // 1-2. 기저 조건 2
        if (row == 10) {
            // 모두 0으로 구성돼 있는지 check 하지 않아도 됨
            // 0을 만난 경우에는 계속 재귀호출이 됨
            // 1을 만난 경우에는 size 별로 덮을 수 있을 때만 재귀호출이 됨
            
            // 따라서 재귀호출을 통해서 기저조건에 도달한 것이라면
            // 0만 만났거나,
            // 1을 만나서 지우면서 도달한 경우
            
            // 그렇기 때문에 이 if 문에 들어온 순간 이미 배열은 0으로만 이루어진 상태
            minCount = Math.min(minCount, count);
            return;
        }

        // 2. 현재 위치가 0이면 다음 칸으로 이동
        if (arr[row][col] == 0) {
            findMinCount(row, col + 1, count);
            return;
        }

        // 3. (현재 위치가 1이면) 모든 색종이에 대해서 재귀 호출
        for (int size = 5; size >= 1; size--) { // 큰 사이즈부터 보는 게 유리함
            // 백트래킹
            if (count + 1 < minCount && leftPaper[size] > 0 && isCanCover(row, col, size)) { // 현재 size로 덮을 수 있다면
                leftPaper[size]--;
                cover(row, col, size);

                // 재귀 호출
                findMinCount(row, col + 1, count + 1);

                // 복구
                leftPaper[size]++;
                unCover(row, col, size);
            }
        }
    }
}