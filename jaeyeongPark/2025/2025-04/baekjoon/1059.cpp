#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int L, n;
    cin >> L;

    vector<int> S(L);
    for (int i = 0; i < L; i++) {
        cin >> S[i];
    }

    cin >> n;

    sort(S.begin(), S.end());

    // n이 S에 포함되어 있으면 답은 0
    if (find(S.begin(), S.end(), n) != S.end()) {
        cout << 0 << "\n";
        return 0;
    }

    int low = 0, high = 1001;
    for (int i = 0; i < L; i++) {
        if (S[i] < n) low = S[i];
        else if (S[i] > n) {
            high = S[i];
            break;
        }
    }

    int result = (n - low) * (high - n) - 1;
    cout << result << "\n";

    return 0;
}
