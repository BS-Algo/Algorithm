import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T 입력
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            // N, M 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 배열 생성
            boolean[] used = new boolean[N + 1];

            // a, b 입력
            int[][] arr = new int[M][2];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            // 정렬
            Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));

//            for (int i = 0; i < M; i++) {
//                System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2]);
//            }

            // Greedy
            int ans = 0;
            for (int[] cur : arr) {
                int a = cur[0];
                int b = cur[1];

                for (int i = a; i <= b; i++) { // a부터 b까지 greedy하게 할당
                    if (!used[i]) {
                        used[i] = true;
                        ans++;
                        break;
                    }
                }
            }

            // 출력
            System.out.println(ans);
        }
    }
}