#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<int> ranks(N);
    for (int i = 0; i < N; ++i) {
        cin >> ranks[i];
    }

    sort(ranks.begin(), ranks.end());

    long long total = 0;
    for (int i = 0; i < N; ++i) {
        total += abs(ranks[i] - (i + 1));
    }

    cout << total << '\n';
    return 0;
}
