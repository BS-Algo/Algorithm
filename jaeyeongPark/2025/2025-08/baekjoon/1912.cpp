#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    vector<int> arr(n), dp(n);

    for (int i = 0; i < n; i++) cin >> arr[i];

    dp[0] = arr[0];
    int answer = dp[0];

    for (int i = 1; i < n; i++) {
        dp[i] = max(arr[i], dp[i - 1] + arr[i]);
        answer = max(answer, dp[i]);
    }

    cout << answer;
    return 0;
}
