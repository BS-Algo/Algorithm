// 저번에 보았던 프로그래머스 코드가 이제야 이해가 된다....
import java.io.*;
import java.util.*;

class Main {
    static class Room {
        List<User> users = new ArrayList<>();
    }

    static class User implements Comparable<User> {
        int level;
        String nickname;

        public User(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }


        @Override
        public int compareTo(User user) {
            return nickname.compareTo(user.nickname);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 게임방
        ArrayList<Room> rooms = new ArrayList<>();

        // 총인원
        int total = Integer.parseInt(st.nextToken());

        // 방의 정원
        int roomMax = Integer.parseInt(st.nextToken());

        for (int i = 0; i < total; i++) {
            StringTokenizer player = new StringTokenizer(br.readLine());

            // 방 있는지 여부
            boolean isCreate = false;

            // 레벨
            int level = Integer.parseInt(player.nextToken());

            // 닉네임
            String nickname = player.nextToken();

            for (Room room : rooms) {
                if (room.users.size() < roomMax && room.users.get(0).level - 10 <= level && level <= room.users.get(0).level + 10) {
                    isCreate = true;
                    room.users.add(new User(level, nickname));
                    break;
                }
            }

            if (!isCreate) {
                Room room = new Room();
                room.users.add(new User(level, nickname));
                rooms.add(room);
            }
        }

        for (Room room : rooms) {
            Collections.sort(room.users);

            if (room.users.size() == roomMax) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }

            for (int i = 0; i < room.users.size(); i++) {
                System.out.println(String.valueOf(room.users.get(i).level) + " " + room.users.get(i).nickname);
            }

        }
    }
}