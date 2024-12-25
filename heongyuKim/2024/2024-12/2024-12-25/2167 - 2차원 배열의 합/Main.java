import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 빈 배열 만들기
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] array = new int[row][col];

        // 배열 값 입력받기
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int e = 0; e < col; e++) {
                array[i][e] = Integer.parseInt(st.nextToken());
            }
        }

        // 합 계산 후 출력
        StringTokenizer rangeStr = new StringTokenizer(br.readLine());
        int range = Integer.parseInt(rangeStr.nextToken());

        int i;
        int j;
        int x;
        int y;

        for (int w = 0; w < range; w++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int result = 0;
            for (int r = i - 1; r <= x - 1; r++) {
                for (int c = j -1; c <= y - 1; c++) {
                    result += array[r][c];
                }
            }
            System.out.println(result);
        }

    }
}
