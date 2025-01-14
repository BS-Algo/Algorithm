import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // N 입력 받기
        int N = Integer.parseInt(br.readLine());
        String[] numsN = br.readLine().split(" ");

        Map<Integer, Integer> mapA = new HashMap<>();
        for (int i = 0; i < N; i++) {
            findDivisor(Integer.parseInt(numsN[i]), mapA);
        }

        // M 입력 받기
        int M = Integer.parseInt(br.readLine());
        String[] numsM = br.readLine().split(" ");

        Map<Integer, Integer> mapB = new HashMap<>();
        for (int i = 0; i < M; i++) {
            findDivisor(Integer.parseInt(numsM[i]), mapB);
        }

        long gcd = 1;
        boolean flag = false;
        for (int divisorA : mapA.keySet()) {
            if (mapB.containsKey(divisorA)) {
                int minCount = Math.min(mapA.get(divisorA), mapB.get(divisorA));
                // gcd *= (int) Math.pow(divisorA, minCount);
                // 반복문을 사용하는 것이 더 안전하다 -GPT-
                for (int i = 0; i < minCount; i++) {
                    gcd *= divisorA;
                    // 문제에서 9자리보다 길다면, 마지막 9자리만 출력하라고 한다
                    // 5,124,312,312 -> 124,312,312
                    // 10번 째 자리 부터는 몇을 곱하든 표시할 필요가 없기 때문에 기억할 필요가 없다
                    // 오버플로우 때문에 그런 것이다. 어쨋든 기억할 필요가 없으니 지운다.
                    if (gcd >= 1000000000) {
                        flag = true;
                        gcd %= 1000000000;
                    }
                }
            }
        }

        if (flag) {
            System.out.printf("%09d", gcd); // 나머지 자리를 0으로 채워서 출력
        } else {
            System.out.println(gcd);
        }
    }

    private static void findDivisor(int num, Map<Integer, Integer> map) {
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                num /= i;
            }
        }

        if (num != 1) { // num이 소수인 경우 처리
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }
}