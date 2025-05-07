import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 손님 수 입력 받기

        // 입력 받기
        int N = Integer.parseInt(st.nextToken()); // 전체 객차의 수
        int H = Integer.parseInt(st.nextToken()); // 전체 객차의 수
        int[] arr = new int[N + 1]; // 부분합을 저장할 배열
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }
}