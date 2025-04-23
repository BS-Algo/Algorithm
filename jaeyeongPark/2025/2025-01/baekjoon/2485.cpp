#include <iostream>
#include <algorithm>
using namespace std;

int arr[100001];

// 유클리드 호제법을 사용하여 최대공약수 계산
int gcd(int a, int b) {
    int c;
    while (b) {
        c = a % b;
        a = b;
        b = c;
    }
    return a;
}

int main() {
    int n;
    cin >> n;

    // 가로수 위치 입력
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    // 가로수 위치 정렬
    sort(arr, arr + n);

    // 모든 간격의 최대공약수 계산
    int k = gcd(arr[1] - arr[0], arr[2] - arr[1]);
    for (int i = 3; i < n; i++) {
        k = gcd(k, arr[i] - arr[i - 1]);
    }

    // 최소 추가 가로수 계산
    int ans = 0;
    for (int i = 1; i < n; i++) {
        ans += (arr[i] - arr[i - 1]) / k - 1;
    }

    cout << ans;
}