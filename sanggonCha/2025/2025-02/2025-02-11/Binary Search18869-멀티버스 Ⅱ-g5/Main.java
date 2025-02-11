import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static String[] converted;
    private static int[][] space;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // 행성 입력 받기
        space = new int[M][N]; // M개의 우주와 N개의 행성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행성 변환
        converted = new String[M]; // 변환한 행성을 저장할 배열
        for (int i = 0; i < M; i++) {
            convert(i, space[i]);
        }

        // 우주 쌍 찾기
        int ans = 0;
        for (int s1 = 0; s1 < M - 1; s1++) {
            for (int s2 = s1 + 1; s2 < M; s2++) {
                if (converted[s1].equals(converted[s2])) ans++;
            }
        }

        // 출력
        System.out.println(ans);
    }

    private static void convert(int spaceNum, int[] planet) {
        int[] sorted = planet.clone();

        Arrays.sort(sorted);

        Map<Integer, Integer> rankMap = new HashMap<>();

        // 해쉬맵에 저장
        for (int i = 0; i < N; i++) {
            if (!rankMap.containsKey(planet[i])) { // 같은 크기의 행성은 같은 크기로 처리
                rankMap.put(sorted[i], rankMap.size());
            }
        }

        // 해쉬맵을 참고하여 랭크로 변환
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(rankMap.get(planet[i]));
        }

        // 변환이 끝난 문자열을 저장
        converted[spaceNum] = sb.toString();
    }
}