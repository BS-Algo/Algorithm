import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    static int standardIndex;
    static int standardHeight;

    static int currentIndex;
    static int currentHeight;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 기둥의 갯수
        int pillarCount = Integer.parseInt(br.readLine());

        // 배열 생성
        int[][] pillars = new int[pillarCount][2];

        // 배열에 값 넣기
        for (int i = 0; i < pillarCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            pillars[i][0] = index;
            pillars[i][1] = height;

            if (standardHeight < height) {
                standardHeight = height;
                standardIndex = index;
            }
        }

        Arrays.sort(pillars, Comparator.comparingInt(o -> o[0]));

        int pivot = 0;
        for (int i = 0; i < pillarCount; i++) {
            if (standardIndex == pillars[i][0] && standardHeight == pillars[i][1]) {
                pivot = i;
                break;
            }
        }

        currentIndex = pillars[0][0];
        currentHeight = pillars[0][1];

        for (int i = 1; i <= pivot; i++) {
            if (currentHeight < pillars[i][1]) {
                result += currentHeight * (pillars[i][0] - currentIndex);
                currentIndex = pillars[i][0];
                currentHeight = pillars[i][1];
            }

            if (currentHeight == standardHeight) {
                result += (standardIndex - currentIndex) * standardHeight;
                break;
            }
        }

        currentIndex = pillars[pillarCount - 1][0];
        currentHeight = pillars[pillarCount - 1][1];

        for (int i = pillarCount - 1; i >= pivot; i--) {
            if (currentHeight < pillars[i][1]) {
                result += currentHeight * (currentIndex - pillars[i][0]);
                currentIndex = pillars[i][0];
                currentHeight = pillars[i][1];
            }

            if (currentHeight == standardHeight) {
                result += (currentIndex - standardIndex) * standardHeight;
                break;
            }

        }

        result += standardHeight;

        System.out.println(result);

    }
}