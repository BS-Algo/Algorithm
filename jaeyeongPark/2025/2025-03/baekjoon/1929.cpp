#include <iostream>
#include <vector>

using namespace std;

void sieve(int m, int n) {
    vector<bool> isPrime(n + 1, true); 
    isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아님

    
    for (int i = 2; i * i <= n; i++) {
        if (isPrime[i]) { // i가 소수이면
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false; // i의 배수들은 소수가 아님
            }
        }
    }

    // m 이상 n 이하의 소수 출력
    for (int i = m; i <= n; i++) {
        if (isPrime[i]) {
            cout << i << '\n';
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int m, n;
    cin >> m >> n;

    sieve(m, n);

    return 0;
}
