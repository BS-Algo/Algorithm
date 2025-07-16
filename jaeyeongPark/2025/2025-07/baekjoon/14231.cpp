#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    vector<int> A(n), dp(n, 1);

    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }

    int answer = 1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (A[j] < A[i]) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        answer = max(answer, dp[i]);
    }

    cout << answer << '\n';
    return 0;
}
