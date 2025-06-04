#include <iostream>
#include <queue>

using namespace std;

int main() {
    int T;
    cin >> T;

    while (T--) {
        int N, M;
        cin >> N >> M;

        queue<pair<int, int>> q; // {인덱스, 중요도}
        priority_queue<int> pq;  // 가장 높은 중요도 확인용

        for (int i = 0; i < N; ++i) {
            int importance;
            cin >> importance;
            q.push({i, importance});
            pq.push(importance);
        }

        int order = 0;

        while (!q.empty()) {
            int index = q.front().first;
            int importance = q.front().second;
            q.pop();

            // 가장 높은 중요도 문서가 아니라면 뒤로 보냄
            if (importance < pq.top()) {
                q.push({index, importance});
            } else {
                // 인쇄
                pq.pop();
                order++;
                if (index == M) {
                    cout << order << '\n';
                    break;
                }
            }
        }
    }

    return 0;
}
