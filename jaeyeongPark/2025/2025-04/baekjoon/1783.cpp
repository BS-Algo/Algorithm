#include <iostream>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;

    int result = 0;

    if (N == 1) {
        result = 1;
    }
    else if (N == 2) {
        result = min(4, (M + 1) / 2);
    }
    else {
        if (M < 7) {
            result = min(4, M);
        }
        else {
            result = M - 2;
        }
    }

    cout << result << endl;

    return 0;
}
