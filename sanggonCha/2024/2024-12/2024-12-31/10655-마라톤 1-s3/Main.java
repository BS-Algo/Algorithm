import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int totalDistance = 0;
        int LongestDiff = 0;
        int[][] xy = new int[N][2];
        // 첫 번째 좌표
        String[] xyFirst = br.readLine().split(" ");
        xy[0][0] = Integer.parseInt(xyFirst[0]);
        xy[0][1] = Integer.parseInt(xyFirst[1]);

        // 두 번째 좌표
        String[] xySecond = br.readLine().split(" ");
        xy[1][0] = Integer.parseInt(xySecond[0]);
        xy[1][1] = Integer.parseInt(xySecond[1]);
        totalDistance += (Math.abs(xy[1][0] - xy[0][0]) + Math.abs(xy[1][1] - xy[0][1]));

        for (int i = 2; i < N; i++) {
            // 좌표 저장
            String[] xyStr = br.readLine().split(" ");
            xy[i][0] = Integer.parseInt(xyStr[0]);
            xy[i][1] = Integer.parseInt(xyStr[1]);
            totalDistance += (Math.abs(xy[i][0] - xy[i - 1][0]) + Math.abs(xy[i][1] - xy[i - 1][1]));

            // 최장 구간 찾기
            int continuousDistance = Math.abs(xy[i][0] - xy[i - 1][0]) + Math.abs(xy[i][1] - xy[i - 1][1]) + Math.abs(xy[i-1][0] - xy[i - 2][0]) + Math.abs(xy[i-1][1] - xy[i - 2][1]);
            int skipDistance = Math.abs(xy[i][0] - xy[i - 2][0]) + Math.abs(xy[i][1] - xy[i - 2][1]);
            if (LongestDiff < (continuousDistance - skipDistance)) {
                LongestDiff = continuousDistance - skipDistance;
            }
        }

//        System.out.println(LongestDiff);
        System.out.println(totalDistance - LongestDiff);
    }
}