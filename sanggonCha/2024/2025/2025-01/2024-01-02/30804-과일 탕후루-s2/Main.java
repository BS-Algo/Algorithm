import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tanghulu = new int[N];
        for (int i = 0; i < N; i++) tanghulu[i] = Integer.parseInt(st.nextToken());

        solve(tanghulu, N);
    }

    private static int countFruit(int[] fruitList) {
        int count = 0;
        for (int i = 1; i < 10; i++) if (fruitList[i] > 0) count++;
//        for (int i = 1; i < 10; i++) System.out.print(fruitList[i]);
        return count;
    }

    private static void solve(int[] tanghulu, int N) {
        int maxLength = 0;
        int left = 0, right = 0;
        int[] fruitList = new int[10]; // 과일의 종류는 1 ~ 9

        while (right < N) {
            // 현재의 과일을 기록하고, 오른쪽 포인터를 증가
            fruitList[tanghulu[right++]]++;
            
            // 과일의 종류가 두 종류 이상이면
            //      왼쪽 포인터 과일을 과일 리스트에서 1개 삭제하고
            //      왼쪽 포인터를 증가
            if (countFruit(fruitList) > 2) fruitList[tanghulu[left++]]--;
            maxLength = Math.max(maxLength, right - left);
//            System.out.printf(" %d - %d = %d\n", right, left, maxLength);
        }
        System.out.println(maxLength);
    }
}