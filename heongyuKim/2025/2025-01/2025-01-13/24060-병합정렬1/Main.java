import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static int[] temp;
    static int result = -1;
    static int save = 0;
    static int saveCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열의 길이와 저장 횟수를 받기
        StringTokenizer lengthAndSave = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(lengthAndSave.nextToken());
        saveCount = Integer.parseInt(lengthAndSave.nextToken());

        // 처음 주어진 수를 받을 배열 생성
        int[] arr = new int[length];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 받은 수들을 배열에 담기
        for (int i = 0; i < length; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        // 임시로 담을 배열 생성
        temp = new int[length];

        // 병합 정렬
        merge_sort(arr, 0, length - 1);

        System.out.println(result);
    }

    // 정렬
    static void merge_sort(int[] arr, int start, int end) {
        int mid;
        if (start < end) {
            mid = (start + end) / 2;
            merge_sort(arr, start, mid);
            merge_sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    // 병합
    static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int t = start;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        while (j <= end) {
            temp[t++] = arr[j++];
        }

        // 정렬된 값을 원본 배열에 복사
        for (i = start; i <= end; i++) {
            arr[i] = temp[i];
            save++;

            // K번째 저장되는 값을 찾았을 때
            if (save == saveCount) {
                result = arr[i];
                return;
            }
        }
    }
}