#include <string>
#include <vector>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    // attacks의 배열이 끝날때까지 공격
    // 끝에까지 갔을때 플레이어의 체력이 0 초과라면 체력 을리턴,0이하면 -1을 리턴
    // attacks[-1][0]에 있는 공격이 마지막공격이 이루어지는 시점
    int last_atk = attacks.back()[0];
    int pull_health = health;
    // 현재 시간
    int sec = 0;
    // 연속 성공 숫자
    int cnt = 0;
    int idx = 0;
    for (int sec = 1; sec <= last_atk; sec++) {
        // 공격 시간
        if (idx < attacks.size() && sec == attacks[idx][0]) {
            health -= attacks[idx][1];
            if (health <= 0) return -1; // 사망
            cnt = 0; // 연속 성공 초기화
            idx++;
        } 
        else {
            // 회복
            health += bandage[1];
            cnt++;

            if (cnt == bandage[0]) {
                health += bandage[2]; // 추가 회복
                cnt = 0;
            }
            health = min(health, pull_health); // 최대 체력 제한
        }
    }

    return health > 0 ? health : -1;
}