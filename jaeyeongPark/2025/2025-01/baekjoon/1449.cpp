#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 테이프가 연속으로 붙어있는지, 가장 끝 에는 앞으로 0.5 뒤로 0.5가 되어야한다.

    int N, L;
    cin >> N >> L;

    int location[1000];
    int start;
    int tape = 0;

    for (int i = 0; i < N; i++) {
        cin >> location[i];;
    }

    // 오름차순으로 정렬
    // 테이프 길이가 시작지점 부터 다른 누수 지점까지 거리가 되면 필요테이프 수 + 1
    sort(location, location + N);

    start = location[0];

    for (int i = 1; i < N; i++) {
        if (L <= location[i] - start) {
            tape++;
            start = location[i];
        }
    }

    cout << tape + 1;

    return 0;


}