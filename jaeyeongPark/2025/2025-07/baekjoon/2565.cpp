#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<pair<int, int>> wires(n);
    for (int i = 0; i < n; i++) {
        cin >> wires[i].first >> wires[i].second;
    }

    // A 전봇대 기준으로 정렬
    // 전기줄 A는 A번 전봇대에서 B번 전봇대에 연결
    // 교차되지 않게 해야함
    
    sort(wires.begin(), wires.end());

    
    vector<int> dp(n, 1);
    int result = 1;

    // A기준으로 정렬, B가 증가하는 순서로 정렬되어야함,
    // 최장 증가 부분 수열 활용(LIS)
    // 전체 전기줄 개수 - LIS 길이 = 제거하는 전기줄 수
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (wires[j].second < wires[i].second) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        result = max(result, dp[i]);
    }

    cout << n - result << '\n';
    return 0;
}
