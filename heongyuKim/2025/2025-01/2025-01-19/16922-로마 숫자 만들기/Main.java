import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {
    static int romeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        romeCount = Integer.parseInt(br.readLine());

        // 계산되는 값들을 담을 집합
        Set<Integer> set = new HashSet<>();

        // 반복문을 통한 조합 구현
        for (int i = romeCount; i > -1; i--) {
            for (int j = 0; j <= romeCount - i; j++) {
                for (int q = 0; q <= romeCount - i - j; q++) {
                    set.add((1 * i) + (5 * j) + (10 *  q) + ((romeCount - i - j - q) * 50));
                }
            }
        }

        // 결과 출력
        System.out.println(set.size());

    }


}