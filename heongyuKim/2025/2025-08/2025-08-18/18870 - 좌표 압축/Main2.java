import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// 1차원 좌표 압축 알고리즘을 활용한 풀이
public class Main2 {
    static int N;
    static int[] nums;
    static int[] sorted;

    static HashMap<Integer, Integer> map = new HashMap<>();
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        sorted = new int[N];

        StringTokenizer info = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(info.nextToken());
            nums[i] = num;
            sorted[i] = num;
        }

        // 정렬
        Arrays.sort(sorted);

        int rank = 0;

        // map에 순위를 매기면서 넣기
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank);
                rank++;
            }
        }
        
        // map을 참조하여 순위를 결과에 넣기
        for (int i = 0; i < N; i++) {
            result.append(map.get(nums[i])).append(" ");
        }

        System.out.println(result.toString());
    }
}
