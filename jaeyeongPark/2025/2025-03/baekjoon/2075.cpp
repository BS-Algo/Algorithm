#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    priority_queue<int, vector<int>, greater<int>> pq; // 최소 힙

    for (int i = 0; i < n * n; i++) {
        int num;
        cin >> num;
        pq.push(num);

        if (pq.size() > n) {
            pq.pop(); // N개까지만 유지
        }
    }

    cout << pq.top() << '\n'; // N번째 큰 수 출력

    return 0;
}
