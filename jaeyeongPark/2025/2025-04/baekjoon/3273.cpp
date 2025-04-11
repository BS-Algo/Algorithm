#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<int> arr(n);
    bool check[2000001] = {false}; // 입력되는 수의 최대값이 1,000,000

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        check[arr[i]] = true;
    }

    int x;
    cin >> x;

    int count = 0;
    for (int i = 0; i < n; i++) {
        int target = x - arr[i];
        if (target > 0 && check[target]) {
            count++;
        }
    }

    // 하나의 쌍을 두 번 세므로 2로 나눔
    cout << count / 2 << "\n";

    return 0;
}
