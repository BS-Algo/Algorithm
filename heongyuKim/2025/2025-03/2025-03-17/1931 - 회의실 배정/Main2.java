import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 이중 배열로 푸는 방법
class Main2 {
    
    // 회의 시간을 담을 배열
    static int[][] times;

    // 결과로 출력할 변수
    static int result = 0;

    // 현재 시작시간
    static int startTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 회의실의 갯수
        int N = Integer.parseInt(br.readLine());
        times = new int[N][2];

        // 회의 시간을 큐에 넣기
        for (int i = 0; i < N; i++) {
            StringTokenizer time = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(time.nextToken());
            times[i][1] = Integer.parseInt(time.nextToken());
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < N; i++) {
            if (startTime <= times[i][0]) {
                startTime = times[i][1];
                result++;
            }
        }

        System.out.println(result);
    }
}