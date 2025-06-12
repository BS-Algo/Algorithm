#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
using ll = long long;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    ll t, x;
    int m;
    cin >> t >> x >> m;

    if (m == 0) {
        cout << t * x << "\n";
        return 0;
    }

    vector<pair<ll, ll>> rooms(m);
    for (int i = 0; i < m; i++) {
        cin >> rooms[i].first >> rooms[i].second;  // d, s
    }

    // 효율 기준 정렬: d1/s1 > d2/s2 ⇒ d1*s2 > d2*s1
    sort(rooms.begin(), rooms.end(), [&](auto &a, auto &b) {
        // 비교를 안정적으로 표현
        // cross-multiplication for d1/s1 > d2/s2
        // 상대적으로 큰 불록 더 효율적
        return a.first * b.second > b.first * a.second;
    });

    ll remain = t, total = 0;
    for (auto &[d, s] : rooms) {
        ll need = s;  // 기다리면서 담을 수 있는 주기
        if (remain <= 0) break;

        ll take = min(remain, need);
        total += take * x;
        remain -= take;
    }

    cout << total << "\n";
    return 0;
}
