#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
    int N;
    cin >> N;
    vector<int> diff(N);
    for (int i = 0; i < N; ++i) {
        int A, B;
        cin >> A >> B;
        diff[i] = A - B;
    }
    sort(diff.begin(), diff.end());
    if (N % 2 == 1) {
        cout << 1 << endl;
    } else {
        int mid1 = diff[N / 2 - 1];
        int mid2 = diff[N / 2];
        cout << abs(mid2 - mid1) + 1 << endl;
    }
    return 0;
}
