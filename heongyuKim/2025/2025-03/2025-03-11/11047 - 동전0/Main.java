import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    // 결과로 출력할 변수
    static int result = 0;

    // 동전의 가치를 담을 배열
    static int[] coins;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N = 동전의 단위 갯수와 K = 환전할 값
        StringTokenizer info = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(info.nextToken());
        int K = Integer.parseInt(info.nextToken());
        
        // 배열 생성
        coins = new int[N];
        
        // 배열에 동전의 단위 담기
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 끝에서부터 K / 동전의 가치 단위가 0이면 패스 아니면 결과에 더하고 %를 K에 대입하기
        for (int i = N - 1; i > -1; i--) {

            int share = K / coins[i];

            if (share != 0) {
                result += share;
                K = K % coins[i];
            }
        }

        System.out.println(result);
    }
}