import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int timeResult = 999999999;
    static int heightResult = 0;
    static int standardBlock = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 필요한 변수들
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        standardBlock = B;
        int sequence = 0;

        // 블록을 한줄에 받고
        int[] blocks = new int[N * M];

        for (int i = 0; i < N; i++) {
            StringTokenizer block = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                blocks[sequence] = Integer.parseInt(block.nextToken());
                sequence++;
            }
        }

        // 256 높이부터 하나씩 내려오면서 가지고 있는 블록 갯수로 가능하면 걸리는 시간과 높이를 출력하기
        for (int i = 256; i > -1; i--) {
            int calTime = 0;
            for (int j = 0; j < N * M; j++) {
                // 블록 및 시간 계산하기
                if (i > blocks[j]) {
                    calTime += Math.abs(i - (blocks[j]));
                    standardBlock -= Math.abs(i - blocks[j]);
                } else if (i < blocks[j]) {
                    calTime += 2 * (Math.abs(i - (blocks[j])));
                    standardBlock += Math.abs(i - blocks[j]);
                }
            }
            if (standardBlock >= 0) {
                if (calTime <= timeResult) {
                    if (calTime == timeResult) {
                        heightResult = Math.max(heightResult, i);
                    } else {
                        timeResult = calTime;
                        heightResult = i;
                    }
                }
            }

            standardBlock = B;
        }

        System.out.println(timeResult + " " + heightResult);
    }

}