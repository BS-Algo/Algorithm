#include <iostream>
#include <queue>
#include <vector>
using namespace std;


//큐 이용
int main() {
    int n, w, L;
    cin >> n >> w >> L;

    queue<int> trucks;
    for (int i = 0; i < n; ++i) {
        int truck;
        cin >> truck;
        trucks.push(truck);
    }

    //다리 길이
    queue<int> bridge;      
    int time = 0;
    int bridge_weight = 0;

    // 다리를 0으로 초기화
    for (int i = 0; i < w; ++i) bridge.push(0);

    while (!trucks.empty() || bridge_weight > 0) {
        time++;

        // 1초 지나면 다리에서 맨 앞 트럭이 나감
        bridge_weight -= bridge.front();
        bridge.pop();

        if (!trucks.empty()) {
            int next = trucks.front();
            if (bridge_weight + next <= L) {
                // 다음 트럭을 다리에 올릴 수 있을떄
                bridge.push(next);
                bridge_weight += next;
                trucks.pop();
            } else {
                // 못 올라가면 0만 추가
                bridge.push(0);
            }
        } else {
            // 트럭이 더 이상 없으면 0만 추가
            bridge.push(0);
        }
    }

    cout << time << '\n';
    return 0;
}
