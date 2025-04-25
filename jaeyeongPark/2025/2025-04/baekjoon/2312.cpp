#include <iostream>
using namespace std;

int main() {
    int T;
    cin >> T;

    while (T--) {
        int n;
        cin >> n;

        for (int i = 2; i * i <= n; i++) {
            int count = 0;
            while (n % i == 0) {
                n /= i;
                count++;
            }
            if (count > 0) {
                cout << i << " " << count << "\n";
            }
        }

        // 마지막 남은 소수
        if (n > 1) {
            cout << n << " 1\n";
        }
    }

    return 0;
}
