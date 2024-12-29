package optimization;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        String[] NM = br.readLine().split(" ");
        int dnaCount = Integer.parseInt(NM[0]);
        int sequenceLength = Integer.parseInt(NM[1]);

        char[][] dnaSequences = new char[dnaCount][sequenceLength];

        for (int i = 0; i < dnaCount; i++) {
            dnaSequences[i] = br.readLine().toCharArray();
        }

        // // 결과를 저장할 StringBuilder와 해밍 거리 합
        StringBuilder consensusDna = new StringBuilder();
        int totalHammingDistance = 0; // Hamming Distance

        // 각 열에서 최빈 문자 계산
        for (int col = 0; col < sequenceLength; col++) {
            int[] nucleotideCounts = new int[4]; // A, C, G, T
            for (int row = 0; row < dnaCount; row++) {
                switch (dnaSequences[row][col]) {
                    case 'A': nucleotideCounts[0]++; break;
                    case 'C': nucleotideCounts[1]++; break;
                    case 'G': nucleotideCounts[2]++; break;
                    case 'T': nucleotideCounts[3]++; break;
                }
            }

            // 최대 문자 결정 (사진순 우선)
            int maxCount = 0;
            char selectedNucleotide = 'A';
            char[] nucleotides = {'A', 'C', 'G', 'T'};
            for (int i = 0; i < 4; i++) {
                if (nucleotideCounts[i] > maxCount) {
                    maxCount = nucleotideCounts[i]; // 최대 빈도수 저장
                    selectedNucleotide = nucleotides[i];
                }
            }

            // 선택된 문자 추가 및 해밍 거리 누적합
            consensusDna.append(selectedNucleotide);
            totalHammingDistance += (dnaCount - maxCount);
        }

        // 결과 출력
        bw.write(consensusDna.toString()); // dna 출력
        bw.newLine();
        bw.write(String.valueOf(totalHammingDistance)); // 해밍 거리 출력
        bw.newLine();

        // 버퍼 지우기 및 종료
        bw.flush();
        bw.close();
    }
}