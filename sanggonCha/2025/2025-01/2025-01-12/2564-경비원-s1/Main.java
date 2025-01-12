import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        int w = Integer.parseInt(rc[0]);
        int h = Integer.parseInt(rc[1]);

        int n = Integer.parseInt(br.readLine());
        int[][] storeInfo = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            storeInfo[i][0] = direction;
            storeInfo[i][1] = distance;
        }

        String[] dgInfoStr = br.readLine().split(" ");
        int dgDirection = Integer.parseInt(dgInfoStr[0]);
        int dgDistance = Integer.parseInt(dgInfoStr[1]);

        // 1은 블록의 북쪽, 2는 블록의 남쪽, 3은 블록의 서쪽, 4는 블록의 동쪽
        // 북쪽(1) 또는 남쪽(2)에 위치한 경우 블록의 왼쪽 경계로부터의 거리
        // 동쪽(4) 또는 서쪽(3)에 위치한 경우 블록의 위쪽 경계로부터의 거리
        int minDistance = 0;
        switch (dgDirection) {
            case 1: // dg 북쪽
                for (int i = 0; i < n; i++) {
                    switch (storeInfo[i][0]) {
                        case 1: // 상점 북쪽
                            minDistance += Math.abs(dgDistance - storeInfo[i][1]);
                            break;
                        case 2: // 상점 남쪽
                            minDistance += h + Math.min(dgDistance + storeInfo[i][1], (w - dgDistance) + (w - storeInfo[i][1]));
                            break;
                        case 3: // 상점 서쪽
                            minDistance += dgDistance + storeInfo[i][1];
                            break;
                        case 4: // 상점 동쪽
                            minDistance += (w - dgDistance) + (w - storeInfo[i][1]);
                            break;
                        default:
                            break;
                    }
                }
                break;
            case 2: // dg 남쪽
                for (int i = 0; i < n; i++) {
                    switch (storeInfo[i][0]) {
                        case 1: // 상점 북쪽
                            minDistance += h + Math.min(dgDistance + storeInfo[i][1], (w - dgDistance) + (w - storeInfo[i][1]));
                            break;
                        case 2: // 상점 남쪽
                            minDistance += Math.abs(dgDistance - storeInfo[i][1]);
                            break;
                        case 3: // 상점 서쪽
                            minDistance += dgDistance + (h - storeInfo[i][1]);
                            break;
                        case 4: // 상점 동쪽
                            minDistance += (w - dgDistance) + (h - storeInfo[i][1]);
                            break;
                        default:
                            break;
                    }
                }
                break;
            case 3: // dg 서쪽
                for (int i = 0; i < n; i++) {
                    switch (storeInfo[i][0]) {
                        case 1: // 상점 북쪽
                            minDistance += dgDistance + storeInfo[i][1];
                            break;
                        case 2: // 상점 남쪽
                            minDistance += (w - dgDistance) + (h - storeInfo[i][1]);
                            break;
                        case 3: // 상점 서쪽
                            minDistance += Math.abs(dgDistance - storeInfo[i][1]);
                            break;
                        case 4: // 상점 동쪽
                            minDistance += w + Math.min(dgDistance + storeInfo[i][1], (h - dgDistance) + (h - storeInfo[i][1]));
                            break;
                        default:
                            break;
                    }
                }
                break;
            case 4: // dg 동쪽
                for (int i = 0; i < n; i++) {
                    switch (storeInfo[i][0]) {
                        case 1: // 상점 북쪽
                            minDistance += dgDistance + (w - storeInfo[i][1]);
                            break;
                        case 2: // 상점 남쪽
                            minDistance += (h - dgDistance) + (w - storeInfo[i][1]);
                            break;
                        case 3: // 상점 서쪽
                            minDistance += w + Math.min(dgDistance + storeInfo[i][1], (h - dgDistance) + (h - storeInfo[i][1]));
                            break;
                        case 4: // 상점 동쪽
                            minDistance += Math.abs(dgDistance - storeInfo[i][1]);
                            break;
                        default:
                            break;
                    }
                }
                break;
            default:
                break;
        }

        System.out.println(minDistance);
    }
}