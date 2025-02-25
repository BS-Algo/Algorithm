import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main2 {

    // 주어진 수를 담을 배열
    static int[][] arr;
    
    // 구간 합을 구할 배열
    static int[][] prefixArr;

    // 결과로 나타낼 것들을 출력할 StringBuilder
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N과 M의 정보
        StringTokenizer info = new StringTokenizer(br.readLine());

        // N
        int N = Integer.parseInt(info.nextToken());

        // M
        int M = Integer.parseInt(info.nextToken());

        // 숫자를 받을 배열 생성
        arr = new int[N + 1][N + 1];
        
        // 누적합을 넣을 배열 생성
        prefixArr = new int[N + 1][N + 1];
        
        // 배열에 숫자 넣기
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer nums = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                arr[i][j] = Integer.parseInt(nums.nextToken());
            }
        }

        // 누적합 첫행과 첫열에 누적합 기입
        for (int i = 1; i < N + 1; i++) {
            // 행
            prefixArr[1][i] = prefixArr[1][i - 1] + arr[1][i];
            // 열
            prefixArr[i][1] = prefixArr[i - 1][1] + arr[i][1];
        }


        // 누적합 배열의 첫행과 첫열을 바탕으로 누적합 배열에 숫자 계산 후 기입
        for (int i = 2; i < N + 1; i++) {
            for (int j = 2; j < N + 1; j++) {
                prefixArr[i][j] = arr[i][j] + prefixArr[i][j - 1] + prefixArr[i - 1][j] - prefixArr[i - 1][j - 1];
            }
        }

        // 구간합 계산
        for (int i = 0; i < M; i++) {

            StringTokenizer rangeSumInfo = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(rangeSumInfo.nextToken());
            int startY = Integer.parseInt(rangeSumInfo.nextToken());
            int endX = Integer.parseInt(rangeSumInfo.nextToken());
            int endY = Integer.parseInt(rangeSumInfo.nextToken());

            result.append(prefixArr[endX][endY] - prefixArr[startX - 1][endY] - prefixArr[endX][startY - 1] + prefixArr[startX - 1][startY - 1]).append("\n");
        }

        System.out.println(result.toString());
    }
}