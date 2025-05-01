#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N;
    cin >> N;
    vector<int> positions(N);
    vector<int> ranges(N - 1);

    for (int i = 0; i < N; ++i) {
        cin >> positions[i];
    }

    for (int i = 0; i < N - 1; ++i) {
        cin >> ranges[i];
    }

    int max_reach = 0;
    for (int i = 0; i < N - 1; ++i) {
        if (positions[i] > max_reach) {
            cout << "엄마 나 전역 늦어질 것 같아" << endl;
            return 0;
        }
        max_reach = max(max_reach, positions[i] + ranges[i]);
    }

    if (positions[N - 1] <= max_reach) {
        cout << "권병장님, 중대장님이 찾으십니다" << endl;
    } else {
        cout << "엄마 나 전역 늦어질 것 같아" << endl;
    }

    return 0;
}
