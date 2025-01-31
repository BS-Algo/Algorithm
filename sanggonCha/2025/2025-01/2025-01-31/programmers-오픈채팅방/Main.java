import java.util.*;

// solution
// 1. 로그를 분석해서 변경된 회원 정보를 추적(hashmap에 저장) 및 userId를 통해서 채팅방 로그 저장
// 2. 저장된 로그에서 userId를 통해서 userName을 추출해서 결국에는 변경된 유저명으로 결과값을 생성

class Solution {
    public String[] solution(String[] records) {
        Map<String, String> userInfoMap = new HashMap<>(); // 회원 정보를 저장
        List<String[]> logList = new ArrayList<>(); // 초기의 로그를 기록


        // 1. 로그를 분석해서 변경된 회원 정보를 추적(hashmap에 저장) 및 채팅방 로그 저장
        for (String record : records) {
            String[] info = record.split(" ");
            String command = info[0];

            if (command.equals("Enter")) { // 1-1. 유저 정보를 기록 및 로그에 추가
                String userId = info[1];
                String userName = info[2];
                userInfoMap.put(userId, userName); // 회원 정보 저장
                // 문자열 리스트로 저장 -> 후에 userId만 따로 추출을 위해서!
                logList.add(new String[]{userId, "님이 들어왔습니다."}); // 로그에 추가

            } else if (command.equals("Leave")) { // 1-2. 로그에 추가
                String userId = info[1];
                logList.add(new String[]{userId, "님이 나갔습니다."});

            } else if (command.equals("Change")) { // 1-3. 회원정보 갱신
                String userId = info[1];
                String userName = info[2];
                userInfoMap.put(userId, userName); // 갱신
            }
        }


        // 2. 저장된 로그에서 userId를 통해서 userName을 추출해서 결국에는 변경된 유저명으로 결과값을 생성
        String[] answer = new String[logList.size()]; // 자바의 배열은 C언어처럼 동적 할당이 안 되니까, 미리 log의 사이즈 만큼 생성

        for (int i = 0; i < logList.size(); i++) {
            String userId = logList.get(i)[0]; // ArrayList에서는 .get(index)를 사용해서 개별 추출 가능
            String message = logList.get(i)[1]; // 메세지 추출

            String userName = userInfoMap.get(userId); // 최종 변경된 유저 네임을 추출

            answer[i] = userName + message;
        }

        return answer;
    }
}