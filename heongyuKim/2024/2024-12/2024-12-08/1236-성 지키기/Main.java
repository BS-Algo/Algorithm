import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 성의 크기 받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(bf.readLine());

        // 세로의 길이
        int N = Integer.parseInt(st.nextToken());
        // 가로의 길이
        int M = Integer.parseInt(st.nextToken());

        // 경비 배치도 받기
        char[][] castle = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            castle[i] = line.toCharArray();
        }

        bf.close();

        // 행에 필요한 경비 수
        int rowGuard = 0;

        // 열에 필요한 경비 수
        int colGuard = 0;

        // 가로로 순회하면서 체크하기
        for (int e = 0; e < N; e++) {
            boolean rowCheck = false;
            for (int w = 0; w < M; w++) {
                if (castle[e][w] == 'X') {
                    rowCheck = true;
                    break;
                }
            }

            if (!rowCheck) {
                rowGuard++;
            }
        }

        // 세로로 순회하면서 체크하기
        for (int w = 0; w < M; w++) {
            boolean colCheck = false;
            for (int a = 0; a < N; a++) {
                if (castle[a][w] == 'X') {
                    colCheck = true;
                    break;
                }
            }

            if (!colCheck) {
                colGuard++;
            }

        }

        System.out.println(Math.max(rowGuard, colGuard));
    }
}
