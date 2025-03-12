#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        arr[i] = i + 1; // 1부터 N까지 초기화
    }
    // 이걸 안쓰면 백트래킹을 써야함
    do {
        for (int i = 0; i < n; i++) {
            cout << arr[i] << ' ';
        }
        cout << '\n';
    } while (next_permutation(arr.begin(), arr.end()));

    return 0;
}