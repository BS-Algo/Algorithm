import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            char[] word = br.readLine().toCharArray();
            if (nextPermutation(word)) {
                sb.append(new String(word)).append("\n");
            } else {
                // 마지막 단어인 경우 그대로 출력
                sb.append(new String(word)).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    // 다음 순열을 찾는 함수
    public static boolean nextPermutation(char[] word) {
        int n = word.length;

        // 1. 뒤에서부터 감소하는 첫 번째 지점 찾기
        int i = n - 2;
        while (i >= 0 && word[i] >= word[i + 1]) {
            i--;
        }

        // 마지막 순열인 경우
        if (i < 0) return false;

        // 2. i보다 뒤에서 word[i]보다 큰 값을 가진 마지막 인덱스 찾기
        int j = n - 1;
        while (word[j] <= word[i]) {
            j--;
        }

        // 3. i와 j 스왑
        swap(word, i, j);

        // 4. i 이후의 부분을 오름차순으로 정렬
        reverse(word, i + 1, n - 1);

        return true;
    }

    // 배열 두 요소 스왑
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 배열을 뒤집는 함수
    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
