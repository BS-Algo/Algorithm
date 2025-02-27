import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

    // 나머지가 같은 것들이 몇개 있는지에 대한 정보를 담을 배열
    static long[] pairArr;

    // 결과
    static long result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N과 M의 정보
        StringTokenizer info = new StringTokenizer(br.readLine());

        // N
        int N = Integer.parseInt(info.nextToken());

        // M
        int M = Integer.parseInt(info.nextToken());

        // 배열 생성
        long prefix = 0;
        pairArr = new long[M];

        // 주어진 숫자 정보
        StringTokenizer nums = new StringTokenizer(br.readLine());
        
        // 숫자 정보를 활용하여 나머지가 0인 숫자가 있으면 결과에 + 1, 그리고 페어 배열에 나머지와 같은 인덱스에 + 1
        // 여기서 누적합이 int가 표현할 수 있는 범위를 넘어설 수 있기 때문에 long으로 처리하기
        for (int i = 1; i < N + 1; i++) {
            int num = Integer.parseInt(nums.nextToken());
            prefix += num;
            long remain = prefix % M;

            if (remain == 0) {
                result++;
            }

            pairArr[(int) remain]++;
        }

        // 페어 배열의 값을 2개를 뽑는 조합의 수로 결과에 더하기
        for (int i = 0; i < M; i++) {
            result += (pairArr[i] * (pairArr[i] - 1)) / 2;
        }

        System.out.println(result);

    }
}