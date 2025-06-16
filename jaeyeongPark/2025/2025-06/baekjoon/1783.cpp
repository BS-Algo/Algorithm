#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;

    if (N == 1) {
        // 움직일 수 없음
        cout << 1 << '\n';
    }
    else if (N == 2) {
        // 2번, 3번 이동만 가능 → 최대 4칸
        cout << min(4, (M + 1) / 2) << '\n';
    }
    else {
        if (M < 7) {
            // 이동 방법 제한 → 최대 4칸
            cout << min(4, M) << '\n';
        } else {
            // 모든 방법 가능 → 최대 M - 2 칸
            cout << M - 2 << '\n';
        }
    }

    return 0;
}
