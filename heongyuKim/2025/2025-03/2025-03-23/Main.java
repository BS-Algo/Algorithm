import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최장 증가 수열을 알아야 풀 수 있었던 문제.
class Main {
    // 숫자들을 담을 배열
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 어린이의 수
        int N = Integer.parseInt(br.readLine());

        // N이 1인 경우 답은 무조건 0
        if (N == 1) {
            System.out.println(0);
            return;
        }

        // 배열 생성
        arr = new int[N + 1];

        StringTokenizer info = new StringTokenizer(br.readLine());

        // 어린이의 순서를 담기 - 어린이의 번호에 맞추어 저장
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(info.nextToken())] = i;
        }

        int max = 1;
        int count = 0;

        // N에서 최장 증가 수열의 최댓값을 뺀 값이 결과.
        for (int i = 1; i <= N; i++) {
            if (arr[i] > arr[i - 1]) {
                if (++count > max) {
                    max = count;
                }
            } else {
                count = 1;
            }
        }

        System.out.println(N - max);
    }
}