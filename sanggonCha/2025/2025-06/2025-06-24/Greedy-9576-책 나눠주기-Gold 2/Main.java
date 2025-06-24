import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T 입력
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 책의 수
            int M = Integer.parseInt(st.nextToken()); // 학생의 수

            // 책 번호 입력
            int[][] numbers = new int[M][2];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                numbers[i][0] = Integer.parseInt(st.nextToken()); // start
                numbers[i][1] = Integer.parseInt(st.nextToken()); // end
            }

            // 정렬
            Arrays.sort(numbers, (a, b) -> { // end 오름차순 정렬
                return a[1] - b[1];
            });

            // Greedy
            int availableCount = 0;
            boolean[] available = new boolean[N + 1];
            for (int[] number : numbers) {
                int start = number[0];
                int end = number[1];
                while (start <= end) {
                    if (!available[start]) {
                        available[start] = true;
                        availableCount++;
                        break;
                    }
                    start++;
                }
            }

            // 출력
            System.out.println(availableCount);
        }
    }
}