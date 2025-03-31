import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        // DP
        double max = arr[0];
        double curr = arr[0];

        for (int i = 1; i < N; i++) {
            curr = Math.max(arr[i], curr * arr[i]); // 끊고 새로 or 계속 곱하기
            max = Math.max(max, curr);
        }

        // 출력
        System.out.printf("%.3f\n", max); // 소수점 3째자리까지 출력
    }
}
