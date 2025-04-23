#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    int result = 0;
    cin >> N;
    cin >> M;

    vector<int> arr(N);

    for (int i = 0; i < N; i++) {
        int a;
        cin >> a;
        arr[i] = a;
    }

    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
            if (arr[i] + arr[j] == M) {
                result++;
                continue;
            }
        }
    }
    cout << result;
	return 0;
}