#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<int> origin(N);
    vector<int> sorted;

    for (int i = 0; i < N; ++i) {
        cin >> origin[i];
        sorted.push_back(origin[i]);
    }

    // 중복 제거를 위한 정렬
    sort(sorted.begin(), sorted.end());
    sorted.erase(unique(sorted.begin(), sorted.end()), sorted.end());

    // 값 → 압축 좌표 매핑
    map<int, int> compression;
    for (int i = 0; i < sorted.size(); ++i) {
        compression[sorted[i]] = i;
    }

    // 원래 순서대로 출력
    for (int i = 0; i < N; ++i) {
        cout << compression[origin[i]] << ' ';
    }

    return 0;
}
