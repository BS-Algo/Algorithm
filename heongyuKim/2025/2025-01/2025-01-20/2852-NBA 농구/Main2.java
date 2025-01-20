import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main2 {
    // 정보의 갯수
    static int infoCount;

    // 첫번째 인자는 점수 두번째 인자는 이기고 있는 순간의 처음
    static int oneTeamScore;
    static int twoTeamScore;

    // 시간 체크
    static int currentTime;
    
    // 결과로 출력할 변수
    static int oneResult;
    static int twoResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        infoCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < infoCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());

            // 시간을 초로 통일하기 위한 변환
            int time = convertSecond(st.nextToken());
            
            if (oneTeamScore > twoTeamScore) {
                oneResult += time - currentTime;
            } else if (oneTeamScore < twoTeamScore) {
                twoResult += time - currentTime;
            }

            if (team == 1) {
                oneTeamScore++;
            } else {
                twoTeamScore++;
            }


            currentTime = time;
        }

        // 마지막 부분처리 해주기
        if (oneTeamScore > twoTeamScore) {
            oneResult += 2880 - currentTime;
        } else if (oneTeamScore < twoTeamScore) {
            twoResult += 2880 - currentTime;
        }

        StringBuilder sb = new StringBuilder();
        String oneMinute = convertResult(oneResult / 60);
        String oneSecond = convertResult(oneResult % 60);
        String twoMinute = convertResult(twoResult / 60);
        String twoSecond = convertResult(twoResult % 60);

        sb.append(oneMinute).append(":").append(oneSecond).append("\n");
        sb.append(twoMinute).append(":").append(twoSecond);

        System.out.println(sb);
    }

    static int convertSecond(String time) {
        // :을 기준으로 앞과 뒤 나누기
        String[] splitTime = time.split(":");

        // 분
        int minute = Integer.parseInt(splitTime[0]);

        // 초
        int second = Integer.parseInt(splitTime[1]);

        second += 60 * minute;

        return second;
    }

    static String convertResult(int time) {
        if (time < 10) {
            return "0" + String.valueOf(time);
        } else {
            return String.valueOf(time);
        }
    }
}