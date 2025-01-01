import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 입력 순서대로 저장
        LinkedHashMap<String, Integer> inCar = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) inCar.put(br.readLine(), i);

        // 나온 순서를 저장
        int[] outCar = new int[N];
        for (int i = 0; i < N; i++) outCar[i] = inCar.get(br.readLine());

        int overTaking = 0;
        // 뒤에 본인보다 낮은 순번이 있다면 추월한 것
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (outCar[i] > outCar[j]) {
                    overTaking++;
                    break; // 중요!!
                }
            }
        }

        System.out.println(overTaking);
    }
}