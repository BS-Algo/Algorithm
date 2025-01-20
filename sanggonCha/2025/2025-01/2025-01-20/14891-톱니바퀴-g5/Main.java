import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 톱니바퀴 상태 입력 받기
        char[][] sawtooth = new char[4][8];
        for (int i = 0; i < 4; i++) {
            sawtooth[i] = br.readLine().toCharArray();
        }

        // 맞닿은 극
        int r1 = 2;
        int l2 = 6, r2 = 2;
        int l3 = 6, r3 = 2;
        int l4 = 6;

        // 회전 입력 받기
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String[] info = br.readLine().split(" ");
            int num = Integer.parseInt(info[0]); // 톱니 바퀴의 번호
            int dir = Integer.parseInt(info[1]); // 방향

            int d1 = 0, d2 = 0, d3 = 0, d4 = 0;
            
            // 회전 처리
            // 1: 시계 방향, -1: 반시계 방향
            // 1: pt--, -1: pt++
            switch (num) {
                case 1:
                    // 1번 2번의 다른 극이 접하면, 반대 방향 회전
                    if (sawtooth[0][r1] != sawtooth[1][l2]) {
                        d2 = dir;
                        // 2번과 3번의 다른 극이 접하면, 반대 방향 회전
                        if (sawtooth[1][r2] != sawtooth[2][l3]) {
                            d3 = -dir;
                            if (sawtooth[2][r3] != sawtooth[3][l4]) {
                                d4 = dir;
                            }
                        }
                    }

                    // 회전
                    r1 -= dir; // 1
                    l2 += d2; // 2
                    r2 += d2;
                    l3 += d3; // 3
                    r3 += d3;
                    l4 += d4; // 4
                    
                    break;
                    
                case 2:
                    // 1번 2번의 다른 극이 접하면, 반대 방향 회전
                    if (sawtooth[0][r1] != sawtooth[1][l2]) {
                        d1 = dir;
                    }
                    // 2번 3번의 다른 극이 접하면, 반대 방향 회전
                    if (sawtooth[1][r2] != sawtooth[2][l3]) {
                        d3 = dir;
                        if (sawtooth[2][r3] != sawtooth[3][l4]) {
                            d4 = -dir;
                        }
                    }

                    l2 -= dir; // 2
                    r2 -= dir;
                    r1 += d1; // 1
                    l3 += d3; // 3
                    r3 += d3;
                    l4 += d4; // 4
                    
                    break;
                    
                case 3:
                    // 3번 4번의 다른 극이 접하면, 반대 방향 회전
                    if (sawtooth[2][r3] != sawtooth[3][l4]) {
                        d4 = dir;
                    }
                    // 2번 3번의 다른 극이 접하면, 반대 방향 회전
                    if (sawtooth[1][r2] != sawtooth[2][l3]) {
                        d2 = dir;
                        if (sawtooth[0][r1] != sawtooth[1][l2]) {
                            d1 = -dir;
                        }
                    }

                    l3 -= dir; // 3
                    r3 -= dir;
                    r1 += d1;// 1
                    l2 += d2; // 2
                    r2 += d2;
                    l4 += d4; // 4
                    
                    break;
                case 4:
                    // 3번 4번의 다른 극이 접하면, 반대 방향 회전
                    if (sawtooth[2][r3] != sawtooth[3][l4]) {
                        d3 = dir;
                        // 2번과 3번의 다른 극이 접하면, 반대 방향 회전
                        if (sawtooth[1][r2] != sawtooth[2][l3]) {
                            d2 = -dir;
                            if (sawtooth[0][r1] != sawtooth[1][l2]) {
                                d1 = dir;
                            }
                        }
                    }

                    // 회전
                    l4 -= dir; // 4
                    l3 += d3; // 3
                    r3 += d3;
                    l2 += d2; // 2
                    r2 += d2;
                    r1 += d1; // 1
                    
                    break;
                    
                default:
                    break;
            }
            
            // 인덱스 에러 방지
            if (r1 > 7) r1 -= 8;
            if (r1 < 0) r1 += 8;
            if (l2 > 7) l2 -= 8;
            if (l2 < 0) l2 += 8;
            if (r2 > 7) r2 -= 8;
            if (r2 < 0) r2 += 8;
            if (l3 > 7) l3 -= 8;
            if (l3 < 0) l3 += 8;
            if (r3 > 7) r3 -= 8;
            if (r3 < 0) r3 += 8;
            if (l4 > 7) l4 -= 8;
            if (l4 < 0) l4 += 8;
        }

        // N극은 0, S극은 1
        int score = 0;
        if (r1 < 2) r1 += 8;
        if (sawtooth[0][r1 - 2] == '1') score += 1;

        if (r2 < 2) r2 += 8;
        if (sawtooth[1][r2 - 2] == '1') score += 2;

        if (r3 < 2) r3 += 8;
        if (sawtooth[2][r3 - 2] == '1') score += 4;

        if (l4 > 5) l4 -= 8;
        if (sawtooth[3][l4 + 2] == '1') {
            score += 8;
        }

        System.out.println(score);
    }
}