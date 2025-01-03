import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 시간 정보 입력 받기
        String[] times = br.readLine().split(" ");
        String startMeet = times[0]; // 개강총회 시작 시간
        String endMeet = times[1];   // 개강총회 종료 시간
        String endStream = times[2]; // 스트리밍 종료 시간

        // 출석 확인을 위한 자료구조
        // 왼쪽에는 Set, 오른쪽에는 HashSet, 왜?
        // 정해진 규칙 같은 거..
        // Set은 인터페이스이기 때문에 다양한 구현체 중 하나로 바꿀 수 있다
        // HashSet은 Set을 구현한 클래스이기 때문에, 실질적으로 데이터를 저장하는 역할을 한다.
        // 인터페이스이기 때문에 HashSet말고 TreeSet도 사용할 수 있다!
        Set<String> attendeesBefore = new HashSet<>();  // 입장 확인용
        Set<String> attendeesAfter = new HashSet<>();   // 퇴장 확인용
        Set<String> attendeesAll = new HashSet<>();     // 모든 참가자 기록

        String line = null;

        // 채팅 기록 입력 받기
        while ((line = br.readLine()) != null) {
            // StringTokenizer를 사용하면 split 보다 성능이 더 좋다
            // BOJ에 제출해서 확인해본 결과, 600 -> 496ms 까지 시간이 감소했다.
            StringTokenizer st = new StringTokenizer(line);
            String chatTime = st.nextToken(); // 채팅 시간
            String nickname = st.nextToken(); // 사용자 닉네임

            attendeesAll.add(nickname); // 모든 사용자 저장

            // 입장 시간 기준 체크
            // String.compareTo()
            // HH:MM 형식에서는 시간과 분이 두 자리로 고정되어 있기 때문에,
            // compareTo() 메소드를 사용할 수 있다
            //      "22:00".compareTo("22:30") -> 음수를 반환 = 22:00 이 22:30 보다 앞선다는 의미
            // 채팅 시간이 시작 시간과 같거나 이전이라면
            if (chatTime.compareTo(startMeet) <= 0) {
                attendeesBefore.add(nickname);
            }
            // 퇴장 시간 기준 체크
            // 채팅 시간이 개강총회 종료 시간과 같거나 이후이고, 종료시간과 같거나 이전이라면
            else if (chatTime.compareTo(endMeet) >= 0 && chatTime.compareTo(endStream) <= 0) {
                attendeesAfter.add(nickname);
            }
        }

        // 입장 + 퇴장 모두 확인된 사용자 카운트
        int ans = 0;
        for (String nickname : attendeesAll) {
            if (attendeesBefore.contains(nickname) && attendeesAfter.contains(nickname)) {
                ans++;
            }
        }

        // 정답 출력
        System.out.println(ans);
    }
}