#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<int> A(N);
    vector<int> dp(N, 1); // 각 위치에서의 LIS 길이 (자기 자신만 포함해도 길이 1)

    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }

    // DP 수행
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < i; j++) {
            if (A[j] < A[i]) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
    }

    // 가장 긴 LIS 길이 출력
    int answer = *max_element(dp.begin(), dp.end());
    cout << answer << '\n';

    return 0;
}
