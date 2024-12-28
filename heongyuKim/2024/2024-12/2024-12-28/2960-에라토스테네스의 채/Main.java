import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 2부터 N까지 모든 정수를 적는다.
        int[] arr = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            arr[i] = i;
        }
        
        // 아직 지우지 않은 수 중 가장 작은 수를 찾고 지운 다음 배수도 지운다.
        int removalIndex = 0;
        for (int q = 2; q <= N; q++) {
            if (arr[q] == 0) continue;
            for (int w = q; w <= N; w += q) {
                if (arr[w] != 0) {
                    arr[w] = 0;
                    removalIndex++;
                }

                if (removalIndex == K) {
                    System.out.println(w);
                    return;
                }
            }
        }
    }
}
