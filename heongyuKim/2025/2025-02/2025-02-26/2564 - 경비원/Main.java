import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    // 가로의 길이
    static int width;

    // 세로의 길이
    static int height;

    // 상점의 수
    static int shopCount;

    // 동근의 위치 - 방향 거리
    static int dongDirection;
    static int dongDistance;

    // 상점의 방향과 거리를 저장할 배열
    static int[] shopDirection;
    static int[] shopDistance;

    // 결과
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer length = new StringTokenizer(br.readLine());
        // 가로 세로 받기
        width = Integer.parseInt(length.nextToken());
        height = Integer.parseInt(length.nextToken());

        // 상점의 수 받기
        shopCount = Integer.parseInt(br.readLine());

        // 상점 배열 생성
        shopDirection = new int[shopCount];
        shopDistance = new int[shopCount];

        // 상점 정보를 넣기
        for (int i = 0; i < shopCount; i++) {
            StringTokenizer shopInfo = new StringTokenizer(br.readLine());
            shopDirection[i] = Integer.parseInt(shopInfo.nextToken());
            shopDistance[i] = Integer.parseInt(shopInfo.nextToken());
        }

        // 동근의 위치 받기
        StringTokenizer dongInfo = new StringTokenizer(br.readLine());
        dongDirection = Integer.parseInt(dongInfo.nextToken());
        dongDistance = Integer.parseInt(dongInfo.nextToken());

        // 위치를 받은 후 계산하기
        for (int i = 0; i < shopCount; i++) {
            int direction = shopDirection[i];
            int distance = shopDistance[i];

            if (direction == dongDirection) {
                result += Math.abs(dongDistance - distance);
            } else {
                switch (dongDirection) {
                    case 1:
                        if (direction == 2) {
                            int one = height + distance + dongDistance;
                            int other = height + (width - dongDistance) + (width - distance);
                            result += Math.min(one, other);

                        } else if (direction == 3) {
                            result += dongDistance + distance;

                        } else {
                            result += (width - dongDistance) + distance;
                        }
                        break;

                    case 2:
                        if (direction == 1) {
                            int one = height + dongDistance + distance;
                            int other = height + (width - dongDistance) + (width - distance);
                            result += Math.min(one, other);

                        } else if (direction == 3) {
                            result += dongDistance + (height - distance);
                        } else {
                            result += (width - dongDistance) + (height - distance);
                        }
                        break;

                    case 3:
                        if (direction == 1) {
                            result += dongDistance + distance;
                        } else if (direction == 2) {
                            result += (height - dongDistance) + distance;
                        } else {
                            int one = width + dongDistance + distance;
                            int other = width + (height - dongDistance) + (height - distance);
                            result += Math.min(one, other);
                        }
                        break;
                    case 4:
                        if (direction == 1) {
                            result += dongDistance + (width - distance);
                        } else if (direction == 2) {
                            result += (height - dongDistance) + (width - distance);
                        } else {
                            int one = width + dongDistance + distance;
                            int other = width + (height - dongDistance) + (height - distance);
                            result += Math.min(one, other);
                        }
                        break;
                }
            }
        }

        System.out.println(result);
    }
}