#include <iostream>
#include <vector>

using namespace std;

int N, S;
int cnt = 0;
vector<int> nums;

void dfs(int idx, int sum) {
    if (idx == N) {
        if (sum == S) cnt++;
        return;
    }

    // 현재 원소 포함
    dfs(idx + 1, sum + nums[idx]);

    // 현재 원소 미포함
    dfs(idx + 1, sum);
}

int main() {
    cin >> N >> S;
    nums.resize(N);

    for (int i = 0; i < N; ++i) {
        cin >> nums[i];
    }

    dfs(0, 0);

    // S가 0이면 공집합도 포함되므로, 공집합(합 0) 제외
    if (S == 0) cnt--;

    cout << cnt << '\n';

    return 0;
}
