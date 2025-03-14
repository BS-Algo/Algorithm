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
    
    vector<pair<int, int>> arr(n); 
    vector<int> P(n);

  
    for (int i = 0; i < n; i++) {
        cin >> arr[i].first;
        arr[i].second = i; // 원래 인덱스 저장
    }

    sort(arr.begin(), arr.end());

    // 정렬된 위치를 원래 인덱스에 매칭
    for (int i = 0; i < n; i++) {
        P[arr[i].second] = i;
    }

    // 출력
    for (int i = 0; i < n; i++) {
        cout << P[i] << ' ';
    }
    cout << '\n';

    return 0;
}
