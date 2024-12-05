import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String input = br.readLine();
        String[] parts = input.split(" ");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);

        func1(n, k);
    }

    static void func1(int n, int k) {
        boolean[] isRemoved = new boolean[n + 1]; // 숫자가 제거되었는지 여부
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (isRemoved[i]) continue; // 이미 제거된 경우 넘어감

            for (int j = i; j <= n; j += i) {
                if (!isRemoved[j]) { // 아직 제거되지 않은 숫자라면
                    isRemoved[j] = true;
                    count++;

                    if (count == k) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
    }
}
