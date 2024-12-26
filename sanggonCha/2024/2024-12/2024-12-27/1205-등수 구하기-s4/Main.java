import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NScoreP = br.readLine().split(" ");
        int N = Integer.parseInt(NScoreP[0]); // 리스트에 있는 점수
        int score = Integer.parseInt(NScoreP[1]); // 태수의 점수
        int P = Integer.parseInt(NScoreP[2]); // 리스트에 올라갈 수 있는 개수

        if (N > 0) {
            String[] rankingsString = br.readLine().split(" ");
            int[] rankingList = new int[P];
            for (int i = 0; i < N; i++) {
                rankingList[i] = Integer.parseInt(rankingsString[i]);
            }

            // 리스트가 꽉 차 있는데
            if (N == P) {
                for (int i = 0; i < N; i++) {
                    // 태수의 점수가 더 크다면
                    if (score > rankingList[i]) {
                        System.out.println(i + 1);
                        break;
                        // 같은 점수룰 만났는데
                    } else if (score == rankingList[i]) {
                        // 현재 위치가 끝이라면 -1
                        if (i == N - 1) {
                            System.out.println(-1);
                            break;
                            // 끝이 아니라면 뒤에 제거할 점수가 있는지 찾아야함
                        } else {
                            for (int j = i + 1; j < N; j++) {
                                // 태수의 점수보다 낮은 점수를 찾았다면 출력하고 종료
                                if (score > rankingList[j]) {
                                    System.out.println(i + 1);
                                    break;
                                }
                                // 끝까지 확인했는데도 못 찾았다면
                                if (j == N - 1) {
                                    System.out.println(-1);
                                }
                            }
                            break;
                        }
                    } else if (i == N - 1) {
                        System.out.println(-1);
                    }
                }
            } else {
                // 리스트가 꽉 차 있지 않고
                // "i < P"(기존에 N으로 실수)를 통해서 끝까지 확인해야함
                for (int i = 0; i < P; i++) {
                    // 점수가 같거나 크다면 해당 순위에 저장
                    if (score >= rankingList[i]) {
                        System.out.println(i + 1);
                        break;
                    }
                }
            }
        } else {
            System.out.println(1);
        }
    }
}