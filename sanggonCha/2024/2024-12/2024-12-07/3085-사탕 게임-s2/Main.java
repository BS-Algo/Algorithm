import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n 입력 받기
        int n = Integer.parseInt(br.readLine());

        // 크기가 n인 배열 생성
        char[][] arr = new char[n][n];

        // n줄 입력 받아서 배열에 저장
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        // 델타 정의
        int[] dx = {1, 0};
        int[] dy = {0, 1};

        // 초기 최장 길이 계산
        int maxLength = calculateLength(arr, n);

        // 델타 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    // 새로운 좌표 생성
                    int ni = i + dx[k];
                    int nj = j + dy[k];

                    if (ni >= 0 && ni < n && nj >= 0 && nj < n && arr[i][j] != arr[ni][nj]) {
                        // 교환
                        char temp = arr[i][j];
                        arr[i][j] = arr[ni][nj];
                        arr[ni][nj] = temp;

                        // 최장 길이 탐색 함수
                        maxLength = Math.max(calculateLength(arr, n), maxLength);

                        // 복구
                        arr[ni][nj] = arr[i][j];
                        arr[i][j] = temp;
                    }
                }
            }
        }

        System.out.println(maxLength);
    }

    public static int calculateLength(char[][] arr, int n) {
        int maxLength = 1;

        // 각 행을 탐색
        for (int i = 0; i < n; i++) {
            int length = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    length++;
                    maxLength = Math.max(length, maxLength);
                } else {
                    length = 1;
                }
            }
        }

        // 각 열을 탐색
        for (int j = 0; j < n; j++) {
            int length = 1;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i][j] == arr[i+1][j]) {
                    length++;
                    maxLength = Math.max(length, maxLength);
                } else {
                    length = 1;
                }
            }
        }

        return maxLength;
    }
}   