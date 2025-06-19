#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N;
    cin >> N;

    vector<pair<int, int>> people(N); // (몸무게, 키)

    for (int i = 0; i < N; ++i) {
        cin >> people[i].first >> people[i].second;
    }

    for (int i = 0; i < N; ++i) {
        int rank = 1; // 기본 등수는 1

        for (int j = 0; j < N; ++j) {
            if (i == j) continue;

            if (people[j].first > people[i].first && people[j].second > people[i].second) {
                rank++;
            }
        }

        cout << rank << ' ';
    }

    cout << '\n';
    return 0;
}
