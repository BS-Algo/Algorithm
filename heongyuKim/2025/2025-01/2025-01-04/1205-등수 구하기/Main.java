import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] scoreList = new int[P];

        // 태수의 등수
        int rank = 1;

        if (N == 0) {
            System.out.println(1);
        } else {
            StringTokenizer scores = new StringTokenizer(br.readLine());

            // 점수들을 랭킹 리스트 수 만큼만 받기
            for (int i = 0; i < N; i++) {
                int score = Integer.parseInt(scores.nextToken());
                scoreList[i] = score;
            }

            // 랭킹 리스트를 뒤집기
            Arrays.sort(scoreList);

            if (P == N && scoreList[0] >= newScore) {
                System.out.println(-1);
                return;
            }

            for (int j = P - 1; j >= Math.max(0, P-N-1); j--) {
                if (scoreList[j] > newScore) {
                    rank++;
                } else {
                    System.out.println(rank);
                    return;
                }
            }
        }

    }
}