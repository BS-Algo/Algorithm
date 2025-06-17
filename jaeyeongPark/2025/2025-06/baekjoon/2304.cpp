#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
using pii = pair<int,int>;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    vector<pii> poles(N);
    for (int i = 0; i < N; ++i) {
        cin >> poles[i].first >> poles[i].second;
    }

    sort(poles.begin(), poles.end());  // 위치 오름차순 정렬

    int maxIdx = 0;
    for (int i = 1; i < N; ++i) {
        if (poles[i].second > poles[maxIdx].second)
            maxIdx = i;
    }

    int area = 0;

    // 왼쪽 구간 (처음부터 최고까지)
    int currentHeight = poles[0].second;
    int currentPos = poles[0].first;
    for (int i = 1; i <= maxIdx; ++i) {
        if (poles[i].second > currentHeight) {
            area += currentHeight * (poles[i].first - currentPos);
            currentHeight = poles[i].second;
            currentPos = poles[i].first;
        }
    }

    // 오른쪽 구간 (끝에서 최고까지)
    currentHeight = poles[N - 1].second;
    currentPos = poles[N - 1].first;
    for (int i = N - 2; i >= maxIdx; --i) {
        if (poles[i].second > currentHeight) {
            area += currentHeight * (currentPos - poles[i].first);
            currentHeight = poles[i].second;
            currentPos = poles[i].first;
        }
    }

    // 최고 기둥 부분 추가
    area += poles[maxIdx].second;

    cout << area << '\n';
    return 0;
}
