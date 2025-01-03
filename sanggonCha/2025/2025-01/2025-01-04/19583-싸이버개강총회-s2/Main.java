import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 시간 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String[] startMeetString = st.nextToken().split(":");
        String[] endMeetString = st.nextToken().split(":");
        String[] endStreamString = st.nextToken().split(":");

        int startMeet = timeToMin(startMeetString[0], startMeetString[1]);
        int endMeet = timeToMin(endMeetString[0], endMeetString[1]);
        int endStream = timeToMin(endStreamString[0], endStreamString[1]);

        // 정답을 구하기 변수 생성
        int ans = 0;
        String line = null;
        HashSet<String> attendees = new HashSet<>();

        // 채팅 기록 입력 받기
        // while ((line = br.readLine()) != null && !line.isEmpty()) { // 개인적으로 테스트할 경우
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line, " ");
            String[] charTimeString = st.nextToken().split(":");
            String nickname = st.nextToken();

            int chatTime = timeToMin(charTimeString[0], charTimeString[1]);

            // 시간 내에 채팅을 쳤다면 기록
            if (chatTime <= startMeet) {
                // 중복을 방지할 수 있는 HashSet(집합)을 사용해서 기록
                attendees.add(nickname);
                // 퇴장 시간 내에 채팅을 쳤다면 출석표에 있는지 확인
            } else if (chatTime >= endMeet && chatTime <= endStream && attendees.contains(nickname)) {
                attendees.remove(nickname); // 중복 체크 방지를 위해 제거
                ans++; // +1
            }
        }

        System.out.println(ans);

    }

    // 시간을 분으로 변환하는 함수
    private static int timeToMin(String hourString, String minString) {
        int hour = Integer.parseInt(hourString);
        int min = Integer.parseInt(minString);
        return hour * 60 + min;
    }
}