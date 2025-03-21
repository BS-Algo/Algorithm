import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 핀 날과 진 날의 차이가 큰것 위주로 하는 것은 알았지만 세부적인 로직이 생각이 안나서 다시 풀어봐야할듯.
class Main {
    // 날짜를 담을 배열
    static int[][] arr;

    // 결과
    static long result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N
        int N = Integer.parseInt(br.readLine());

        // 배열 생성
        arr = new int[N][2];

        // 날짜를 배열에 넣기
        for (int i = 0; i < N; i++) {
            StringTokenizer range = new StringTokenizer(br.readLine());

            // 피는 날
            int startDate = Integer.parseInt(range.nextToken()) * 100 + Integer.parseInt(range.nextToken());

            // 지는 날
            int endDate = Integer.parseInt(range.nextToken()) * 100 + Integer.parseInt(range.nextToken());

            arr[i][0] = startDate;
            arr[i][1] = endDate;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }

                return o1[0] - o2[0];
            }
        });

        int start = 301;
        int end = 1201;
        int index = 0;
        int max = 0;

        while (start < end) {
            boolean isFinded = false;

            for (int i = index; i < N; i++) {
                if (arr[i][0] > start) {
                    break;
                }

                if (max < arr[i][1]) {
                    isFinded = true;
                    max = arr[i][1];
                    index = i + 1; // 가지치기
                }
            }

            if (isFinded) {
                start = max;
                result++;
            } else {
                break;
            }
        }

        if (max < end) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}