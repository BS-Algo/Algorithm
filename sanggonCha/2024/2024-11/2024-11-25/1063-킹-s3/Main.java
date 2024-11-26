import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        String stone = st.nextToken();

        int kingC = king.charAt(0) - 64;
        int kingR = Integer.parseInt(String.valueOf(king.charAt(1)));

        int stoneC = stone.charAt(0) - 64;
        int stoneR = Integer.parseInt(String.valueOf(stone.charAt(1)));

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            switch (s) {
                case "R":

                    // 킹을 돌이 있는 위치로 움직여야 한다면
                    if (kingC + 1 == stoneC && kingR == stoneR) {
                        // 돌이 체스판을 벗어나지 않는다면
                        if (stoneC + 1 <= 8) {
                            // 돌과 체스판을 같이 이동
                            stoneC += 1;
                            kingC += 1;
                        }
                        // 킹 혼자 움직인다면
                    } else {
                        // 킹이 체스판을 벗어나지 않는다면
                        if (kingC + 1 <= 8) {
                            // 킹만 이동
                            kingC += 1;
                        }
                    }

                    break;

                case "L":

                    // 킹을 돌이 있는 위치로 움직여야 한다면
                    if (kingC - 1 == stoneC && kingR == stoneR) {
                        // 돌이 체스판을 벗어나지 않는다면
                        if (stoneC - 1 >= 1) {
                            // 돌과 체스판을 같이 이동
                            stoneC -= 1;
                            kingC -= 1;
                        }
                        // 킹 혼자 움직인다면
                    } else {
                        // 킹이 체스판을 벗어나지 않는다면
                        if (kingC - 1 >= 1) {
                            // 킹만 이동
                            kingC -= 1;
                        }
                    }
                    break;

                case "B":
                    // 킹을 돌이 있는 위치로 움직여야 한다면
                    if (kingR - 1 == stoneR && kingC == stoneC) {
                        if (stoneR - 1 >= 1) {
                            // 돌과 체스판을 같이 이동
                            stoneR -= 1;
                            kingR -= 1;
                        }
                        // 킹 혼자 움직인다면
                    } else {
                        // 킹이 체스판을 벗어나지 않는다면
                        if (kingR - 1 >= 1) {
                            // 킹만 이동
                            kingR -= 1;
                        }
                    }
                    break;

                case "T":
                    // 킹을 돌이 있는 위치로 움직여야 한다면
                    if (kingR + 1 == stoneR && kingC == stoneC) {
                        if (stoneR + 1 <= 8) {
                            // 돌과 체스판을 같이 이동
                            stoneR += 1;
                            kingR += 1;
                        }
                        // 킹 혼자 움직인다면
                    } else {
                        // 킹이 체스판을 벗어나지 않는다면
                        if (kingR + 1 <= 8) {
                            // 킹만 이동
                            kingR += 1;
                        }
                    }
                    break;

                case "RT":
                    // 킹을 돌이 있는 위치로 움직여야 한다면
                    if (kingR + 1 == stoneR && kingC + 1 == stoneC) {
                        if (stoneR + 1 <= 8 && stoneC + 1 <= 8) {
                            // 돌과 체스판을 같이 이동
                            stoneR += 1;
                            stoneC += 1;
                            kingR += 1;
                            kingC += 1;
                        }
                        // 킹 혼자 움직인다면
                    } else {
                        // 킹이 체스판을 벗어나지 않는다면
                        if (kingR + 1 <= 8 && kingC + 1 <= 8) {
                            // 킹만 이동
                            kingR += 1;
                            kingC += 1;
                        }
                    }
                    break;

                case "LT":
                    // 킹을 돌이 있는 위치로 움직여야 한다면
                    if (kingR + 1 == stoneR && kingC - 1 == stoneC) {
                        if (stoneR + 1 <= 8 && stoneC - 1 >= 1) {
                            // 돌과 체스판을 같이 이동
                            stoneR += 1;
                            stoneC -= 1;
                            kingR += 1;
                            kingC -= 1;
                        }
                        // 킹 혼자 움직인다면
                    } else {
                        // 킹이 체스판을 벗어나지 않는다면
                        if (kingR + 1 <= 8 && kingC - 1 >= 1) {
                            // 킹만 이동
                            kingR += 1;
                            kingC -= 1;
                        }
                    }
                    break;

                case "RB":
                    // 킹을 돌이 있는 위치로 움직여야 한다면
                    if (kingR - 1 == stoneR && kingC + 1 == stoneC) {
                        if (stoneR - 1 >= 1 && stoneC + 1 <= 8) {
                            // 돌과 체스판을 같이 이동
                            stoneR -= 1;
                            stoneC += 1;
                            kingR -= 1;
                            kingC += 1;
                        }
                        // 킹 혼자 움직인다면
                    } else {
                        // 킹이 체스판을 벗어나지 않는다면
                        if (kingR - 1 >= 1 && kingC + 1 <= 8) {
                            // 킹만 이동
                            kingR -= 1;
                            kingC += 1;
                        }
                    }
                    break;

                case "LB":
                    // 킹을 돌이 있는 위치로 움직여야 한다면
                    if (kingR - 1 == stoneR && kingC - 1 == stoneC) {
                        // 돌이 체스판을 벗어나지 않는다면
                        if (stoneR - 1 >= 1 && stoneC - 1 >= 1) {
                            // 돌과 체스판을 같이 이동
                            stoneR -= 1;
                            stoneC -= 1;
                            kingR -= 1;
                            kingC -= 1;
                        }
                        // 킹 혼자 움직인다면
                    } else {
                        // 킹이 체스판을 벗어나지 않는다면
                        if (kingR - 1 >= 1 && kingC - 1 >= 1) {
                            // 킹만 이동
                            kingR -= 1;
                            kingC -= 1;
                        }
                    }
                    break;

                default:
                    break;
            }
        }

        System.out.println((char) (kingC + 64) + String.valueOf(kingR));
        System.out.println((char) (stoneC + 64) + String.valueOf(stoneR));

    }
}