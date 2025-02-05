import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

    // 개강총회를 시작한 시간
    static int startTime;

    // 개강총회를 끝낸 시간
    static int endTime;

    // 개강총회 스트리밍을 끝낸 시간
    static int streamingEndTime;

    // 확인용 hashmap
    static HashMap<String, Integer> checkMap = new HashMap<>();

    // 결과
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 분으로 통일
        String[] start = st.nextToken().split(":");
        String[] end = st.nextToken().split(":");
        String[] streamingEnd = st.nextToken().split(":");

        startTime = (Integer.parseInt(start[0]) * 60) + Integer.parseInt(start[1]);
        endTime = (Integer.parseInt(end[0]) * 60) + Integer.parseInt(end[1]);
        streamingEndTime = (Integer.parseInt(streamingEnd[0]) * 60) + Integer.parseInt(streamingEnd[1]);

        // 반복문으로 돌면서 저장과 체크를 한번에 하기 2중 for문으로 하게 된다면 채팅 기록이 최대 10만개 이므로
        // 100000 * 100000 = 10,000,000,000이므로 시간제한인 1초를 넘게 되므로 해결이 불가능하기 때문에
        // 1중 for문으로 저장과 체크를 한번에 한다.
        String info;
        while ((info = br.readLine()) != null) {
            // 언제 끝내야 하는 것에 대한 변수를 주지 않았으므로 빈값이 들어오면 break
            if (info.trim().isEmpty()) {
                break;
            }

            StringTokenizer infoToken = new StringTokenizer(info);

            // 시간과 닉네임 받기
            String[] time = infoToken.nextToken().split(":");
            int currentMinutes = (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);
            String nickname = infoToken.nextToken();

            if (currentMinutes <= startTime) {
                checkMap.put(nickname, 0);
            } else if (endTime <= currentMinutes && currentMinutes <= streamingEndTime) {
                // 중복되게 체크하면 안되므로 체크하자마자 제거하기
                if (checkMap.containsKey(nickname)) {
                    result++;
                    checkMap.remove(nickname);
                }
            }
        }
        System.out.println(result);

    }
}