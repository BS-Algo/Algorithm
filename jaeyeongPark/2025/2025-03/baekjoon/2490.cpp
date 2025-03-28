#include <iostream>
using namespace std;

int main() {
    for (int i = 0; i < 3; i++) { // 총 3번의 테스트 케이스
        int cnt = 0; // 0의 개수를 셀 변수
        for (int j = 0; j < 4; j++) {
            int x;
            cin >> x;
            if (x == 0) cnt++; // 0(배)이면 개수 증가
        }

        // 0의 개수에 따라 결과 출력
        if (cnt == 1) cout << "A\n"; // 도
        else if (cnt == 2) cout << "B\n"; // 개
        else if (cnt == 3) cout << "C\n"; // 걸
        else if (cnt == 4) cout << "D\n"; // 윷
        else cout << "E\n"; // 모
    }
    return 0;
}
