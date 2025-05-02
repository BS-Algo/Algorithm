import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] applicants = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[i][0] = Integer.parseInt(st.nextToken()); // 서류 성적
                applicants[i][1] = Integer.parseInt(st.nextToken()); // 면접 성적
            }

            // 서류 성적 기준 오름차순 정렬
            Arrays.sort(applicants, Comparator.comparingInt(a -> a[0]));

            int count = 1; // 첫 번째 지원자는 무조건 선발
            int minInterviewRank = applicants[0][1];

            for (int i = 1; i < N; i++) {
                if (applicants[i][1] < minInterviewRank) {
                    count++;
                    minInterviewRank = applicants[i][1]; // 더 낮은 면접 성적 기준으로 갱신
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
