#include <iostream>
using namespace std;

int main() {
    long long F, V, P;
    cin >> F >> V >> P;

    if (P <= V) {
        cout << "-1\n"; // 이익이 절대 발생할 수 없음
    } else {
        cout << (F / (P - V)) + 1 << "\n";
    }

    return 0;
}
