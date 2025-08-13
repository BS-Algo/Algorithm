import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
    static int[] A;
    static int[] B;

    static int ansSize = 0;
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer info = new StringTokenizer(br.readLine());

        int aLen = Integer.parseInt(info.nextToken());
        int bLen = Integer.parseInt(info.nextToken());

        A = new int[aLen];
        B = new int[bLen];

        StringTokenizer aInfo = new StringTokenizer(br.readLine());

        for (int i = 0; i < aLen; i++) {
            A[i] = Integer.parseInt(aInfo.nextToken());
        }

        StringTokenizer bInfo = new StringTokenizer(br.readLine());

        for (int i = 0; i < bLen; i++) {
            B[i] = Integer.parseInt(bInfo.nextToken());
        }

        // 오름차순 정렬하기
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < aLen; i++) {
            int num = A[i];

            // 이분탐색
            // 있으면 바로 continue;
            // 없으면 ans에 넣기
            int start = 0;
            int end = bLen - 1;

            boolean isCheck = true;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                int midNum = B[mid];
                if (num == midNum) {
                    isCheck = false;
                    break;
                } else if (num > midNum) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            if (isCheck) {
                ansSize++;
                ans.append(num).append(" ");
            }
        }

        if (ans.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(ansSize);
            System.out.println(ans);
        }
    }
}