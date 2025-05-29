#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        int N, M;
        cin >> N >> M;

        queue<pair<int, int>> q; // {인덱스, 중요도}
        vector<int> priority;

        for (int i = 0; i < N; i++) {
            int p;
            cin >> p;
            q.push({i, p});
            priority.push_back(p);
        }

        sort(priority.begin(), priority.end(), greater<int>()); // 중요도 내림차순
        int count = 0; // 출력 순서

        while (!q.empty()) {
            int idx = q.front().first;
            int pri = q.front().second;
            q.pop();

            if (pri == priority[count]) {
                count++; // 출력됨

                if (idx == M) {
                    cout << count << '\n';
                    break;
                }
            } else {
                q.push({idx, pri}); // 다시 뒤로
            }
        }
    }

    return 0;
}
