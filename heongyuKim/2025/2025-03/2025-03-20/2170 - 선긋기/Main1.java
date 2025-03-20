import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


// 스위핑 방식을 참조하여 짠 코드
class Main {
    static int[][] arr;

    // 결과
    static long result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N
        int N = Integer.parseInt(br.readLine());

        // 배열 생성
        arr = new int[N][2];

        // 배열에 수 넣기
        for (int i = 0; i < N; i++) {
            StringTokenizer info = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(info.nextToken());
            arr[i][1] = Integer.parseInt(info.nextToken());
        }

        // 정렬하기
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int min = arr[0][0];
        int max = arr[0][1];
        result += max - min;

        // 정렬 후 계산 - 스위핑 방식
        for (int i = 1; i < N; i++) {
            int x = arr[i][0];
            int y = arr[i][1];

            if (min <= x && y <= max) {
                continue;
            } else if (x <= max) {
                result += y - max;
            } else {
                result += y - x;
            }

            min = x;
            max = y;
        }
        System.out.println(result);
    }
}