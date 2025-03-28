import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


// 코드가 너무 지저분하다...
// 하지만 로직은 맞았음
class Main {
    
    // 음의 배열
    static List<Integer> minus = new ArrayList<>();

    // 양의 배열
    static List<Integer> plus = new ArrayList<>();

    // 절댓값 기준 최대값이 있는 곳
    static boolean isMax = false;

    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N과 M
        StringTokenizer info = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(info.nextToken());
        int M = Integer.parseInt(info.nextToken());

        StringTokenizer nums = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(nums.nextToken());
            if (num < 0) {
                minus.add(Math.abs(num));
            } else {
                plus.add(num);
            }
        }

        if (!minus.isEmpty() && !plus.isEmpty()) {
            Collections.sort(minus, Collections.reverseOrder());
            Collections.sort(plus, Collections.reverseOrder());

            if (minus.get(0) < plus.get(0)) {
                isMax = true;
            }

            if (isMax) {
                for (int i = 0; i < plus.size(); i += M) {
                    if (i == 0) {
                        result += plus.get(i);
                    } else {
                        result += (plus.get(i) * 2);
                    }
                }

                for (int i = 0; i < minus.size(); i += M) {
                    result += (minus.get(i) * 2);
                }
            } else {
                for (int i = 0; i < minus.size(); i += M) {
                    if (i == 0) {
                        result += minus.get(i);
                    } else {
                        result += (minus.get(i) * 2);
                    }
                }

                for (int i = 0; i < plus.size(); i += M) {
                    result += (plus.get(i) * 2);
                }

            }
        } else if (minus.isEmpty() && !plus.isEmpty()) {
            Collections.sort(plus, Collections.reverseOrder());

            for (int i = 0; i < plus.size(); i += M) {
                if (i == 0) {
                    result += plus.get(i);
                } else {
                    result += (plus.get(i) * 2);
                }
            }
        } else {
            Collections.sort(minus, Collections.reverseOrder());

            for (int i = 0; i < minus.size(); i += M) {
                if (i == 0) {
                    result += minus.get(i);
                } else {
                    result += (minus.get(i) * 2);
                }
            }
        }


        System.out.println(result);
    }
}