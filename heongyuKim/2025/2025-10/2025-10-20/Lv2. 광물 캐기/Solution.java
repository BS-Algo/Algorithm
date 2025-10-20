import java.util.*;

class Solution {

    static List<Mineral> list = new ArrayList<>();

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        // 총 곡괭이 수에 맞춰 결과를 계산해야 함.
        int totalPicks = 0;

        totalPicks += picks[0];
        totalPicks += picks[1];
        totalPicks += picks[2];


        // 광물을 5개씩 묶어서 피로도를 곡괭이 별로 처리
        for (int i = 0; i < minerals.length; i += 5) {

            if (totalPicks == 0) {
                break;
            }

            int dia = 0;
            int iron = 0;
            int stone = 0;

            for (int j = i; j < i + 5; j++) {
                if (j == minerals.length) {
                    break;
                }

                if (minerals[j].equals("diamond")) {
                    dia += 1;
                    iron += 5;
                    stone += 25;
                } else if (minerals[j].equals("iron")) {
                    dia += 1;
                    iron += 1;
                    stone += 5;
                } else {
                    dia += 1;
                    iron += 1;
                    stone += 1;
                }
            }

            list.add(new Mineral(dia, iron, stone));
            totalPicks--;
        }

        list.sort((o1, o2) -> (o2.stone - o1.stone));

        for (Mineral m : list) {
            int diamond = m.diamond;
            int iron = m.iron;
            int stone = m.stone;

            if (picks[0] > 0) {
                answer += diamond;
                picks[0]--;
                continue;
            }

            if (picks[1] > 0) {
                answer += iron;
                picks[1]--;
                continue;
            }

            if (picks[2] > 0) {
                answer += stone;
                picks[2]--;
                continue;
            }

        }

        return answer;
    }

    class Mineral {
        private int diamond;
        private int iron;
        private int stone;

        public Mineral(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }
}