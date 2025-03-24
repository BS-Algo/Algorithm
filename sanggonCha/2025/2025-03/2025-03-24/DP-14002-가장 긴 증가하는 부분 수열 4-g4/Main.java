import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i]: arr[i]를 마지막 원소로 하는 최장 증가 부분 수열의 길이
        // parent[i]: arr[i]가 속하는 수열에서 바로 이전에 오는 원소의 인덱스 (복원용)
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int maxLength = 0;
        int maxIndex = 0;

        // dp 점화식: dp[i] = max(dp[j]) + 1, (j < i, arr[j] < arr[i])
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxIndex = i;
            }
        }

        // 실제 수열 복원
        ArrayList<Integer> lis = new ArrayList<>();
        for (int i = maxIndex; i != -1; i = parent[i]) {
            lis.add(arr[i]);
        }
        Collections.reverse(lis);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(maxLength).append("\n");
        for (int num : lis) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
