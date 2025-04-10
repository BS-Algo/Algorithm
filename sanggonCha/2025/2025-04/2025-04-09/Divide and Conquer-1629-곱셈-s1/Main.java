import java.io.*;
import java.util.*;

public class Main {
    static int A, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // A, B, C 입력 받기
        A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 출력
        System.out.println(pow(B));
    }

    // 분할 정복
    private static long pow(int B) {
        // 재귀 종료 조건
        if (B == 1) return A % C;

        long half = pow(B / 2) % C;
        long result = (half * half) % C;

        if (B % 2 == 0) return result;
        else return (result * A) % C;
    }
}