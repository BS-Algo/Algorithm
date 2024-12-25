import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 배열 크기 입력
        String[] dimensions = br.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        
        // 2차원 배열 입력
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] rowValues = br.readLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(rowValues[j]);
            }
        }
        
        // 쿼리 개수 입력
        int queryCount = Integer.parseInt(br.readLine());
        
        // 쿼리 처리
        for (int q = 0; q < queryCount; q++) {
            String[] rangeQuery = br.readLine().split(" ");
            int startRow = Integer.parseInt(rangeQuery[0]) - 1;
            int startCol = Integer.parseInt(rangeQuery[1]) - 1;
            int endRow = Integer.parseInt(rangeQuery[2]) - 1;
            int endCol = Integer.parseInt(rangeQuery[3]) - 1;

            // 구간 합 계산
            int sum = 0;
            for (int i = startRow; i <= endRow; i++) {
                for (int j = startCol; j <= endCol; j++) {
                    sum += matrix[i][j];
                }
            }
            System.out.println(sum);
        }
    }
}
