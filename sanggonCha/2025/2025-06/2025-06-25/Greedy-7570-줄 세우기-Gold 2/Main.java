import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 어린이 수 입력

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] indexes = new int[N + 1];
        for (int index = 0; index < N; index++) {
            int number = Integer.parseInt(st.nextToken()); // 어린이 번호 입력
            indexes[number] = index; // 인덱스를 저장
        }

        // 연속 증가 수열 최대 길이 찾기
        int nowLength = 1;
        int maxLength = 1;
        for (int number = 1; number < N; number++) { // 1번부터 N번까지 어린이들의 인덱스를 확인
            if (indexes[number] < indexes[number + 1]) { // "1 큰 수"의 인덱스가 더 크다면(= "1 큰 수"가 더 뒤에 있는 것)
                nowLength++; // 길이 증가
                maxLength = Math.max(maxLength, nowLength); // 기존까지 계산된 최대 길이 갱신
            } else { // "1 큰 수"가 더 앞에 있는 경우
                nowLength = 1; // 길이 초기화
            }
        }

        // 출력
        // greedy: 최대 연속 길이를 제외한 개수만큼만 차례대로 제일 앞뒤로 보내주면 정렬 가능
        System.out.println(N - maxLength);
    }
}