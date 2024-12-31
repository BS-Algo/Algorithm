import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 난이도 배열 생성
        int people = Integer.parseInt(br.readLine());
        int[] difficultyLevels = new int[people];
        for (int i = 0; i < people; i++) {
            difficultyLevels[i] = Integer.parseInt(br.readLine());
        }

        // 배열 생성 후 오름 차순으로 정렬
        Arrays.sort(difficultyLevels);

        // 우선 몇명의 사람으로 절사할지(반올림)
        double trimCount = people * 0.15;
        int trimCountRound = (int) Math.round(trimCount);

        // 절사한 후 난이도 평균 계산 (반올림)
        // 앞뒤로 잘라서 계산
        int addTotal = 0;
        for (int s = trimCountRound; s <= ((people - 1) - trimCountRound); s++) {
            addTotal += difficultyLevels[s];
        }

        // 평균계산 후 반올림
        double average = (double) addTotal / (people - (trimCountRound * 2));
        int result = (int) Math.round(average);

        System.out.println(result);
    }
}
