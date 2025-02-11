import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 우주의 개수
        int N = Integer.parseInt(st.nextToken()); // 행성의 개수

        Map<String, Integer> patternCount = new HashMap<>(); // 패턴별 등장 횟수 저장
        int[][] space = new int[M][N];

        // 데이터 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 좌표 압축 및 패턴 저장
        for (int i = 0; i < M; i++) {
            int[] ranked = getRankPattern(space[i]);
            String patternKey = Arrays.toString(ranked); // 배열을 문자열로 변환하여 저장

            patternCount.put(patternKey, patternCount.getOrDefault(patternKey, 0) + 1);
        }

        // 균등한 우주 쌍 개수 계산
        int ans = 0;
        for (int count : patternCount.values()) {
            ans += (count * (count - 1)) / 2; // 같은 패턴끼리 조합하여 쌍을 만든다.
        }

        System.out.println(ans);
    }

    // 좌표 압축 (랭크 변환)
    private static int[] getRankPattern(int[] arr) {
        int N = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted); // 정렬하여 순위 변환 기준 배열 생성

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < N; i++) {
            if (!rankMap.containsKey(sorted[i])) {
                rankMap.put(sorted[i], rank++); // 중복 방지하여 랭크 부여
            }
        }

        int[] ranked = new int[N];
        for (int i = 0; i < N; i++) {
            ranked[i] = rankMap.get(arr[i]); // 원래 배열을 순위 값으로 변환
        }

        return ranked;
    }
}
