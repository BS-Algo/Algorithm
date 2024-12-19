import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int range = Integer.parseInt(bf.readLine());

        // 2중 배열 만들기
        int[][] people = new int[range][2];

        // 사람들의 등수를 출력할 배열
        int[] ranking = new int[range];

        // 사람들의 키와 몸무게를 받기
        for (int i = 0; i < range; i++) {
            // 몸무게, 키
            String person = bf.readLine();
            StringTokenizer st = new StringTokenizer(person);
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            people[i][0] = weight;
            people[i][1] = height;
        }

        // 등수 매기기
        for (int e = 0; e < range; e++) {
            for (int w = 0; w < range; w++) {
                if (e != w) {
                    if (people[e][0] < people[w][0] && people[e][1] < people[w][1]) {
                        ranking[e]++;
                    }
                }
            }
            ranking[e]++;
        }

        for (int i = 0; i < range; i++) {
            System.out.print(ranking[i] + " ");
        }
    }
}
