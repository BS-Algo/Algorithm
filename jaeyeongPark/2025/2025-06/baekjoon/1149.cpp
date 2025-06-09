#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<vector<int>> cost(N, vector<int>(3));
    vector<vector<int>> dp(N, vector<int>(3));

    // 비용 입력
    for (int i = 0; i < N; ++i) {
        cin >> cost[i][0] >> cost[i][1] >> cost[i][2];
    }

    // 첫 번째 집의 색깔 비용은 그대로
    dp[0][0] = cost[0][0];
    dp[0][1] = cost[0][1];
    dp[0][2] = cost[0][2];

    // DP 계산
    for (int i = 1; i < N; ++i) {
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
    }

    // 마지막 집까지 칠한 뒤 최소 비용 출력
    cout << min({dp[N - 1][0], dp[N - 1][1], dp[N - 1][2]}) << '\n';

    return 0;
}
