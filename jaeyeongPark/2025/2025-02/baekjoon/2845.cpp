#include <iostream>
using namespace std;

int main() {
    int L, P, total;
    cin >> L >> P;
    
    total = L * P;  // 실제 참가자 수

    for (int i = 0; i < 5; i++) {
        int num;
        cin >> num;
        cout << num - total << " ";
    }

    return 0;
}
