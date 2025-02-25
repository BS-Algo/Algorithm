import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

    // 구간 합 배열
    static int[] arr;

    // 결과로 나타낼 것들을 출력할 StringBuilder
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 주어진 수의 갯수와 구간 합을 도출할 갯수를 담은 정보
        StringTokenizer info = new StringTokenizer(br.readLine());

        // 주어진 수의 갯수
        int count = Integer.parseInt(info.nextToken());
        
        // 구간 합을 도출할 갯수
        int rangeSumCount = Integer.parseInt(info.nextToken());

        // 구간 합 배열 생성
        arr = new int[count];

        // 반복문을 통해서 구간합을 계산하여 구간 합 배열에 넣기
        StringTokenizer nums = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < count; i++) {

            int num = Integer.parseInt(nums.nextToken());

            // 배열에 합을 넣기
            if (i == 0) {
                arr[i] = num;
            } else {
                arr[i] = arr[i - 1] + num;
            }
        }

        // 넣은 합 배열을 바탕으로 구간 합 출력하기
        for (int i = 0; i < rangeSumCount; i++) {
            StringTokenizer range = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(range.nextToken());
            int end = Integer.parseInt(range.nextToken());

            // 배열의 인덱스를 고려해줘야하므로 end에 -1 처리하고 start에는 1일 때와 아닐 경우를 처리하여 계산하기
            if (start == 1) {
                result.append(arr[end - 1]);
            } else {
                result.append(arr[end - 1] - arr[start - 2]);
            }

            result.append('\n');
        }
        
        // 결과 출력
        System.out.println(result.toString());

    }
}