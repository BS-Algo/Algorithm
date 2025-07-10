#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

int N;
vector<pair<int, int>> ingredients;
int result = INT32_MAX;

void dfs(int idx, int s, int b, bool used) {
    if (idx == N) {
        if (used) {
            result = min(result, abs(s - b));
        }
        return;
    }

    // 현재 재료 사용
    dfs(idx + 1, s * ingredients[idx].first, b + ingredients[idx].second, true);

    // 현재 재료 사용하지 않음
    dfs(idx + 1, s, b, used);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    ingredients.resize(N);
    for (int i = 0; i < N; ++i) {
        cin >> ingredients[i].first >> ingredients[i].second;  // 신맛, 쓴맛
    }

    dfs(0, 1, 0, false);

    cout << result << '\n';
    return 0;
}
