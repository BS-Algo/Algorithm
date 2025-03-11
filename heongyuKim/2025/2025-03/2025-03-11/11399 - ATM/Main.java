import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    // 결과로 출력할 변수
    static int result = 0;

    // 사람별 인출 시간을 담을 배열
    static int[] people;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람의 수
        int N = Integer.parseInt(br.readLine());

        // 배열 생성
        people = new int[N];

        // 인출시간 받기
        StringTokenizer times = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(times.nextToken());
        }

        Arrays.sort(people);

        // 합 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                result += people[j];
            }
        }

        System.out.println(result);
    }
}