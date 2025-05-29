#include <iostream>
#include <vector>

using namespace std;

int N, S;
int answer = 0;
vector<int> nums;

void dfs(int idx, int sum) {
    if (idx == N) {
        if (sum == S) answer++;
        return;
    }

    // idx번째 숫자를 선택하는 경우
    dfs(idx + 1, sum + nums[idx]);

    // idx번째 숫자를 선택하지 않는 경우
    dfs(idx + 1, sum);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> S;
    nums.resize(N);
    for (int i = 0; i < N; i++) {
        cin >> nums[i];
    }

    dfs(0, 0);

    // 공집합은 제외해야 하므로 S가 0일 경우 1 빼기
    if (S == 0) answer--;

    cout << answer << '\n';

    return 0;
}
