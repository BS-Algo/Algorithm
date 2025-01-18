import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

class Solution {
    public int solution(String[] friends, String[] gifts) {
       int answer = 0;

        // 어느 정도의 선물을 받는지에 대한 해쉬 맵
        HashMap<String, Integer> receiveGifts = new HashMap<>();

        // 누구와 주고 받았는지에 대한 것을 저장할 해쉬 맵
        HashMap<String, HashMap<String, Integer>> giveAndTakeMap = new HashMap<>();

        // 선물지수를 나타낼 해쉬 맵
        HashMap<String, Integer> giftPoints = new HashMap<>();

        for (String person : friends) {
            receiveGifts.put(person, 0);
            giveAndTakeMap.putIfAbsent(person, new HashMap<>());
            giftPoints.put(person, 0);
        }

        for (String person: friends) {
            for (String other : friends) {
                if (!person.equals(other)) {
                    giveAndTakeMap.get(person).put(other, 0);
                }
            }
        }

        for (int i = 0; i < gifts.length; i++) {
            String[] relation =  gifts[i].split(" ");

            // 주는 사람
            String giver = relation[0];

            // 받는 사람
            String taker = relation[1];

            // 기존에 받은 선물 수
            giveAndTakeMap.get(giver).put(taker, giveAndTakeMap.get(giver).get(taker) + 1);

            // 선물지수 계산
            giftPoints.put(giver, giftPoints.get(giver) + 1);
            giftPoints.put(taker, giftPoints.get(taker) - 1);
        }

        for (int i = 0; i < friends.length - 1; i++) {
            String giver = friends[i];
            String taker = "";
            for (int j = i + 1; j < friends.length; j++) {
                taker = friends[j];
                if ((giveAndTakeMap.get(giver).get(taker) == 0 && giveAndTakeMap.get(taker).get(giver) == 0)  || Objects.equals(
                        giveAndTakeMap.get(giver).get(taker), giveAndTakeMap.get(taker).get(giver))) {
                    if (giftPoints.get(giver) > giftPoints.get(taker)) {
                        receiveGifts.put(giver, receiveGifts.get(giver) + 1);
                    } else if (giftPoints.get(giver) < giftPoints.get(taker)) {
                        receiveGifts.put(taker, receiveGifts.get(taker) + 1);
                    }
                } else {
                    // 두 사람 사이에 더 많은 선물을 준 사람이 선물을 하나 받는다.
                    int giverCount = giveAndTakeMap.get(giver).get(taker);
                    int takerCount = giveAndTakeMap.get(taker).get(giver);

                    if (giverCount > takerCount) {
                        receiveGifts.put(giver, receiveGifts.get(giver) + 1);
                    } else {
                        receiveGifts.put(taker, receiveGifts.get(taker) + 1);
                    }

                }
            }
        }

        answer = Collections.max(receiveGifts.values());



        return answer;
    }

}