import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {

    // 구간 합 배열
    static int[][] arr;

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

        // 누적합 배열 생성 N + 1로 생성
        arr = new int[N][N + 1];

        // 배열에 누적합 넣기 넣을 때
        // 첫번째 줄의 맨 처음 원소에는 0
        // 그 다음 줄 부터는 그 전 줄의 마지막 원소를 넣기
        for (int i = 0;  i < N; i++) {
            StringTokenizer nums = new StringTokenizer(br.readLine());

            for (int j = 0;  j < N + 1; j++) {

                if (i == 0 && j == 0) {
                    arr[i][j] = 0;
                } else if (i > 0 && j == 0) {
                    arr[i][j] = arr[i - 1][N];
                } else {
                    int num = Integer.parseInt(nums.nextToken());
                    arr[i][j] = arr[i][j - 1] + num;
                }
            }
        }


        for (int i = 0; i < M; i++) {
            StringTokenizer rangeInfo = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(rangeInfo.nextToken()) - 1;
            int startY = Integer.parseInt(rangeInfo.nextToken());
            int endX = Integer.parseInt(rangeInfo.nextToken()) - 1;
            int endY = Integer.parseInt(rangeInfo.nextToken());

            if (startX == endX) {
                result.append(arr[endX][endY] - arr[startX][startY - 1]);
            } else {
                int sum = 0;

                for (int j = startX; j < endX + 1; j++) {
                    sum += arr[j][endY] - arr[j][startY - 1];
                }

                result.append(sum);

            }

            result.append('\n');
        }

        System.out.println(result.toString());
    }
}