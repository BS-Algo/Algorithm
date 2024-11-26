import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split(" ");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0'; // ASCII 변환
            }
        }

        int maxSize = 1; // 가장 큰 정사각형의 크기

        // 각 좌표 (i, j)에서 가능한 정사각형 크기 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 1; i + k < n && j + k < m; k++) { // 정사각형의 한 변의 길이
                    if (arr[i][j] == arr[i][j + k] && arr[i][j] == arr[i + k][j]
                            && arr[i][j] == arr[i + k][j + k]) {
                        maxSize = Math.max(maxSize, (k + 1) * (k + 1));
                    }
                }
            }
        }

        System.out.println(maxSize);
    }
}
