import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int GAME_TIME = 48 * 60;
        int n = Integer.parseInt(br.readLine());

        // 농구 경기는 정확히 48분동안 진행

        int beforeTime = 0;
        int[] teamScore = new int[2];
        int[] teamLeadTime = new int[2];

        // N개의 줄에 득점 정보
        for (int i = 0; i < n; i++) {
            String[] goalInfo = br.readLine().split("[ :]+");
            int team = Integer.parseInt(goalInfo[0]) - 1;
            int goalMinutes = Integer.parseInt(goalInfo[1]);
            int goalSeconds = Integer.parseInt(goalInfo[2]);
            int nowTime = 60 * goalMinutes + goalSeconds;

            // 팀 넘버를 보고 이전 시간과 비교해서 리드 시간을 추가
            int timeDiff = nowTime - beforeTime;


            // 골이 들어갔다면, 현재시간까지 이기고 있었던 팀의 리드 시간을 추가
            if (teamScore[0] > teamScore[1]) {
                teamLeadTime[0] += (timeDiff);
            } else if (teamScore[0] < teamScore[1]) {
                teamLeadTime[1] += (timeDiff);
            }

            teamScore[team]++;

            if (i == n - 1) {
                if (teamScore[0] > teamScore[1]) {
                    teamLeadTime[0] += GAME_TIME - nowTime;
                } else if (teamScore[0] < teamScore[1]) {
                    teamLeadTime[1] += GAME_TIME - nowTime;
                }
            }


            beforeTime = nowTime;
        }
        System.out.printf("%02d:%02d\n", teamLeadTime[0] / 60, teamLeadTime[0] % 60);
        System.out.printf("%02d:%02d\n", teamLeadTime[1] / 60, teamLeadTime[1] % 60);
    }
}