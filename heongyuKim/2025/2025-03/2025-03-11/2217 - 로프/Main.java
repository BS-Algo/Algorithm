import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

class Main {

    // 결과로 출력할 변수
    static int result = 0;

    // 줄을 담을 배열 생성
    static Integer[] ropes;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 로프의 수
        int N = Integer.parseInt(br.readLine());

        // 사용할 줄의 갯수
        int count = 0;

        // 배열 생성
        ropes = new Integer[N];
    
        // 배열에 줄 받기
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        // 정렬하기 - 내림차순(내림차순 정렬을 사용하려면 int[] 대신 Integer[]를 사용해야함.)
        Arrays.sort(ropes, Collections.reverseOrder());

        // 정렬한 것을 바탕으로 최대 중량 계산
        for (int i = 0; i < N; i++) {
            count++;

            int weight = ropes[i] * count;

            result = Math.max(result, weight);
        }

        System.out.println(result);
    }
}