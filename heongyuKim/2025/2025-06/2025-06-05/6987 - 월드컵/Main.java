import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 모든 사람이 각각 경기하는 조합을 만들고
// 그 조합을 바탕으로 승 무 패의 숫자대로 dfs를 돌리면서 가능한지 안한지 체크하기.
public class Main {
    static int[][] games = new int[15][2];
    static int[][] record;

    static boolean isPossible;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index = 0;

        // 모든 사람과의 경기 조합 생성
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                games[index][0] = i;
                games[index][1] = j;
                index++;
            }
        }

        // 4개의 테스트 케이스 별로 가능한지 안한지 체크
        for (int i = 0; i < 4; i++) {
            record = new int[6][3];

            StringTokenizer info = new StringTokenizer(br.readLine());

            int sum = 0;

            for (int j = 0; j < 6; j++) {
                for (int q = 0; q < 3; q++) {
                    int num = Integer.parseInt(info.nextToken());
                    record[j][q] = num;
                    sum += num;
                }
            }

            isPossible = false;
        
            // 총 30개의 승 무 패가 나와야 정상적인 결과가 나옴.
            if (sum == 30) {
                dfs(0);
            }

            if (isPossible) {
                result.append("1").append(" ");
            } else {
                result.append("0").append(" ");
            }
        }

        System.out.println(result.toString());
    }


    private static void dfs(int depth) {
        if (isPossible) return;

        if (depth == 15) {
            isPossible = true;
            return;
        }

        int p1 = games[depth][0];
        int p2 = games[depth][1];


        // p1 승 p2 패
        if (record[p1][0] > 0 && record[p2][2] > 0) {
            record[p1][0]--;
            record[p2][2]--;
            dfs(depth + 1);
            record[p1][0]++;
            record[p2][2]++;
        }
        
        // 무승부
        if (record[p1][1] > 0 && record[p2][1] > 0) {
            record[p1][1]--;
            record[p2][1]--;
            dfs(depth + 1);
            record[p1][1]++;
            record[p2][1]++;
        }
        
        // p1 패 p2 승
        if (record[p1][2] > 0 && record[p2][0] > 0) {
            record[p1][2]--;
            record[p2][0]--;
            dfs(depth + 1);
            record[p1][2]++;
            record[p2][0]++;
        }

    }
}