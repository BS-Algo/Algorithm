#include <iostream>
using namespace std;

// 한수인지 판별하는 함수
bool isHan(int num) {
    if (num < 100) return true; // 1~99는 모두 한수
    
    int a = num / 100;         // 백의 자리
    int b = (num / 10) % 10;   // 십의 자리
    int c = num % 10;          // 일의 자리
    
    return (a - b) == (b - c); // 등차수열 여부 판별
}

int main() {
    int N, count = 0;
    cin >> N;

    for (int i = 1; i <= N; i++) {
        if (isHan(i)) count++;
    }

    cout << count << "\n";
    return 0;
}
