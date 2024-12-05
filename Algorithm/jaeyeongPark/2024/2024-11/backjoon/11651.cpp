#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <vector>
#include <list>
#include <tuple>
using namespace std;

int main()
{
    
    int N;
    cin >> N;
    vector<tuple<int, int>> arr;
    

    // 입력받기
    for (int i = 0; i < N; i++) {
        int A, B;
        cin >> A >> B;
        arr.push_back(make_tuple(A, B));
    }
    // get<1>순으로 정렬하되, 만약 get<1>이 같으면 get<0>순으로 정렬해서 보여주기
    sort(arr.begin(), arr.end(), [](const auto& a, const auto& b) {
        if (get<1>(a) == get<1>(b)) {
            return get<0>(a) < get<0>(b);
        }
        return get<1>(a) < get<1>(b);
    });


    for (const auto&t : arr){
        cout << get<0>(t) <<" " << get<1>(t) << "\n";
    }
    return 0;



}
