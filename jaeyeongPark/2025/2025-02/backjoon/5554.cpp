#include <iostream>
using namespace std;

int main() {
    int a, b, c, d;
    cin >> a >> b >> c >> d;

    int total_time = a + b + c + d; // 총 시간 (초 단위)
    cout << total_time / 60 << "\n"; // 분 단위 출력
    cout << total_time % 60 << "\n"; // 초 단위 출력

    return 0;
}
