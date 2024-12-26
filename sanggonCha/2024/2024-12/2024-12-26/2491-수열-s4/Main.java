import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] stringInputs = br.readLine().split(" ");
        int[] inputs = new int[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(stringInputs[i]);
        }

        int maxLength = 1; // 최대 길이는 최소 1
        // 변수를 두 개를 두어서 값이 같은 경우에 두 개를 모두 증가시켜준다
        // 1 3 3 2 2 를 생각해보면
        // 1 -> 3 -> 3: 이 경우에는 길이 3으로 증가했다고 생각할 수 있다
        // 3 -> 3 -> 2 -> 2: 이 경우에는 길이 4로 감소했다고 생각할 수 있다
        // 그러나 if 문을 통해서 딱 한 가지의 경우만 생각한다면 증가에서 감소로 바뀔 때,
        // 처음 나온 3을 최대 길이에 반영 하지 못한다
        // 그래서 3 -> 2 -> 2 만 캐치하여 길이를 3으로 생각하게 된다
        int increasingLength = 1; // 증가 구간 길이
        int decreasingLength = 1; // 감소 구간 길이

        for (int i = 1; i < N; i++) {
            // 증가
            if (inputs[i - 1] <= inputs[i]) {
                // 증가 구간 길이 증가
                increasingLength++;
            } else {
                // 증가 구간 끝
                increasingLength = 1;
            }

            // 감소
            if (inputs[i - 1] >= inputs[i]) {
                // 감소 구간 길이 증가
                decreasingLength++;
            } else {
                // 감소 구간 끝
                decreasingLength = 1;
            }

            maxLength = Math.max(maxLength, Math.max(increasingLength, decreasingLength));
        }
        System.out.println(maxLength);
    }
}