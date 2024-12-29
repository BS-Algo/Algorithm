import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // N, M 입력 받기
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);


        // N줄 바닥 입력 받기
        char[][] floor = new char[N][M];
        for (int i = 0; i < N; i++) {
            floor[i] = br.readLine().toCharArray();
        }

        // 나무 판자 개수 계산
        int ans = N * M;

        // 가로
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (floor[i][j] == '-' && floor[i][j + 1] == '-') {
                    ans--;
                }
            }

        }

        // 세로
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N - 1; i++) {
                if (floor[i][j] == '|' && floor[i + 1][j] == '|') {
                    ans--;
                }
            }
        }

        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}