#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

// 소수 판별 함수
bool isPrime(int num) {
    if (num < 2) return false;
    int sqrtNum = static_cast<int>(sqrt(num));
    for (int i = 2; i <= sqrtNum; ++i) {
        if (num % i == 0) return false;
    }
    return true;
}

int main() {
    int T;
    cin >> T;

    while (T--) {
        int N;
        cin >> N;

        vector<int> seq(N);
        for (int i = 0; i < N; ++i) {
            cin >> seq[i];
        }

        // 누적 합 계산
        vector<int> prefixSum(N + 1, 0);
        for (int i = 0; i < N; ++i) {
            prefixSum[i + 1] = prefixSum[i] + seq[i];
        }

        bool found = false;
        // 부분 수열의 길이를 1부터 N까지 증가시키며 탐색
        for (int len = 1; len <= N && !found; ++len) {
            for (int start = 0; start <= N - len; ++start) {
                int sum = prefixSum[start + len] - prefixSum[start];
                if (isPrime(sum)) {
                    cout << "Shortest primed subsequence is length " << len << ": ";
                    for (int i = start; i < start + len; ++i) {
                        cout << seq[i] << " ";
                    }
                    cout << endl;
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            cout << "This sequence is anti-primed." << endl;
        }
    }

    return 0;
}
