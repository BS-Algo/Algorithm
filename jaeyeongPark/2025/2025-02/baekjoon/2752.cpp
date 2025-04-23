#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int arr[3]; 

    cin >> arr[0] >> arr[1] >> arr[2]; // 세 정수 입력
    sort(arr, arr + 3); // 정렬

    cout << arr[0] << " " << arr[1] << " " << arr[2] << "\n"; // 출력

    return 0;
}
