#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main() {
    long long N, T, P;
    cin >> N;

    vector<long long> sizes(6);
    for (int i = 0; i < 6; i++) {
        cin >> sizes[i];
    }

    cin >> T >> P;

    // 티셔츠 묶음 계산
    long long total = 0;
    for (int i = 0; i < 6; i++) {
        total += (sizes[i] + T - 1) / T; // 올림 나눗셈
    }

    // 펜 묶음 계산
    long long pen= N / P;
    long long remain = N % P;

    // 결과 출력
    cout << total << endl;
    cout << pen << " " << remain << endl;

    return 0;
}
