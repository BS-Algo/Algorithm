import java.io.*;
import java.util.*;

class Main {
    
    // 방
    static LinkedHashMap<String, String> gameRoom = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 총인원
        int total = Integer.parseInt(st.nextToken());

        // 방의 정원
        int roomMax = Integer.parseInt(st.nextToken());

        for (int i = 0; i < total; i++) {
            StringTokenizer player = new StringTokenizer(br.readLine());
            
            // 방 있는지 여부
            boolean isCreate = false;

            // 방이 있을때의 방 번호
            String roomName = "";

            // 레벨
            int level = Integer.parseInt(player.nextToken());

            // 닉네임
            String nickname = player.nextToken();

            // 레벨 기준으로 +- 10인 방 찾기
            for (String room : gameRoom.keySet()) {
                String[] roomInfo = room.split("의");
                String[] roomPeople = gameRoom.get(room).split(":");

                if (Integer.parseInt(roomInfo[1]) - 10 <= level && level <= Integer.parseInt(roomInfo[1]) + 10 && roomPeople.length < roomMax) {
                    isCreate = true;
                    roomName = room;
                    break;
                }
            }

            // 있으면
            if (isCreate) {
                gameRoom.replace(roomName, gameRoom.get(roomName) + ":" + level + " " + nickname);

            } else {
                gameRoom.put(String.valueOf(nickname) + "의" + String.valueOf(level), level + " " + nickname);
            }
        }

        // 방에 있는 인원들을 닉네임 순으로 정렬시키고 출력하기
        for (String room : gameRoom.keySet()) {
            ArrayList<String[]> printUsers = new ArrayList<>();

            String[] users = gameRoom.get(room).split(":");

            if (users.length == roomMax) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }

            for (String user : users) {
                String[] splitUser = user.split(" ");
                printUsers.add(new String[]{splitUser[0], splitUser[1]});
            }

            Collections.sort(printUsers, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return o1[1].compareTo(o2[1]);
                }
            });

            for (String[] user: printUsers) {
                System.out.println(user[0] + " " + user[1]);
            }

        }

    }
}