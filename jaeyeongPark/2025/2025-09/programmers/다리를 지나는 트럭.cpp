#include <string>
#include <vector>
#include <queue>

using namespace std;
// 트럭 여러대가 가지는 곳, 다리 길이 -> 차 대수, 걸리는 초?
int solution(int bridge_length, int weight, vector<int> truck_weights) {
    // 큐를 만들어서 선입선출
    queue<pair<int,int>> bridge;
    int time = 0;
    int sum_w = 0;
    
    int i = 0;
    
    while(i<truck_weights.size() || !bridge.empty()){
        time++;
        
        // 다리 위 트럭 이동 → 남은 거리 감소
        queue<pair<int,int>> tmp;
        while(!bridge.empty()) {
            auto p = bridge.front();
            bridge.pop();
            p.second--;        // 1칸 이동
            if(p.second > 0) {
                tmp.push(p);   // 아직 다리 위에 남은 트럭
            } else {
                sum_w -= p.first; // 다리 건넌 트럭 무게 제거
            }
        }
        bridge = tmp;

        // 2. 새 트럭 올리기
        if(i < truck_weights.size() && sum_w + truck_weights[i] <= weight) {
            bridge.push({truck_weights[i], bridge_length});
            sum_w += truck_weights[i];
            i++;
        }
    }
    
    return time;
}