#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{

    int N;
    cin >> N;
    vector<int> arr;


    // 입력받기
    for (int i = 0; i < N; i++) {
        int A;
        cin >> A;
        arr.push_back(A);
    }
    // 정렬
    sort(begin(arr), end(arr));

    // 중복제거
    // unique는 중복을 제거하고 중복이 없는 배열 맨 마지막 순서를 반환한다.
    // erase는 구간을 삭제한다. 즉 중복이 없는 배열 맨 마지막 부분부터 배열 끝까지를 지운다
    int min = 0;
    auto newEnd = unique(arr.begin(), arr.end());
    arr.erase(newEnd, arr.end());

    for (int num : arr) {
        cout << num << " ";
    }
    return 0;
}

