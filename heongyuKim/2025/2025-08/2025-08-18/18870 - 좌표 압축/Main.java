import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums;
    static int[] sequence;

    static HashSet<Integer> set = new HashSet<>();
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        sequence = new int[N];

        StringTokenizer info = new StringTokenizer(br.readLine());
        
        // set으로 중복 제거, ArrayList로 중복 제거를 하려고하면 O(N ^ 2)만큼 시간이 걸려서 시간초과가 발생
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(info.nextToken());
            nums[i] = num;
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        // 이분 탐색
        for (int i = 0; i < N; i++) {
            int num = nums[i];
            int start = 0;
            int end = list.size() - 1;

            while (start <= end) {
                int mid = (end + start) / 2;

                if (num == list.get(mid)) {
                    sequence[i] = mid;
                    break;
                } else if (list.get(mid) < num) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            result.append(sequence[i]).append(" ");
        }

        System.out.println(result.toString());
    }
}
