import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열의 크기 받기
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        // 문자열 배열로 받기
        String[] arr = new String[row];

        for (int i = 0; i < row; i++) {
            arr[i] = br.readLine();
        }

        // 합이 가장 작은 DNA
        StringBuilder sb = new StringBuilder();

        // Hamming Distance 합
        int sum = 0;

        // 받은 후 인덱스마다 비교하기
        // 반복문 이용하기
        for (int i = 0; i < col; i++) {
            // A, C, G, T
            int[] nucleotide = new int[4];

            for (int j = 0; j < row; j++) {
                char ch = arr[j].charAt(i);
                switch (ch) {
                    case 'A':
                        nucleotide[0]++;
                        break;
                    case 'C':
                        nucleotide[1]++;
                        break;
                    case 'G':
                        nucleotide[2]++;
                        break;
                    case 'T':
                        nucleotide[3]++;
                        break;
                }
            }

            int maxDna = Arrays.stream(nucleotide).max().orElseThrow();

            // 크기 비교
            for (int q = 0; q < 4; q++) {
                // 제일 많이 나온 빈도수 찾기
                if (nucleotide[q] == maxDna) {
                    switch (q) {
                        case 0:
                            sb.append('A');
                            break;
                        case 1:
                            sb.append('C');
                            break;
                        case 2:
                            sb.append('G');
                            break;
                        case 3:
                            sb.append('T');
                            break;
                    }
                    break;
                }
            }
            sum += row - maxDna;
        }

        // 가장 많이 나온 문자 출력
        System.out.println(sb.toString());
        // Hamming Distance의 합을 구하기
        System.out.println(sum);
    }
}