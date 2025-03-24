import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 현재 꽂혀있는 콘센트들 중 일부만 나중에 사용된다면, 나중에도 사용되지 않는 콘센트를 제거하고, 현재 사용하려는 콘센트를 꽂는다.
// 현재 꽂혀있는 콘센트 모두 나중에 사용된다면, 그 중 그나마 가장 늦게 사용되는 콘센트를 제거하고, 현재 사용하려는 콘센트를 꽂는다.
class Main {
    // 결과로 사용할 변수
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정보
        StringTokenizer info = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(info.nextToken());
        int K = Integer.parseInt(info.nextToken());

        List<Integer> orders = new ArrayList<>();
        List<Integer> multiTab = new ArrayList<>();

        StringTokenizer nums = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(nums.nextToken());
            orders.add(num);
        }

        while (!orders.isEmpty()) {
            int num = orders.remove(0);

            if (multiTab.contains(num)) continue;

            if (multiTab.size() < N) {
                multiTab.add(num);
            } else {
                boolean flag = false;
                int index = -1;
                int maxIndex = -1;
                result++;

                for (int i = 0; i < N; i++) {
                    // 앞으로 사용하지 않을 전자기기
                    if (!orders.contains(multiTab.get(i))) {
                        flag = true;
                        multiTab.remove(i);
                        multiTab.add(num);
                        break;
                    } else {
                        if (orders.indexOf(multiTab.get(i)) > index) {
                            index = orders.indexOf(multiTab.get(i));
                            maxIndex = i;
                        }
                    }
                }

                if (!flag) {
                    multiTab.remove(maxIndex);
                    multiTab.add(num);
                }
            }
        }

        System.out.println(result);
    }
}