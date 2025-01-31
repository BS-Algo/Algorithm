import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();  // 유저 ID -> 닉네임 매핑
        List<String[]> logs = new ArrayList<>();        // 최종 메시지를 저장할 리스트

        for (String entry : record) {
            String[] parts = entry.split(" ");
            String command = parts[0];
            String userId = parts[1];

            if (command.equals("Enter")) {
                String nickname = parts[2];
                userMap.put(userId, nickname);  // 유저 ID의 닉네임 업데이트
                logs.add(new String[]{userId, "님이 들어왔습니다."});
            } else if (command.equals("Leave")) {
                logs.add(new String[]{userId, "님이 나갔습니다."});
            } else if (command.equals("Change")) {
                String nickname = parts[2];
                userMap.put(userId, nickname);  // 닉네임 변경
            }
        }

        // 최종적으로 메시지를 닉네임을 반영해서 변환
        String[] result = new String[logs.size()];
        for (int i = 0; i < logs.size(); i++) {
            String userId = logs.get(i)[0];
            String message = logs.get(i)[1];
            result[i] = userMap.get(userId) + message;
        }

        return result;
    }
}
