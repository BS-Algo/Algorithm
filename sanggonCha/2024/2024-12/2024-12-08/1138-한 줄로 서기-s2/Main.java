import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] ans = new int[n]; // 0으로 초기화

        for (int i = 0; i < n; i++) {
            int count = arr[i];
            for (int j = 0; j < n; j++) {
                if (ans[j] == 0) { // 비어 있는 값이라면 본인보다 큰 값이 와야할 위치
                    if (count == 0) { // 더 이상 앞에 큰 사람이 없다면
                        ans[j] = i + 1; // 현재 위치에 대입
                        break;
                    }
                    count--; // 앞에 큰 사람이 존재한다면 count--
                }
                // 이미 값이 존재한다면 본인 보다 이전에 채워진 값이다 -> 본인보다 작은 값이므로 connt--를 하지 않는다.
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}