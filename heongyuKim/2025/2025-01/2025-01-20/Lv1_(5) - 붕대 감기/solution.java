class Solution {
    // 시전 시간
    static int castTime;
    // 초당 회복량
    static int healthSec;
    // 추가 회복량
    static int healthMore;
    // 최대 체력
    static int maxHealth;

    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        castTime = bandage[0];
        healthSec = bandage[1];
        healthMore = bandage[2];
        maxHealth = health;

        for (int i = 0; i < attacks.length; i++) {
            // 공격과 공격 사이에 계산할 시간
            int betweenTime;

            // 체력 회복
            if (i == 0) {
                betweenTime = attacks[i][0] - 0 - 1;
                health += (betweenTime * healthSec);
                health += ((betweenTime / castTime) * healthMore);
            } else {
                betweenTime = attacks[i][0] - attacks[i - 1][0] - 1;
                health += (betweenTime * healthSec);
                health += ((betweenTime / castTime) * healthMore);
            }

            // 최대 체력보다 많으면
            if (maxHealth < health) {
                health = maxHealth;
            }

            // 몬스터의 공격만큼 깎기
            health -= attacks[i][1];

            // 남은 체력을 보고 생사 여부 확인
            if (health <= 0) {
                answer = -1;
                break;
            } else {
                answer = health;
            }
        }

        return answer;
    }
}
