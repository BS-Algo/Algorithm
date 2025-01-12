import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        // 배열 생성
        int[] arr = new int[count];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열에 값 넣기
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 규칙성 발견으로 풀기
        // 기준이 되는 인덱스
        int flagIdx = 0;
        int changeIdx = 0;

        // 규칙성은 역순으로 수들을 보면선 순서쌍 ex) (3, 2)와 같이 앞에 것이 더 큰 것을 찾기
        for (int i = count - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                flagIdx = i - 1;
                break;
            }
        }

        // 만약 배열의 길이가 1이라면 -1 출력
        if (count == 1) {
            System.out.println(-1);
            return;
        }

        // 만약 모두 오름차순일 경우 -1 출력
        if (flagIdx == 0 && arr[flagIdx] < arr[flagIdx + 1]) {
            System.out.println(-1);
            return;
        }

        // 찾은 다음 찾은 수를 기준으로 뒤에서부터 작은 값을 찾는다.
        for (int i = count - 1; i > flagIdx; i--) {
            if (arr[flagIdx] > arr[i]) {
                // 바꿀 값의 위치 찾기
                changeIdx = i;
                break;
            }
        }

        // 값을 바꾸고
        swap(arr, flagIdx, changeIdx);
        // 바꾼 부분의 뒷부분부터 끝까지 뒤집기
        reverse(arr, flagIdx + 1, count - 1);

        for (int num : arr) {
            System.out.print(num +  " ");
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

}