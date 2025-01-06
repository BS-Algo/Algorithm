import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        // 우선 출력할 배열 만들기
        // 넓이를 나타낼 길이
        int length = 1;

        if (cnt > 1) {
            length += (cnt - 1) * 4;
        }

        char[][] stars = new char[length][length];

        // 재귀함수를 통한 별찍기
        makeStar(stars, cnt, 0, length);

        // 출력하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
    // 재귀 함수
    static void makeStar(char[][] stars, int cnt, int start, int end) {

        if (cnt == 1) {
            stars[start][start] = '*';
            return;
        }

        // length를 줄여가면서 별을 집어넣기
        // 시작점과 끝점 설정
        for (int i = start; i < end; i++) {
            for (int j = start; j < end; j++) {
                if (i == start || i == end - 1) {
                    stars[i][j] = '*';
                } else {
                    if (j == start || j == end - 1) {
                        stars[i][j] = '*';
                    } else {
                        stars[i][j] = ' ';
                    }
                }

            }
        }

        makeStar(stars, cnt - 1, start + 2,  end -2);
    }
}
