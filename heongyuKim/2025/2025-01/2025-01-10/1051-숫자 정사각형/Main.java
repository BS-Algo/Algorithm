import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로 세로 길이 받기
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        // 직사각형 받기
        char[][] rectengle = new char[height][width];
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            rectengle[i] = line.toCharArray();
        }

        // 받은 후 탐색
        // 탐색 방법은 가로 길이와 세로 길이가 전체 직사각형을 벗어나지 않는 선에서 살펴보기
        // 0부터 탐색
        int result = 0;
        int length = 0;
        while (length < height && length < width) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    // 오른쪽
                    int right = j + length;
                    // 아래
                    int below = i + length;

                    if (right < width && below < height) {
                        if (rectengle[i][j] == rectengle[i][right] &&
                            rectengle[i][j] == rectengle[below][j] &&
                            rectengle[i][j] == rectengle[below][right]) {
                            result = length + 1;
                        }
                    }
                }
            }
            length++;
        }

        if (result == 0) {
            System.out.println(1);
        } else {
            System.out.println(result * result);
        }

    }
}