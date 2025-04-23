#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N;
    cin >> N;

    vector<int> boxes(N);
    vector<int> dp(N, 1);  // 최소 1개는 넣을 수 있음

    for (int i = 0; i < N; i++) {
        cin >> boxes[i];
    }

    for (int i = 1; i < N; i++) {
        for (int j = 0; j < i; j++) {
            if (boxes[i] > boxes[j]) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
    }

    int answer = 0;
    for (int i = 0; i < N; i++) {
        answer = max(answer, dp[i]);
    }

    cout << answer << "\n";
    return 0;
}
