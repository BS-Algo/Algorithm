import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }

        // dp 리스트 생성
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        // 초기값 설정
        for (int i = 1; i <= 8; i++) {
            int num = N;
            for (int j = 1; j < i; j++) {
                num = num * 10 + N;
            }
            dp.get(i).add(num);
            if (num == number)
                return i;
        }

        // dp
        for (int times = 2; times <= 8; times++) {
            for (int times1 = 1; times1 < times; times1++) {
                for (int num1 : dp.get(times1)) {
                    int times2 = times - times1;

                    for (int num2 : dp.get(times2)) {
                        // 덧셈
                        if (num1 + num2 == number)
                            return times;
                        dp.get(times).add(num1 + num2);

                        // 뺄셈
                        if (num1 - num2 == number)
                            return times;
                        dp.get(times).add(num1 - num2);

                        if (num2 - num1 == number)
                            return times;
                        dp.get(times).add(num2 - num1);

                        // 곱셈
                        if (num1 * num2 == number)
                            return times;
                        dp.get(times).add(num1 * num2);

                        // 나눗셈
                        if (num1 != 0) {
                            if ((int) num2 / num1 == number)
                                return times;
                            dp.get(times).add((int) num2 / num1);
                        }

                        if (num2 != 0) {
                            if ((int) num1 / num2 == number)
                                return times;
                            dp.get(times).add((int) num1 / num2);
                        }
                    }
                }
            }
        }

        return -1;
    }
}