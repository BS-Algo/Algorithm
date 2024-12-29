import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        char[][] DNAs = new char[N][M];

        for (int i = 0; i < N; i++) {
            DNAs[i] = br.readLine().toCharArray();
        }

        // ACGT
        int hd = 0; // Hamming Distance
        for (int j = 0; j < M; j++) {
            int[] countList = new int[30];
            for (int i = 0; i < N; i++) {
                countList[(int) DNAs[i][j] - 65]++;
            }

            // 최대 빈도수 찾기
            int max = 0;
            for (int i = 0; i < 30; i++) {
                if (countList[i] > max) {
                    max = countList[i]; // 최대 빈도수 저장
                }
            }

            // 최대 빈도수 인덱스 문자로 변환하여 출력(사전순으로 제일 빠른 것을 출력)
            for (int i = 0; i < 30; i++) {
                if (countList[i] == max) {
                    System.out.print((char) (i + 65));
                    hd += (N - countList[i]);
                    break;
                }
            }
        }
        System.out.printf("\n%d", hd);
    }
}