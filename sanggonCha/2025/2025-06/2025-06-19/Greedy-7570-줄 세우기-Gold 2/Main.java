import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        // 어린이 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] position = new int[N + 1]; // n번 학생의 위치를 저장
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // arr[i] = n
            position[arr[i]] = i; // position[n] = i
        }

        // 변수 생성
        int maxLen = 1;
        int currentLen = 1;

        // 가장 긴 증가하는 "연속된" 부분 수열의 길이 찾기
        for (int num = 1; num < N; num++) { // 시작점 고정
            // num과 num+1이 연속으로 배치되어 있는지 확인
            if (position[num] < position[num + 1]) { // num보다 1 큰 값의 인덱스가 더 크다면
                currentLen++; // 길이 증가
            } else {
                currentLen = 1; // 길이 초기화
            }
            maxLen = Math.max(maxLen, currentLen);
        }

        // Greedy하게 답을 찾아서 출력
        // 연속된 수열(길이 maxLen)을 찾았으므로,
        // Greedy하게 나머지 숫자를 제일 앞뒤로 배치한다면
        // N(전체 길이) - maxLen 번 만에 구할 수 있음
        System.out.println(N - maxLen);
    }
}