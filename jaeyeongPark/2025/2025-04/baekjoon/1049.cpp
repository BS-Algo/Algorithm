#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;

    int minSet = 1001, minSingle = 1001;

    for (int i = 0; i < M; i++) {
        int setPrice, singlePrice;
        cin >> setPrice >> singlePrice;
        minSet = min(minSet, setPrice);
        minSingle = min(minSingle, singlePrice);
    }

    int cost1 = (N / 6) * minSet + (N % 6) * minSingle;      // 세트 + 낱개
    int cost2 = ((N + 5) / 6) * minSet;                      // 전부 세트로만
    int cost3 = N * minSingle;                               // 전부 낱개로만

    cout << min({cost1, cost2, cost3}) << endl;

    return 0;
}
