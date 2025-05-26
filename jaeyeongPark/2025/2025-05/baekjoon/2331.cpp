#include <iostream>
#include <vector>
#include <cmath>
#include <unordered_map>

using namespace std;

// 각 자리수의 p제곱을 더하는 함수
int getNext(int num, int p) {
    int sum = 0;
    while (num > 0) {
        int digit = num % 10;
        sum += pow(digit, p);
        num /= 10;
    }
    return sum;
}

int main() {
    int A, P;
    cin >> A >> P;

    unordered_map<int, int> visited; // 수: 몇 번째에 등장했는지 저장
    int count = 0;

    while (true) {
        if (visited.count(A)) {
            // 중복이 처음 발생한 위치 출력
            cout << visited[A] << '\n';
            break;
        }

        visited[A] = count++;
        A = getNext(A, P);
    }

    return 0;
}
