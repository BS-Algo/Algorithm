import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class Main2 {
    static int romeCount;
    static int[] arr = new int[] {1, 5, 10, 50};
    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        romeCount = Integer.parseInt(br.readLine());

        // 백트래킹으로 풀기
        combination(0, 0, 0);

        System.out.println(hashSet.size());

    }
    
    static void combination(int sum, int idx, int cnt) {
        if (cnt == romeCount) {
            if (!hashSet.contains(sum)) {
                hashSet.add(sum);
            }
            return;
        }

        for (int i = idx; i < 4; i++) {
            combination(sum + arr[i], i, cnt + 1);
        }
    }

}