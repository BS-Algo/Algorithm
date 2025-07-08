#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    // 최소 길이는 자기 자신
    vector<int> a(n);
    vector<int> dp(n, 1);  

    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    // 가장 긴 감소하는 수열
    for (int i = 1; i < n; ++i) {
        for (int j = 0; j < i; ++j) {
            if (a[j] > a[i]) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
    }

    cout << *max_element(dp.begin(), dp.end()) << '\n';

    return 0;
}
