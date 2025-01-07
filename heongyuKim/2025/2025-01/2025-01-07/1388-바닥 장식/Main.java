import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 행과 열을 받기 위한 StringTokenizer
        StringTokenizer lengths = new StringTokenizer(br.readLine());

        // 행
        int row = Integer.parseInt(lengths.nextToken());

        // 열
        int col = Integer.parseInt(lengths.nextToken());

        // 받을 배열을 생성
        String[] floorDecoration = new String[row];

        // 배열에 값을 넣기
        for (int i = 0; i < row; i++) {
            // 타일 값을 받기
            floorDecoration[i] = br.readLine();
        }

        // 결과에 활용할 변수들
        int rowDecorations = 0;
        int colDecorations = 0;

        // 한줄마다 갯수를 확인할 변수들
        int rowCount = 0;
        int colCount = 0;

        char checkRow = '-';
        char checkCol = '|';
        boolean changeCheck = false;

        // 가로 체크
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (checkRow == floorDecoration[i].charAt(j) && !changeCheck) {
                    changeCheck = true;
                    rowCount++;
                } else if (checkRow != floorDecoration[i].charAt(j) && changeCheck) {
                    changeCheck = false;
                }

                if (j == col - 1) {
                    rowDecorations += rowCount;
                    rowCount = 0;
                    changeCheck = false;
                }

            }
        }

        // 세로 체크
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (checkCol == floorDecoration[j].charAt(i) && !changeCheck) {
                    changeCheck = true;
                    colCount++;
                } else if (checkCol != floorDecoration[j].charAt(i) && changeCheck) {
                    changeCheck = false;
                }

                if (j == row - 1) {
                    colDecorations += colCount;
                    colCount = 0;
                    changeCheck = false;
                }
            }
        }
        System.out.println(rowDecorations + colDecorations);
    }
}
