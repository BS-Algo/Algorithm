import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 순열의 크기 N을 입력받음
        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n]; // 순열을 저장할 배열

        // 두 번째 줄에서 순열을 입력받아 배열에 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        // 이전 순열이 존재하면 출력, 없으면 -1 출력
        if (prevPermutation(numArr)) {
            for (int i = 0; i < n; i++) {
                System.out.print(numArr[i] + (i < n - 1 ? " " : ""));
            }
        } else {
            System.out.println(-1);
        }
    }

    // 이전 순열을 구하는 함수
    public static boolean prevPermutation(int[] numArr) {
        int n = numArr.length;

        // Step 1: 뒤에서부터 탐색하여 첫 번째로 numArr[i] > numArr[i+1]인 i를 찾음
        int i = n - 2;
        while (i >= 0 && numArr[i] <= numArr[i + 1]) {
            i--;
        }

        // i가 음수라면 이미 사전순으로 가장 작은 순열임
        if (i < 0) return false;

        // Step 2: 다시 뒤에서부터 탐색하여 numArr[j] < numArr[i]인 j를 찾음
        int j = n - 1;
        while (numArr[j] >= numArr[i]) {
            j--;
        }

        // Step 3: numArr[i]와 numArr[j]를 교환
        swap(numArr, i, j);

        // Step 4: i+1부터 끝까지의 배열을 뒤집어 내림차순 정렬
        reverse(numArr, i + 1, n - 1);

        return true; // 이전 순열을 성공적으로 생성했음을 반환
    }

    // 배열에서 두 요소를 교환하는 함수
    public static void swap(int[] numArr, int i, int j) {
        int temp = numArr[i];
        numArr[i] = numArr[j];
        numArr[j] = temp;
    }

    // 배열의 특정 구간을 뒤집는 함수
    public static void reverse(int[] numArr, int start, int end) {
        while (start < end) {
            swap(numArr, start++, end--);
        }
    }
}
